package com.billings.app.applicattion.ports.in;

import com.billings.app.domain.models.Invoice;
import com.billings.app.domain.models.Order;

public interface IInvoiceUsesCases {

    Order acceptOrder(Long orderId);

    Order cancelOrder(Long orderId);

    Invoice generateInvoice(Long orderId);

}
