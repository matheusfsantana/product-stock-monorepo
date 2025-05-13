package br.com.product_stock_monorepo.stock_service.controller;

import br.com.product_stock_monorepo.stock_service.exception.InvalidStockQuantityAmountException;
import br.com.product_stock_monorepo.stock_service.exception.InvalidStockQuantityException;
import br.com.product_stock_monorepo.stock_service.exception.ProductIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidStockQuantityAmountException.class)
    public ResponseEntity<?> handle(InvalidStockQuantityAmountException e){
        return ResponseEntity.badRequest().body(Map.of("msg", e.getMessage()));
    }

    @ExceptionHandler(InvalidStockQuantityException.class)
    public ResponseEntity<?> handle(InvalidStockQuantityException e){
        return ResponseEntity.badRequest().body(Map.of("msg", e.getMessage()));
    }

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<?> handle(ProductIdNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", e.getMessage()));
    }
}
