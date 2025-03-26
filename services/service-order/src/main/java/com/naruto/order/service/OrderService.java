package com.naruto.order.service;

import com.naruto.order.bean.Order;

public interface OrderService {
    Order create(Long userId, Long productId);
}
