package lt.vu.courseproject.stockexpertsystem.services;

import lombok.RequiredArgsConstructor;
import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;
import lt.vu.courseproject.stockexpertsystem.repositories.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService{

    private final RuleRepository ruleRepository;

    @Override
    public Rule addRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

}
