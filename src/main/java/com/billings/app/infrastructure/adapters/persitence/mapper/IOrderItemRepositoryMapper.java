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

 // Mapeo de Entidad a Dominio (lo que faltaba)
    // Se crea un objeto Dish anidado con los datos de la entidad
    @Mapping(source = "dishId", target = "dish.id")
    @Mapping(source = "dishName", target = "dish.name")
    @Mapping(source = "price", target = "dish.price")
    @Mapping(target = "order", ignore = true)
    OrderItem toDomain(OrderItemEntity orderItemEntity);
    
    List<OrderItem> toDomainList(List<OrderItemEntity> orderItemEntities);
    
    // Mapeo de Dominio a Entidad (ya lo habíamos ajustado)
    @Mapping(source = "dish.id", target = "dishId")
    @Mapping(source = "dish.name", target = "dishName")
    @Mapping(source = "dish.price", target = "price")
    OrderItemEntity toEntity(OrderItem orderItem);
    
    List<OrderItemEntity> toEntityList(List<OrderItem> orderItems);
}