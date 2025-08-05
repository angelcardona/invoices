package com.billings.app.infrastructure.adapters.persitence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billings.app.infrastructure.adapters.persitence.entity.OrderItemEntity;

public interface IOrderItemJpaRepository extends JpaRepository<OrderItemEntity,Long> {

    List<OrderItemEntity> findOrderItemsByOrderId(Long orderId);

}
