package com.example.dio.service;

import com.example.dio.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    void sampleTest() {
        assertNotNull(orderService);
    }
}
