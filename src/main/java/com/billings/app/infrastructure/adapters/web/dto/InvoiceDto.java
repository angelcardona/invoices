package com.billings.app.infrastructure.adapters.web.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Long id;
    private Long orderId;
    private BigDecimal totalAmount;
    private List<String> items;
    private Instant createAt;
}
