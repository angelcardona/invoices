package com.billings.app.applicattion.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.billings.app.applicattion.ports.in.IOrdeUsesCases;
import com.billings.app.applicattion.ports.out.IOrderPersistence;
import com.billings.app.domain.models.Order;
import com.billings.app.domain.models.OrderItem;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class OrderService implements IOrdeUsesCases{
    
    private final IOrderPersistence persistence;
    
    
    
    @Override
    public Order createOrder(Order order) {
        return persistence.save(order);

        
    }


    @Override
    public void  deleteOrder(Long orderId) {
        persistence.delete(orderId);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return persistence.findOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return persistence.findAll();
    }

    @Override
    public Order addItem(Long orderId, OrderItem orderItem) {
        Optional<Order>orderEXisting= persistence.findOrderById(orderId);
        if (orderEXisting.isPresent()) {
            Order order = orderEXisting.get();
            order.addItem(orderItem);
            return persistence.save(order);
            
        }else{
            throw new RuntimeException("Order not Found By Id");
        }
    }

    @Override
    public Order removeItem(Long orderId,Long orderItemId) {
        Optional<Order> orderExisting=persistence.findOrderById(orderId);
        if(orderExisting.isPresent()){
            Order order = orderExisting.get();
            order.removeItem(orderItemId);
            return persistence.save(order);
        }else{
            throw new RuntimeException("Order dont found by id");
        }
    }
    

    

}
