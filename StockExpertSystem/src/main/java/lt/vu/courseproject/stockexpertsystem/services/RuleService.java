package lt.vu.courseproject.stockexpertsystem.services;

import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface RuleService {
    Rule addRule(Rule rule);
    List<Rule> getAllRules();
}
