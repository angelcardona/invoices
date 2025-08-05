package com.billings.app.infrastructure.adapters.persitence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.billings.app.applicattion.ports.out.IInvoicePersistencePort;
import com.billings.app.domain.models.Invoice;
import com.billings.app.infrastructure.adapters.persitence.mapper.IInvoiceRepositoryMapper;
import com.billings.app.infrastructure.adapters.persitence.repository.IInvoiceJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InvoicePersistenceAdapter implements IInvoicePersistencePort{

    private final IInvoiceJpaRepository repository;
    private final IInvoiceRepositoryMapper mapper;

    @Override
    public Invoice save(Invoice invoice) {
        return mapper.toDomain(repository.save(mapper.toEntity(invoice)));
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Invoice> findAll() {
        return mapper.toDomainList(repository.findAll());
    }

}
