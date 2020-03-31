package org.tony.carrentalservice.dao;

import org.springframework.stereotype.Repository;
import org.tony.carrentalservice.model.OrderInfo;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> selectByConditions(Map<String, Object> conditions);
}