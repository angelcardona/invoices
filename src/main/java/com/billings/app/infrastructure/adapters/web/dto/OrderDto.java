package com.billings.app.infrastructure.adapters.web.dto;

import java.time.LocalDate;
import java.util.List;

import com.billings.app.domain.models.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private OrderStatus status;
    private LocalDate createdAt;
    private List<OrderItemDto> items;
}