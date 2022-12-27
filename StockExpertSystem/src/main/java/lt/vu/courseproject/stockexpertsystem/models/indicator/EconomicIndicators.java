package lt.vu.courseproject.stockexpertsystem.models.indicator;


import lombok.Getter;
import lombok.Setter;
import lt.vu.courseproject.stockexpertsystem.models.fact.Fact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class EconomicIndicators {
    Indicator GDP;
    Indicator inflation;
    Indicator interestRate;

    public List<Fact> getFacts() {
        List<Fact> facts = new ArrayList<>();
        facts.add(new Fact((GDP.data.get(0).value > GDP.data.get(1).value) ? "GDP_R" : "GDP_F"));
        facts.add(new Fact((inflation.data.get(0).value > inflation.data.get(1).value) ? "INF_R" : "INF_F"));
        facts.add(new Fact((interestRate.data.get(0).value > interestRate.data.get(1).value) ? "IR_R" : "IR_F"));
        return facts;
    }

}
