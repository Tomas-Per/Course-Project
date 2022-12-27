package lt.vu.courseproject.stockexpertsystem.repositories;

import lt.vu.courseproject.stockexpertsystem.models.stock.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
    Stock findByTicker(String ticker);
}
