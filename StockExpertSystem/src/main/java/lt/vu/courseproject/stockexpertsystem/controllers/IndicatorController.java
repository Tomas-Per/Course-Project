package lt.vu.courseproject.stockexpertsystem.controllers;

import lombok.RequiredArgsConstructor;
import lt.vu.courseproject.stockexpertsystem.models.indicator.Indicator;
import lt.vu.courseproject.stockexpertsystem.services.IndicatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/indicators")
@RequiredArgsConstructor
public class IndicatorController {

    private final IndicatorService indicatorService;

    @GetMapping("/{name}")
    public Indicator getIndicator(@PathVariable String name) {
        return indicatorService.getIndicator(name);
    }

}
