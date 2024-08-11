package com.at2024.cloud.order;

import com.at2024.cloud.entities.Order;

/**
 * @author lyh
 * @date 2024-08-11 18:16:35
 */
public interface OrderService {
    /**
     * 创建订单AT
     */
    void create(Order order);
}
