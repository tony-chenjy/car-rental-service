package org.tony.carrentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tony.carrentalservice.dao.CarInfoMapper;
import org.tony.carrentalservice.dto.CarInfoDTO;
import org.tony.carrentalservice.dto.OrderInfoDTO;
import org.tony.carrentalservice.model.CarInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tony.chenjy
 * @date 2020-03-29
 */
@Service
public class CarInfoService {

    @Autowired
    private CarInfoMapper carInfoMapper;

    public void add() {}

    public void delete() {}

    public void update() {}

    public List<String> selectModelsByConditions(Date startTime, Date endTime) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("carStatus", CarInfoDTO.STATUS_ENABLE);
        conditions.put("orderStatus", OrderInfoDTO.STATUS_PENDING);
        conditions.put("startTime", startTime);
        conditions.put("endTime", endTime);
        return this.carInfoMapper.selectModelsByConditions(conditions);
    }

}
