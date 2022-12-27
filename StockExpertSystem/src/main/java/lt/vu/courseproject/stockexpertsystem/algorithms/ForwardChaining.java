package lt.vu.courseproject.stockexpertsystem.algorithms;

import lt.vu.courseproject.stockexpertsystem.models.fact.Fact;
import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;

import java.util.List;

class ForwardChaining {

    public boolean solve(List<Rule> ruleList, List<Fact> facts, Fact goal) {
        if(facts.contains(goal)) {
            return true;
        }

        for (Rule rule: ruleList) {
            if (rule.isFlag1() || rule.isFlag2()) {
                continue;
            }
            if(facts.contains(rule.getConsequent())) {
                rule.setFlag2(true);
            } else {
                boolean allMatch = true;

                for (Fact fact: rule.getAntecedents()) {
                    if(!facts.contains(fact)) {
                        allMatch = false;
                        break;
                    }
                }
                if(allMatch) {
                    facts.add(rule.getConsequent());
                    rule.setFlag1(true);
                    return solve(ruleList, facts, goal);
                }
            }
        }
        return false;
    }
}
