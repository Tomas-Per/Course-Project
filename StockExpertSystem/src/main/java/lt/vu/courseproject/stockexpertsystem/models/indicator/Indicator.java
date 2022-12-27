package lt.vu.courseproject.stockexpertsystem.models.indicator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "Indicators")
public class Indicator {
    String name;
    List<Data> data;
}
