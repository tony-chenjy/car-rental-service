package org.tony.carrentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tony.carrentalservice.dao.CarInfoMapper;
import org.tony.carrentalservice.dao.OrderInfoMapper;
import org.tony.carrentalservice.dto.CarInfoDTO;
import org.tony.carrentalservice.dto.OrderInfoDTO;
import org.tony.carrentalservice.model.CarInfo;
import org.tony.carrentalservice.model.OrderInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tony.chenjy
 * @date 2020-03-29
 */
@Service
public class OrderInfoService {

    private static final Object lock = new Object();

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private CarInfoMapper carInfoMapper;

    public void add() {}

    public void delete() {}

    public void update(Long id, Short status) {
        OrderInfo model = this.orderInfoMapper.selectByPrimaryKey(id);
        model.setStatus(status);
        model.setGmtModified(new Date());
        this.orderInfoMapper.updateByPrimaryKey(model);
    }

    public List<OrderInfo> selectByConditions(String userName, Date startTime, Date endTime, Short status) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("userName", userName);
        conditions.put("startTime", startTime);
        conditions.put("endTime", endTime);
        conditions.put("status", status);
        return this.orderInfoMapper.selectByConditions(conditions);
    }

    public void book(String carModel, String username, Date startTime, Date endTime) throws Exception {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("carStatus", CarInfoDTO.STATUS_ENABLE);
        conditions.put("carModel", carModel);
        conditions.put("orderStatus", OrderInfoDTO.STATUS_PENDING);
        conditions.put("startTime", startTime);
        conditions.put("endTime", endTime);

        synchronized (lock) {
            CarInfo carInfo = this.carInfoMapper.selectOneByConditions(conditions);
            if (carInfo == null) {
                throw new Exception("本车型已没有库存");
            }

            OrderInfo model = new OrderInfo();
            model.setUserName(username);
            model.setCarId(carInfo.getId());
            model.setStartTime(startTime);
            model.setEndTime(endTime);
            model.setStatus(OrderInfoDTO.STATUS_PENDING);

            this.orderInfoMapper.insert(model);
        }
    }

}
