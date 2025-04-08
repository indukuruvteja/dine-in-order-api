package com.example.dio.service.interfaces;

import com.example.dio.dto.BillDTO;

public interface BillService {
    BillDTO generateBill(Long tableId);
}
