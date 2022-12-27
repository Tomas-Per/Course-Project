package lt.vu.courseproject.stockexpertsystem.controllers;

import lombok.RequiredArgsConstructor;
import lt.vu.courseproject.stockexpertsystem.models.stock.Stock;
import lt.vu.courseproject.stockexpertsystem.services.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/{ticker}")
    public Stock getStock(@PathVariable String ticker) {
        return stockService.getStock(ticker.toUpperCase());
    }

    @GetMapping("/suggestion/{algorithm}/{ticker}")
    public List<Boolean> getSuggestion(@PathVariable String algorithm, @PathVariable String ticker) {
        return stockService.getSuggestion(algorithm, ticker);
    }

}
