package pl.mpazdzior.voucherstore.sales.payment;

import pl.mpazdzior.payment.payu.exceptions.PayUException;

public class PaymentException extends IllegalStateException {
    public PaymentException(PayUException e) {
        super(e);
    }
}