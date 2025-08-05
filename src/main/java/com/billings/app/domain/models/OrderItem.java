package com.billings.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Long id;
    private Integer quantity;
    private Dish dish;
    private Order order;

    public Double getTotal(){
        
        return this.quantity * dish.getPrice();
    }

}
