package pl.mpazdzior.voucherstore.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mpazdzior.payment.payu.PayU;
import pl.mpazdzior.payment.payu.PayUApiCredentials;
import pl.mpazdzior.payment.payu.http.NetHttpClientPayuHttp;
import pl.mpazdzior.voucherstore.productcatalog.ProductCatalogFacade;
import pl.mpazdzior.voucherstore.sales.basket.InMemoryBasketStorage;
import pl.mpazdzior.voucherstore.sales.offer.OfferMaker;
import pl.mpazdzior.voucherstore.sales.ordering.ReservationRepository;
import pl.mpazdzior.voucherstore.sales.payment.PayUPaymentGateway;
import pl.mpazdzior.voucherstore.sales.payment.PaymentGateway;
import pl.mpazdzior.voucherstore.sales.productd.ProductCatalogProductDetailsProvider;
import pl.mpazdzior.voucherstore.sales.productd.ProductDetailsProvider;

import java.util.UUID;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade salesFacade(ProductCatalogFacade productCatalogFacade, OfferMaker offerMaker, PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        var alwaysSameCustomer = UUID.randomUUID().toString();

        return new SalesFacade(
                new InMemoryBasketStorage(),
                productCatalogFacade,
                () -> alwaysSameCustomer,
                (productId) -> true,
                offerMaker,
                paymentGateway,
                reservationRepository
        );
    }

    @Bean
    PaymentGateway payUPaymentGateway(PayU payU) {
        return new PayUPaymentGateway(payU);
    }

    @Bean
    PayU payU() {
        return new PayU(
                PayUApiCredentials.sandbox(),
                new NetHttpClientPayuHttp()
        );
    }

    @Bean
    OfferMaker offerMaker(ProductDetailsProvider productDetailsProvider) {
        return new OfferMaker(productDetailsProvider);
    }

    @Bean
    ProductDetailsProvider productDetailsProvider(ProductCatalogFacade productCatalogFacade) {
        return new ProductCatalogProductDetailsProvider(productCatalogFacade);
    }
}