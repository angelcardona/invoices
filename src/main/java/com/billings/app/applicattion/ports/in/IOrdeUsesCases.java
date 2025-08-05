package com.billings.app.applicattion.ports.in;

import java.util.List;
import java.util.Optional;

import com.billings.app.domain.models.Order;
import com.billings.app.domain.models.OrderItem;

public interface IOrdeUsesCases {

    Order createOrder(Order order);
    void deleteOrder(Long orderId);
    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();

    Order addItem(Long orderId, OrderItem orderItem);
    Order removeItem(Long orderItemId,Long orderId);
    


}
