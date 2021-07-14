package io.meksula.persister.domain;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stats")
@AllArgsConstructor
public class TransformationController {

    private TransformationService transformationService;

    @GetMapping
    StatisticsDto getStats() {
        return transformationService.getStats();
    }
}
