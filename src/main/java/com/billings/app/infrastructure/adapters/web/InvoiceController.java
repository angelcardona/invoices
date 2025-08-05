package com.billings.app.infrastructure.adapters.web;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billings.app.applicattion.ports.in.IInvoiceUsesCases;
import com.billings.app.infrastructure.adapters.web.dto.InvoiceDto;
import com.billings.app.infrastructure.adapters.web.dto.OrderDto;
import com.billings.app.infrastructure.adapters.web.mapper.IInvoiceMapper;
import com.billings.app.infrastructure.adapters.web.mapper.OrderWebMapper;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final IInvoiceMapper mapper;
    private final IInvoiceUsesCases usesCases;
    private final OrderWebMapper orderMapper;

    @PostMapping
    public ResponseEntity<InvoiceDto> generateInvoice(@PathVariable Long orderId){
        InvoiceDto invoiceDto= mapper.toDto(usesCases.generateInvoice(orderId));
        return ResponseEntity.ok(invoiceDto);
    }
    @PostMapping
    public ResponseEntity<OrderDto> acceptOrder(@PathVariable Long orderId){
        Order order = usesCases.acceptOrder(orderId);
    }




}
