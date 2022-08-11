package com.ahb.service;

import com.ahb.dto.OrderDto;

import java.util.List;

public interface OrderService {

    public OrderDto createNewOrder(OrderDto orderDto);
    public OrderDto getOrderById(int orderId);
    public OrderDto updateOrderById(int orderId, OrderDto orderDto);
    public Boolean removeOrderById(int orderId);
}
