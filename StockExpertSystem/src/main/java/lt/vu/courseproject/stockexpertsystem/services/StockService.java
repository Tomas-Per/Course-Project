package lt.vu.courseproject.stockexpertsystem.services;

import lt.vu.courseproject.stockexpertsystem.models.stock.Stock;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface StockService {
    Stock addStock(Stock stock);
    Stock getStock(String ticker);
    List<Boolean> getSuggestion(String algorithm, String ticker);
}
