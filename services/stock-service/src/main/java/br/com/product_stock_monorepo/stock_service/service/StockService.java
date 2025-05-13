package br.com.product_stock_monorepo.stock_service.service;

import br.com.product_stock_monorepo.stock_service.exception.InvalidStockQuantityAmountException;
import br.com.product_stock_monorepo.stock_service.exception.InvalidStockQuantityException;
import br.com.product_stock_monorepo.stock_service.exception.ProductIdNotFoundException;
import br.com.product_stock_monorepo.stock_service.model.Stock;
import br.com.product_stock_monorepo.stock_service.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public List<Stock> listAll(){
        return this.stockRepository.findAll();
    }

    public Stock increaseStock(int productId, int increaseAmount){
        Stock item = this.stockRepository.findByProductId((productId));
        if (Objects.isNull(item)){
            throw new ProductIdNotFoundException();
        }
        item.increase(increaseAmount);
        this.stockRepository.save(item);
        return item;
    }

    public Stock decreaseStock(int productId, int decreaseAmount){
        Stock item = this.stockRepository.findByProductId((productId));
        if (Objects.isNull(item)){
            throw new ProductIdNotFoundException();
        }
        item.decrease(decreaseAmount);
        this.stockRepository.save(item);
        return item;
    }
}
