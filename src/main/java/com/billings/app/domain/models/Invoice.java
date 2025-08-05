package com.billings.app.domain.models;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Invoice {
    
    private Long id;
    private Long orderId;
    private Double totalAmount;
    private List<String> items;
    private Instant createAt;

}
