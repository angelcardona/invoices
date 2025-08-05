package com.billings.app.infrastructure.adapters.persitence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.billings.app.domain.models.OrderItem;
import com.billings.app.infrastructure.adapters.persitence.entity.OrderEntity;
import com.billings.app.infrastructure.adapters.persitence.entity.OrderItemEntity;

@Mapper(componentModel = "spring")
public interface IOrderItemRepositoryMapper {

    OrderItem toDomain(OrderItemEntity orderItemEntity);
    List<OrderItem> toDomainList(List<OrderItemEntity> orderItemEntities);

    OrderItemEntity toEntity(OrderItem orderItem);
    List<OrderItemEntity> toEntityList(List<OrderItem> orderItems);
}