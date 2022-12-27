package lt.vu.courseproject.stockexpertsystem.models.rule;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lt.vu.courseproject.stockexpertsystem.models.fact.Fact;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Rules")
public class Rule {

    private List<Fact> antecedents;
    private Fact consequent;

    @Transient
    @JsonIgnore
    private boolean flag1;

    @Transient
    @JsonIgnore
    private boolean flag2;
}
