package org.tony.carrentalservice.dao;

import org.springframework.stereotype.Repository;
import org.tony.carrentalservice.model.CarInfo;

import java.util.List;
import java.util.Map;

@Repository
public interface CarInfoMapper {

    List<String> selectModelsByConditions(Map<String, Object> conditions);

    int deleteByPrimaryKey(Long id);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);
}