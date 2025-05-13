package br.com.product_stock_monorepo.stock_service.controller;

import br.com.product_stock_monorepo.stock_service.model.Stock;
import br.com.product_stock_monorepo.stock_service.model.dto.StockItemDTO;
import br.com.product_stock_monorepo.stock_service.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping({"", "/"})
    public List<StockItemDTO> listAll(){
        List<Stock> stock = this.stockService.listAll();
        List<StockItemDTO> stockItems = new ArrayList<>();
        stock.forEach(item -> {
            stockItems.add(new StockItemDTO(item.getId(), "", item.getQuantity()));
        });
        return stockItems;
    }

    @PostMapping("/increase")
    public StockItemDTO increaseStockItem(@RequestBody IncreaseDecreaseRequest increaseDecreaseRequest){
        Stock stockItem = this.stockService.increaseStock(increaseDecreaseRequest.getProductId(), increaseDecreaseRequest.getAmount());
        return new StockItemDTO(stockItem.getId(), "", stockItem.getQuantity());
    }

    @PostMapping("/decrease")
    public StockItemDTO decreaseStockItem(@RequestBody IncreaseDecreaseRequest increaseDecreaseRequest){
        Stock stockItem = this.stockService.decreaseStock(increaseDecreaseRequest.getProductId(), increaseDecreaseRequest.getAmount());
        return new StockItemDTO(stockItem.getId(), "", stockItem.getQuantity());
    }
}
