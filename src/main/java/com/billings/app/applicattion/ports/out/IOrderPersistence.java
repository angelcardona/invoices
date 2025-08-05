package com.billings.app.applicattion.ports.out;

import java.util.List;
import java.util.Optional;

import com.billings.app.domain.models.Order;

public interface IOrderPersistence {

    Order save(Order order);
    Optional<Order> findOrderById(Long id);
    List<Order> findAll();
    void delete(Long id);

}
