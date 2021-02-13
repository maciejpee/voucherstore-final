package pl.mpazdzior.voucherstore.sales;

public interface Inventory {
    boolean isAvailable(String productId);
}