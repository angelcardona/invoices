package com.billings.app.infrastructure.adapters.persitence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.billings.app.domain.models.Order;
import com.billings.app.infrastructure.adapters.persitence.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface IOrderRepositoryMapper {

    Order toDomain(OrderEntity orderEntity);
    OrderEntity toEntity(Order order);
    List<Order> toDomainList(List<OrderEntity> orderEntities);

}
