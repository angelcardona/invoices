package com.billings.app.applicattion.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.billings.app.applicattion.ports.in.IOrdeUsesCases;
import com.billings.app.applicattion.ports.out.IOrderPersistence;
import com.billings.app.domain.models.Dish;
import com.billings.app.domain.models.Order;
import com.billings.app.domain.models.OrderItem;
import com.billings.app.infrastructure.adapters.webClient.DishClient;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class OrderService implements IOrdeUsesCases{
    
    private final IOrderPersistence persistence;
    private final DishClient dishClient;
    
    
    
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
        Order order = persistence.findOrderById(orderId)
                    .orElseThrow(()-> new RuntimeException());
        try {
            Long dishId =orderItem.getDish().getId();
            Dish dish = dishClient.getDishById(dishId);
            orderItem.setDish(dish);
            order.addItem(orderItem);
            return persistence.save(order);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Dish Not Found in menu service");
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
