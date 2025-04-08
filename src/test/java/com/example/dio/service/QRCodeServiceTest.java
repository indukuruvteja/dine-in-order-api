package com.example.dio.service;

import com.example.dio.service.impl.QRCodeServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QRCodeServiceTest {

    private final QRCodeServiceImpl qrCodeService = new QRCodeServiceImpl();

    @Test
    void sampleTest() {
        assertNotNull(qrCodeService);
    }
}
