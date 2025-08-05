package com.billings.app.infrastructure.adapters.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billings.app.applicattion.ports.in.IOrdeUsesCases;
import com.billings.app.domain.models.Order;
import com.billings.app.infrastructure.adapters.web.dto.OrderDto;
import com.billings.app.infrastructure.adapters.web.dto.OrderItemDto;
import com.billings.app.infrastructure.adapters.web.mapper.IOrderItemWebMapper;
import com.billings.app.infrastructure.adapters.web.mapper.OrderWebMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrdeUsesCases usesCases;
    private final OrderWebMapper mapper;
    private final IOrderItemWebMapper itemMpper;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDtoRequest){
        OrderDto orderdto =mapper.toDto(usesCases.createOrder(mapper.toDomain(orderDtoRequest)));
        return ResponseEntity.ok(orderdto);

    }
    @DeleteMapping("{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        usesCases.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
    @GetMapping("{orderId}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long orderId){
        return usesCases.getOrderById(orderId)  
                        .map(mapper::toDto)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll(){
        List<OrderDto> orderDtos = mapper.toDtoList(usesCases.getAllOrders());
        return ResponseEntity.ok(orderDtos);
    }
    @PostMapping("addItem/{orderId}")
    public ResponseEntity<OrderDto> addOrderItem(@PathVariable Long orderId, @Valid @RequestBody OrderItemDto orderItemDto){
        Order order = usesCases.addItem(orderId,itemMpper.toDomain(orderItemDto));
        OrderDto orderDto=mapper.toDto(order);
        return new ResponseEntity<>(orderDto,HttpStatus.OK);

    }
    @DeleteMapping("removeItem/{ordeId}/{orderItem}")
    public ResponseEntity<OrderDto> removeItem(@PathVariable Long orderId,@PathVariable Long orderItem){
        Order order = usesCases.removeItem(orderItem, orderId);
        OrderDto orderDto = mapper.toDto(order);
        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }


    
    
    


}
