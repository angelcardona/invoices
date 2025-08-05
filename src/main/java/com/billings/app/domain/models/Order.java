package com.billings.app.domain.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private List<OrderItem> items= new ArrayList<>();
    private OrderStatus status= OrderStatus.PENDING;
    private LocalDate createdAt;

    public void swithToAcepted(){
        this.status=OrderStatus.ACCEPTED;
    }
    public void swithcToCanceled(){
        this.status = OrderStatus.CANCELED;
    }
    public Double getTotalAmount(){
        Double total = items.stream()
                    .collect(Collectors.summingDouble(OrderItem::getTotal));
        return total;
    }
    public void addItem(OrderItem orderItem){
        this.items.add(orderItem);
        orderItem.setOrder(this);

    }
    public void removeItem(Long orderItem){
        this.items.removeIf(item->item.getId().equals(orderItem));
    }

}
