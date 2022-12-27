package lt.vu.courseproject.stockexpertsystem;

import lt.vu.courseproject.stockexpertsystem.algorithms.ExpertSystem;
import lt.vu.courseproject.stockexpertsystem.models.indicator.EconomicIndicators;
import lt.vu.courseproject.stockexpertsystem.repositories.IndicatorRepository;
import lt.vu.courseproject.stockexpertsystem.repositories.RuleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockExpertSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockExpertSystemApplication.class, args);

        ExpertSystem expertSystem = SpringContext.getBean(ExpertSystem.class);
        EconomicIndicators economicIndicators = SpringContext.getBean(EconomicIndicators.class);
        RuleRepository ruleRepository = SpringContext.getBean(RuleRepository.class);
        IndicatorRepository indicatorRepository = SpringContext.getBean(IndicatorRepository.class);

        expertSystem.setRules(ruleRepository.findAll());
        economicIndicators.setGDP(indicatorRepository.findByName("GDP"));
        economicIndicators.setInflation(indicatorRepository.findByName("INF"));
        economicIndicators.setInterestRate(indicatorRepository.findByName("IR"));
    }

}
