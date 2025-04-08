package com.example.dio.service.impl;

import com.example.dio.dto.OrderDTO;
import com.example.dio.entity.Order;
import com.example.dio.repository.OrderRepository;
import com.example.dio.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setTableNo(orderDTO.getTableNo());
        order.setFoodItems(orderDTO.getFoodItems());

        double total = order.getFoodItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        order.setTotalAmount(total);

        order = orderRepository.save(order);

        orderDTO.setId(order.getId());
        orderDTO.setTotalAmount(total);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrdersByTableId(Long tableId) {
        List<Order> orders = orderRepository.findByTableNo(tableId);

        return orders.stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setTableNo(order.getTableNo());
            dto.setFoodItems(order.getFoodItems());
            dto.setTotalAmount(order.getTotalAmount());
            return dto;
        }).collect(Collectors.toList());
    }
}
