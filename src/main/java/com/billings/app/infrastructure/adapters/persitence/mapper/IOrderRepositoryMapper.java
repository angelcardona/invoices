package com.billings.app.infrastructure.adapters.persitence.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import com.billings.app.domain.models.Order;
import com.billings.app.infrastructure.adapters.persitence.entity.OrderEntity;
import com.billings.app.infrastructure.adapters.persitence.entity.OrderItemEntity;

@Mapper(componentModel = "spring", uses = IOrderItemRepositoryMapper.class)
public interface IOrderRepositoryMapper {

    
    OrderEntity toEntity(Order order);

    Order toDomain(OrderEntity orderEntity);

    // Mapeo de la entidad JPA al dominio.
    List<Order> toDomainList(List<OrderEntity> orderEntity);

    // Método que se ejecuta DESPUÉS del mapeo para establecer el 'back-reference'.
    @AfterMapping
    default void setOrderEntity(@MappingTarget OrderEntity orderEntity) {
        if (orderEntity.getItems() != null) {
            for (OrderItemEntity item : orderEntity.getItems()) {
                item.setOrder(orderEntity);
            }
        }
    }
}