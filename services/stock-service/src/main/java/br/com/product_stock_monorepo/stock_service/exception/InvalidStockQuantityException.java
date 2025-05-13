package br.com.product_stock_monorepo.stock_service.exception;

import br.com.product_stock_monorepo.stock_service.model.Stock;

public class InvalidStockQuantityException extends RuntimeException {
    private final Stock stockItem;

    public InvalidStockQuantityException(Stock stockItem){
        this.stockItem = stockItem;
    }
    @Override
    public String getMessage(){
        return "Não é possível deixar o estoque negativo. stockId: " + this.stockItem.getId();
    }
}
