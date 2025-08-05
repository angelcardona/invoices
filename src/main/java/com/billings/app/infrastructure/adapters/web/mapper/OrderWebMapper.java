package com.billings.app.infrastructure.adapters.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.billings.app.domain.models.Order;
import com.billings.app.infrastructure.adapters.web.dto.OrderDto;
@Mapper(componentModel = "spring", uses = IOrderItemWebMapper.class)
public interface OrderWebMapper {

    Order toDomain (OrderDto orderDto);
    OrderDto toDto(Order order);
    List<OrderDto> toDtoList(List<Order> orders);

}
