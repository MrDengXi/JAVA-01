package com.linyuan.geektime.rusticolusrpcdemoprovider.service;

import com.linyuan.geektime.rusticolusrpcdemoapi.domain.Order;
import com.linyuan.geektime.rusticolusrpcdemoapi.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @Author linyuan
 * @desc:描述
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "linyuan", 5000_000.0f);
    }
}