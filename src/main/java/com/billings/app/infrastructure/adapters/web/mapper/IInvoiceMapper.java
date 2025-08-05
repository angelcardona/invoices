package com.billings.app.infrastructure.adapters.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.billings.app.domain.models.Invoice;
import com.billings.app.infrastructure.adapters.web.dto.InvoiceDto;

@Mapper(componentModel="spring")
public interface IInvoiceMapper {

    Invoice toDomain(InvoiceDto invoiceDto);
    InvoiceDto toDto(Invoice invoice);
    List<InvoiceDto> tDtoList(List<Invoice> invoices);

}
