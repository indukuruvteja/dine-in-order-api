package com.example.dio.service.interfaces;

import java.io.ByteArrayOutputStream;

public interface QRCodeService {
    ByteArrayOutputStream generateQRCode(String data, int width, int height);
}
