package com.billings.app.infrastructure.adapters.persitence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.billings.app.applicattion.ports.out.IOrderItemPersistence;
import com.billings.app.domain.models.OrderItem;
import com.billings.app.infrastructure.adapters.persitence.mapper.IOrderItemRepositoryMapper;
import com.billings.app.infrastructure.adapters.persitence.repository.IOrderItemJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderItemPersistenceAdapter implements IOrderItemPersistence{

    private final IOrderItemJpaRepository repository;
    private final IOrderItemRepositoryMapper mapper;

    @Override
    public OrderItem save(OrderItem orderItem) {
        return mapper.toDomain(repository.save(mapper.toEntity(orderItem)));
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
       return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<OrderItem> findAllByOrderId(Long orderId) {
       return mapper.toDomainList(repository.findOrderItemsByOrderId(orderId));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
