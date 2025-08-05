package com.billings.app.infrastructure.adapters.persitence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billings.app.infrastructure.adapters.persitence.entity.InvoiceEntity;

public interface IInvoiceJpaRepository extends JpaRepository<InvoiceEntity,Long> {

}
