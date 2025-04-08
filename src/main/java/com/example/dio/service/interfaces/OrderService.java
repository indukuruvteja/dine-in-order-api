package com.example.dio.service.interfaces;

import com.example.dio.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getOrdersByTableId(Long tableId);
}
