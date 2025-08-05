package com.billings.app.applicattion.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.billings.app.applicattion.ports.in.IInvoiceUsesCases;
import com.billings.app.applicattion.ports.out.IInvoicePersistencePort;
import com.billings.app.applicattion.ports.out.IOrderPersistence;
import com.billings.app.domain.models.Invoice;
import com.billings.app.domain.models.Order;
import com.billings.app.domain.models.OrderStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceServices implements IInvoiceUsesCases{

    private final IInvoicePersistencePort port;
    private final IOrderPersistence orderPersistence;

    @Override
    public Order acceptOrder(Long orderId) {
        Optional<Order> orderPresent =orderPersistence.findOrderById(orderId);
        if (orderPresent.isPresent()) {
            Order order = orderPresent.get();
            order.swithToAcepted();
            return orderPersistence.save(order);
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public Order cancelOrder(Long orderId) {
        Optional<Order> orderPresent =orderPersistence.findOrderById(orderId);
        if (orderPresent.isPresent()) {
            Order order = orderPresent.get();
            order.swithcToCanceled();
            return orderPersistence.save(order);
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public Invoice generateInvoice(Long orderId) {
        Order orderPresent= orderPersistence.findOrderById(orderId)
                                    .orElseThrow(() -> new IllegalArgumentException("Not found"));
            
        if(orderPresent.getStatus()!= OrderStatus.ACCEPTED){
            throw new IllegalArgumentException();
        }
        List<String> itemDescriptions=orderPresent.getItems().stream()
            .map(item-> item.getDish() + " x " + item.getQuantity())
            .collect(Collectors.toList());
            
            Invoice invoice = new Invoice(null, orderPresent.getId(), orderPresent.getTotalAmount(), itemDescriptions, Instant.now());
            return port.save(invoice);
    }

}
