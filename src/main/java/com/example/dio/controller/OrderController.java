package com.example.dio.controller;

import com.example.dio.dto.OrderDTO;
import com.example.dio.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        //Done
    }

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDto) {
        OrderDTO savedOrder = orderService.saveOrder(orderDto);
        return ResponseEntity.ok(savedOrder);
    }
}
