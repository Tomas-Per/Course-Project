package lt.vu.courseproject.stockexpertsystem.services;

import lombok.RequiredArgsConstructor;
import lt.vu.courseproject.stockexpertsystem.models.indicator.Indicator;
import lt.vu.courseproject.stockexpertsystem.repositories.IndicatorRepository;
import lt.vu.courseproject.stockexpertsystem.utils.AlphaVantageUtility;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndicatorServiceImpl implements IndicatorService{

    private final IndicatorRepository indicatorRepository;
    private final AlphaVantageUtility avUtil;

    @Override
    public Indicator getIndicator(String name) {
        Indicator indicator = indicatorRepository.findByName(name);
        if(indicator == null) {
            indicator = avUtil.getIndicatorFromAV(name);
            indicatorRepository.save(indicator);
        }
        return indicator;
    }
}
