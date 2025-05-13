package br.com.product_stock_monorepo.stock_service.model;

import br.com.product_stock_monorepo.stock_service.exception.InvalidStockQuantityAmountException;
import br.com.product_stock_monorepo.stock_service.exception.InvalidStockQuantityException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private int productId;

    public void increase(int amount){
        if (amount < 0) {
            throw new InvalidStockQuantityAmountException();
        }
        this.quantity += amount;
    }

    public void decrease(int amount){
        if (amount < 0) {
            throw new InvalidStockQuantityAmountException();
        }
        if (this.quantity - amount < 0){
            throw new InvalidStockQuantityException(this);
        }
        this.quantity -= amount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
