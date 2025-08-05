package com.billings.app.infrastructure.adapters.persitence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.billings.app.domain.models.OrderItem;
import com.billings.app.infrastructure.adapters.persitence.entity.OrderItemEntity;

@Mapper(componentModel = "spring")
public interface IOrderItemRepositoryMapper {

    OrderItem toDomain(OrderItemEntity orderItemEntity);
    OrderItemEntity toEntity(OrderItem orderItem);
    List<OrderItem> toDomainList(List<OrderItemEntity> orderItemEntities );

}
