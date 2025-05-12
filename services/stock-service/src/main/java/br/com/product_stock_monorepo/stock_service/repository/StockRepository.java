package br.com.product_stock_monorepo.stock_service.repository;

import br.com.product_stock_monorepo.stock_service.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
