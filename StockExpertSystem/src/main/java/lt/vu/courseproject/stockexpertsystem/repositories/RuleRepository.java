package lt.vu.courseproject.stockexpertsystem.repositories;

import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends MongoRepository<Rule, String> {
}
