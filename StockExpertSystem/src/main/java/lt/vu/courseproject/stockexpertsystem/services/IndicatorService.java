package lt.vu.courseproject.stockexpertsystem.services;

import lt.vu.courseproject.stockexpertsystem.models.indicator.Indicator;
import org.springframework.validation.annotation.Validated;

@Validated
public interface IndicatorService {
    Indicator getIndicator(String name);
}
