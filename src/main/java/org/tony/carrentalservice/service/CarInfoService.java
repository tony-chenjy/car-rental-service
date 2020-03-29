package org.tony.carrentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tony.carrentalservice.dao.CarInfoMapper;

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

    public List<String> selectModelsByConditions(Map<String, Object> conditions) {
        return this.carInfoMapper.selectModelsByConditions(conditions);
    }

}
