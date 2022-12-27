package lt.vu.courseproject.stockexpertsystem.repositories;

import lt.vu.courseproject.stockexpertsystem.models.indicator.Indicator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends MongoRepository<Indicator, String> {
    Indicator findByName(String name);
}
