package com.billings.app.applicattion.ports.out;

import java.util.List;
import java.util.Optional;

import com.billings.app.domain.models.Invoice;

public interface IInvoicePersistencePort {

    Invoice save(Invoice invoice);
    Optional<Invoice> findById(Long id);
    List<Invoice> findAll();
 
}
