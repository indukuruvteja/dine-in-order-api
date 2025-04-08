package com.example.dio.service.impl;

import com.example.dio.service.interfaces.QRCodeService;
import com.example.dio.util.QRCodeGenerator;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public ByteArrayOutputStream generateQRCode(String data, int width, int height) {
        return QRCodeGenerator.generateQRCode(data, width, height);
    }
}
