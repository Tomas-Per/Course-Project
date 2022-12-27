package lt.vu.courseproject.stockexpertsystem;

import lt.vu.courseproject.stockexpertsystem.algorithms.ExpertSystem;
import lt.vu.courseproject.stockexpertsystem.repositories.RuleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockExpertSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockExpertSystemApplication.class, args);
        ExpertSystem expertSystem = SpringContext.getBean(ExpertSystem.class);
        RuleRepository ruleRepository = SpringContext.getBean(RuleRepository.class);
        expertSystem.setRules(ruleRepository.findAll());
    }

}
