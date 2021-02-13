package pl.mpazdzior.voucherstore.sales.productd;

public interface ProductDetailsProvider {
    ProductDetails getByProductId(String productId);
}