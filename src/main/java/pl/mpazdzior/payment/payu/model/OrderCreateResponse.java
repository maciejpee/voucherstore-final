package pl.mpazdzior.payment.payu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCreateResponse {
    private String redirectUri;
    private String orderId;
    private String extOrderId;
}