package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.AnalyticsResponse;
import com.devanktu.ecommerce.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();

}
