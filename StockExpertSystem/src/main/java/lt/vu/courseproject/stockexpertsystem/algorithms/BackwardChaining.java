package lt.vu.courseproject.stockexpertsystem.algorithms;

import lt.vu.courseproject.stockexpertsystem.models.fact.Fact;
import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;

import java.util.ArrayList;
import java.util.List;

class BackwardChaining {

    private List<Fact> initialFacts;

    public boolean solve(List<Rule> rulesList, List<Fact> facts, Fact goal) {
        initialFacts = new ArrayList<>(facts);
        List<Fact> currentGaols = new ArrayList<>();
        return solve(rulesList, facts, goal, currentGaols);
    }

    private boolean solve(List<Rule> ruleList, List<Fact> facts, Fact goal, List<Fact> currentGoals) {

        if (facts.contains(goal)) {
            return true;
        }
        if (currentGoals.contains(goal)) {
            return false;
        }

        for (Rule rule: ruleList) {
            if (rule.getConsequent().equals(goal)) {
                boolean allTrue = true;
                List<Fact> tmpGoals = new ArrayList<>(rule.getAntecedents());
                List<Fact> newGoals = new ArrayList<>(currentGoals);

                newGoals.add(goal);

                for (Fact tmpGoal: tmpGoals) {
                    if (!solve(ruleList, facts, tmpGoal, newGoals)) {
                        allTrue = false;
                    }
                }

                if (allTrue) {
                    facts.add(goal);
                    return true;
                } else {
                    facts.removeIf(f -> !initialFacts.contains(f));
                }
            }
        }
        return false;
    }
}
