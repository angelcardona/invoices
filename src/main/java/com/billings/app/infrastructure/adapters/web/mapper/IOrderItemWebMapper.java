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
    @Mapping(target = "dish", source = "dishId")
    OrderItem toDomain(OrderItemDto orderItemDto);

    // Método default para evitar el error de mapeo anidado.
    // Esto asegura que el mapeo siempre funcionará.
    default OrderItemDto toDto(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setQuantity(orderItem.getQuantity());

        if (orderItem.getDish() != null) {
            orderItemDto.setDishId(orderItem.getDish().getId());
            orderItemDto.setDishName(orderItem.getDish().getName());
            orderItemDto.setPrice(orderItem.getDish().getPrice());
        }

        return orderItemDto;
    }

    // Método auxiliar para que MapStruct sepa cómo crear un objeto Dish a partir de un Long.
    default Dish fromDishIdToDish(Long dishId) {
        if (dishId == null) {
            return null;
        }
        Dish dish = new Dish();
        dish.setId(dishId);
        return dish;
    }
}
