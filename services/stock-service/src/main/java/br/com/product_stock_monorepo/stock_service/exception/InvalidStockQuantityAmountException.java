package br.com.product_stock_monorepo.stock_service.exception;

public class InvalidStockQuantityAmountException extends RuntimeException {
    @Override
    public String getMessage(){
        return "Não é possível fazer essa operação com um valor menor que zero.";
    }
}
