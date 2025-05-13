package br.com.product_stock_monorepo.stock_service.controller;

public class IncreaseDecreaseRequest {
    private int productId;
    private int amount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
