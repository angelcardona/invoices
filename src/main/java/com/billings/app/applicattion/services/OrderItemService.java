package com.billings.app.applicattion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billings.app.applicattion.ports.in.IOrderItemUsesCases;
import com.billings.app.applicattion.ports.out.IOrderItemPersistence;
import com.billings.app.domain.models.OrderItem;


import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class OrderItemService implements IOrderItemUsesCases{

    private final IOrderItemPersistence repository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<OrderItem> getAllOrderItemByOrderId(Long orderId) {
       return repository.findAllByOrderId(orderId);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public OrderItem updaItem(Long orderItemId, OrderItem orderItem) {
        Optional<OrderItem> orderItemPresent= repository.findById(orderItemId);
        if(orderItemPresent.isPresent()){
            OrderItem item= orderItemPresent.get();
            item.setDishId(orderItem.getDishId());
            item.setDishName(orderItem.getDishName());
            item.setQuantity(orderItem.getQuantity());
            return repository.save(item);

        }else{
            throw new RuntimeException("OrderItem not found by id"+ orderItemId);
        }
    }

}
