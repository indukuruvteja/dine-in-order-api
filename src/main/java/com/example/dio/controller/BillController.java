package com.example.dio.controller;

import com.example.dio.dto.BillDTO;
import com.example.dio.service.interfaces.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/generate/{tableId}")
    public ResponseEntity<BillDTO> generateBill(@PathVariable Long tableId) {
        BillDTO billDTO = billService.generateBill(tableId);
        return ResponseEntity.ok(billDTO);
    }
}
