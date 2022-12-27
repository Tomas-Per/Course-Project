package lt.vu.courseproject.stockexpertsystem.models.fact;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Fact {
    String identifier;

    public Fact(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return identifier.equals(fact.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
