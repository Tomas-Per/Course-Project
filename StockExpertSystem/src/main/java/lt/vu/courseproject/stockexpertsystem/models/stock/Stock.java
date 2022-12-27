package lt.vu.courseproject.stockexpertsystem.models.stock;

import lombok.Data;
import lt.vu.courseproject.stockexpertsystem.models.fact.Fact;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "StockInfo")
public class Stock {

    private String ticker;
    private List<StockWeeklySeries> series;

    public List<Fact> getFacts() {
        List<Fact> facts = new ArrayList<>();

        Info info0 = series.get(0).info;
        Info info1 = series.get(1).info;

        facts.add(new Fact((info0.open > info1.open) ? "OP_R" : "OP_F"));
        facts.add(new Fact((info0.close > info1.close) ? "CP_R" : "CP_F"));
        facts.add(new Fact((info0.low > info1.low) ? "LP_R" : "LP_F"));
        facts.add(new Fact((info0.high > info1.high) ? "HP_R" : "HP_F"));
        facts.add(new Fact((info0.volume > info1.volume) ? "VOL_R" : "VOL_F"));

        return facts;
    }
}
