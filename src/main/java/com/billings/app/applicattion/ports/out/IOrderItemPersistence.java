package com.billings.app.applicattion.ports.out;

import java.util.List;
import java.util.Optional;

import com.billings.app.domain.models.OrderItem;

public interface IOrderItemPersistence {

    OrderItem save(OrderItem orderItem);
    Optional<OrderItem> findById(Long id);
    List<OrderItem> findAllByOrderId(Long orderId);
    void delete(Long id);

}
