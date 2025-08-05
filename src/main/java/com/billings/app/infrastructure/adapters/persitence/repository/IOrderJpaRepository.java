package com.billings.app.infrastructure.adapters.persitence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billings.app.infrastructure.adapters.persitence.entity.OrderEntity;

public interface IOrderJpaRepository extends JpaRepository<OrderEntity,Long>{

}
