package com.linyuan.geektime.rusticolusrpcdemoapi.service;

import com.linyuan.geektime.rusticolusrpcdemoapi.domain.Order;

/**
 * @Author linyuan
 * @desc:描述
 */
public interface OrderService {
    Order findOrderById(int id);
}
