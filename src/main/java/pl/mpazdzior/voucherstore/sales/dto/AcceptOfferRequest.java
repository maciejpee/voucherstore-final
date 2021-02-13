package pl.mpazdzior.voucherstore.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mpazdzior.voucherstore.sales.ClientDetails;
import pl.mpazdzior.voucherstore.sales.offer.Offer;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcceptOfferRequest {
    @NotNull
    private Offer seenOffer;
    @NotNull
    private ClientDetails clientDetails;
}