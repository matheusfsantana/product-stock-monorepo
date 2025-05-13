package br.com.product_stock_monorepo.stock_service.exception;

import br.com.product_stock_monorepo.stock_service.model.Stock;

public class ProductIdNotFoundException extends RuntimeException {
    @Override
    public String getMessage(){
        return "Produto não encontrado.";
    }
}
