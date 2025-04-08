package com.example.dio.service.impl;

import com.example.dio.dto.BillDTO;
import com.example.dio.dto.OrderDTO;
import com.example.dio.entity.Bill;
import com.example.dio.entity.Order;
import com.example.dio.repository.BillRepository;
import com.example.dio.repository.OrderRepository;
import com.example.dio.service.interfaces.BillService;
import com.example.dio.util.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PdfService pdfService;

    @Override
    public BillDTO generateBill(Long tableId) {
        List<Order> orders = orderRepository.findByTableNo(tableId);
        double totalAmount = orders.stream().mapToDouble(Order::getTotalAmount).sum();

        Bill bill = new Bill();
        bill.setTableNo(tableId);
        bill.setOrders(orders);
        bill.setTotalAmount(totalAmount);
        bill.setRestaurantName("Zomato"); // You can customize this

        bill = billRepository.save(bill);

        // Map to DTO manually
        BillDTO dto = new BillDTO();
        dto.setId(bill.getId());
        dto.setTableNo(bill.getTableNo());
        dto.setRestaurantName(bill.getRestaurantName());
        dto.setTotalAmount(bill.getTotalAmount());

        List<OrderDTO> orderDTOs = orders.stream().map(order -> {
            OrderDTO o = new OrderDTO();
            o.setId(order.getId());
            o.setTableNo(order.getTableNo());
            o.setFoodItems(order.getFoodItems());
            o.setTotalAmount(order.getTotalAmount());
            return o;
        }).collect(Collectors.toList());

        dto.setOrders(orderDTOs);
        return dto;
    }

    @Override
    public BillDTO getBillById(Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        BillDTO dto = new BillDTO();
        dto.setId(bill.getId());
        dto.setTableNo(bill.getTableNo());
        dto.setRestaurantName(bill.getRestaurantName());
        dto.setTotalAmount(bill.getTotalAmount());

        List<OrderDTO> orderDTOs = bill.getOrders().stream().map(order -> {
            OrderDTO o = new OrderDTO();
            o.setId(order.getId());
            o.setTableNo(order.getTableNo());
            o.setFoodItems(order.getFoodItems());
            o.setTotalAmount(order.getTotalAmount());
            return o;
        }).collect(Collectors.toList());

        dto.setOrders(orderDTOs);
        return dto;
    }
}
