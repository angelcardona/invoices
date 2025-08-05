package com.billings.app.infrastructure.adapters.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.billings.app.domain.models.OrderItem;
import com.billings.app.infrastructure.adapters.web.dto.OrderItemDto;
@Mapper(componentModel = "spring")
public interface IOrderItemWebMapper {

    OrderItem toDomain(OrderItemDto orderItemDto);
    OrderItemDto toDto(OrderItem orderItem);
    List<OrderItemDto> toDtoList(List<OrderItem> orderItems);

}
