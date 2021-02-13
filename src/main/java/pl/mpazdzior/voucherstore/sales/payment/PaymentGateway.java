package pl.mpazdzior.voucherstore.sales.payment;

import pl.mpazdzior.payment.payu.exceptions.PayUException;
import pl.mpazdzior.voucherstore.sales.ordering.Reservation;

public interface PaymentGateway {
    PaymentDetails registerFor(Reservation reservation) throws PayUException;

    boolean isTrusted(PaymentUpdateStatusRequest updateStatusRequest);
}