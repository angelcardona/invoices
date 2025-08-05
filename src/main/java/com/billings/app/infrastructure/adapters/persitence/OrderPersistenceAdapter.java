package com.billings.app.infrastructure.adapters.persitence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.billings.app.applicattion.ports.out.IOrderPersistence;
import com.billings.app.domain.models.Order;
import com.billings.app.infrastructure.adapters.persitence.mapper.IOrderRepositoryMapper;
import com.billings.app.infrastructure.adapters.persitence.repository.IOrderJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements IOrderPersistence{

    private final IOrderJpaRepository repository;
    private final IOrderRepositoryMapper mapper;

    @Override
    public Order save(Order order) {
        return mapper.toDomain(repository.save(mapper.toEntity(order)));
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Order> findAll() {
        return mapper.toDomainList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
