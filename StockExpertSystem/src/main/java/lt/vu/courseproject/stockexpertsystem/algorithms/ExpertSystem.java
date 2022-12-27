package lt.vu.courseproject.stockexpertsystem.algorithms;

import lombok.Getter;
import lombok.Setter;
import lt.vu.courseproject.stockexpertsystem.models.fact.Fact;
import lt.vu.courseproject.stockexpertsystem.models.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class ExpertSystem {
    private BackwardChaining bc;
    private ForwardChaining fc;
    List<Rule> rules = new ArrayList<>();

    // Goals
    private Fact buy;
    private Fact sell;
    private Fact hold;

    public ExpertSystem() {
        bc = new BackwardChaining();
        fc = new ForwardChaining();

        buy = new Fact("B");
        sell = new Fact("S");
        hold = new Fact("H");

    }

    public List<Boolean> forwardChain(List<Fact> facts) {
        // Run algorithm three times to check all three goals (buy, sell and hold)
        List<Boolean> booleans = new ArrayList<>();
        booleans.add(fc.solve(rules, facts, buy));
        resetFlags();
        booleans.add(fc.solve(rules, facts, sell));
        resetFlags();
        booleans.add(fc.solve(rules, facts, hold));
        resetFlags();
        return booleans;
    }

    public List<Boolean> backwardChain(List<Fact> facts) {

        List<Boolean> booleans = new ArrayList<>();
        booleans.add(bc.solve(rules, facts, buy));
        booleans.add(bc.solve(rules, facts, sell));
        booleans.add(bc.solve(rules, facts, hold));
        return booleans;
    }

    private void resetFlags() {
        for (Rule rule : rules) {
            rule.setFlag1(false);
            rule.setFlag2(false);
        }
    }
}
