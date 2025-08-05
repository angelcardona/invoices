package com.billings.app.infrastructure.adapters.persitence.mapper;

import java.util.List;

import com.billings.app.domain.models.Invoice;
import com.billings.app.infrastructure.adapters.persitence.entity.InvoiceEntity;

public interface IInvoiceRepositoryMapper {

    Invoice toDomain(InvoiceEntity invoiceEntity);
    InvoiceEntity toEntity(Invoice invoice);
    List<Invoice> toDomainList(List<InvoiceEntity> invoiceEntities);

}
