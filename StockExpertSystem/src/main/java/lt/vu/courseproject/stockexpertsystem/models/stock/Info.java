package lt.vu.courseproject.stockexpertsystem.models.stock;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Info {

    public double open;
    public double high;
    public double low;
    public double close;
    public int volume;
}
