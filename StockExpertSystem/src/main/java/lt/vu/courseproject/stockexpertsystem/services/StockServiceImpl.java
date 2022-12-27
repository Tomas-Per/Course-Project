package lt.vu.courseproject.stockexpertsystem.services;

import lombok.RequiredArgsConstructor;
import lt.vu.courseproject.stockexpertsystem.algorithms.ExpertSystem;
import lt.vu.courseproject.stockexpertsystem.models.stock.Stock;
import lt.vu.courseproject.stockexpertsystem.repositories.StockRepository;
import lt.vu.courseproject.stockexpertsystem.utils.AlphaVantageUtility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{

    private final StockRepository stockRepository;
    private final AlphaVantageUtility avUtil;
    private final ExpertSystem expertSystem;

    @Override
    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public Stock getStock(String ticker) {
        Stock stock = stockRepository.findByTicker(ticker);
        if(stock == null) {
            stock = avUtil.getStockFromAV(ticker);
            addStock(stock);
        }
        return stock;
    }

    @Override
    public List<Boolean> getSuggestion(String algorithm, String ticker) {
        Stock stock = stockRepository.findByTicker(ticker);
        if(algorithm.equals("BC")) {
            return expertSystem.backwardChain(stock.getFacts());
        } else {
            return expertSystem.forwardChain(stock.getFacts());
        }
    }
}
