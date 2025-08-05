package com.billings.app.applicattion.ports.in;

import java.util.List;
import java.util.Optional;

import com.billings.app.domain.models.OrderItem;

public interface IOrderItemUsesCases {

    OrderItem createOrderItem(OrderItem orderItem);
    Optional<OrderItem> getOrderItemById(Long id);
    List<OrderItem> getAllOrderItemByOrderId(Long orderId);
    void delete (Long id);
    OrderItem updaItem(Long orderItemId , OrderItem orderItem);

}
