package com.billings.app.infrastructure.adapters.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billings.app.applicattion.ports.in.IOrderItemUsesCases;

import com.billings.app.infrastructure.adapters.web.dto.OrderItemDto;
import com.billings.app.infrastructure.adapters.web.mapper.IOrderItemWebMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final IOrderItemWebMapper mapper;
    private final IOrderItemUsesCases usesCases;

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@Valid@RequestBody OrderItemDto orderItemRequest){
        OrderItemDto orderItemDto=mapper.toDto(usesCases.createOrderItem(mapper.toDomain(orderItemRequest)));
        return ResponseEntity.ok(orderItemDto);
    }
    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItemDto> getOrderById(@PathVariable Long orderItemId){
        return usesCases.getOrderItemById(orderItemId)
                        .map(mapper::toDto)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItemDto>> getAllByOrderId(@PathVariable Long orderId){
        List<OrderItemDto> orderItems=mapper.toDtoList(usesCases.getAllOrderItemByOrderId(orderId));
        return ResponseEntity.ok(orderItems);
    }
    
    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long orderItemId){
        usesCases.delete(orderItemId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItemDto> updateOrderItem(@PathVariable Long orderItemId,@Valid@RequestBody OrderItemDto orderItemDtoRequest){
       OrderItemDto orderItemDto= mapper.toDto(usesCases.updaItem(orderItemId,mapper.toDomain(orderItemDtoRequest)));
       return ResponseEntity.ok(orderItemDto);
    }


}
