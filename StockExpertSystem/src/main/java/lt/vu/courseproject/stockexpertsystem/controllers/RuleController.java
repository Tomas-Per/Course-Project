package lt.vu.courseproject.stockexpertsystem.controllers;

import lombok.RequiredArgsConstructor;
import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;
import lt.vu.courseproject.stockexpertsystem.services.RuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping("/")
    public List<Rule> getRules() {
        return ruleService.getAllRules();
    }

    @PostMapping("/add")
    public Rule addRule(@RequestBody Rule rule) {
        return ruleService.addRule(rule);
    }

}
