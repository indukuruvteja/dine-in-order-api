package com.example.dio.service;

import com.example.dio.service.impl.BillServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BillServiceTest {

    private final BillServiceImpl billService = new BillServiceImpl();

    @Test
    void sampleTest() {
        assertNotNull(billService);
    }
}
