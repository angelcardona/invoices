package com.billings.app.infrastructure.adapters.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.billings.app.domain.models.Dish;
import com.billings.app.domain.models.OrderItem;
import com.billings.app.infrastructure.adapters.web.dto.OrderItemDto;
@Mapper(componentModel = "spring")
public interface IOrderItemWebMapper {

    // Mapeo de entrada (POST). Se usa el método auxiliar para crear el objeto Dish incompleto.
    @Mapping(target = "dish.id", source = "dishId")
    @Mapping(target = "dish.price", source = "price")
    OrderItem toDomain(OrderItemDto orderItemDto);

    @Mapping(source = "dish.id", target = "dishId")
    @Mapping(source = "dish.name", target = "dishName")
    @Mapping(source = "dish.price", target = "price")
    OrderItemDto toDto(OrderItem orderItem);
}