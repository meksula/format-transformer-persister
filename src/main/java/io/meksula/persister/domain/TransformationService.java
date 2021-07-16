package io.meksula.persister.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class TransformationService {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private TransformationRepository transformationRepository;

    public void handleTransformationEvent(byte[] message) {
        try {
            TransformerDto transformerDto = objectMapper.readValue(message, TransformerDto.class);
            log.info("Message received: " + transformerDto);
            transformationRepository.save(TransformationEntity.builder()
                    .from(transformerDto.getFrom())
                    .to(transformerDto.getTo())
                    .encodedData(transformerDto.getEncodedData())
                    .hostname(transformerDto.getHostname())
                    .build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StatisticsDto getStats() {
        return StatisticsDto.builder()
                .hostnames(transformationRepository.findAllHostnames())
                .newestRecordDate(LocalDateTime.now())
                .oldestRecordDate(LocalDateTime.now())
                .records(transformationRepository.findAll(Pageable.ofSize(10))
                        .stream()
                        .map(transformationEntity -> TransformerDto.builder()
                                .from(transformationEntity.getFrom())
                                .to(transformationEntity.getTo())
                                .hostname(transformationEntity.getHostname())
                                .encodedData(transformationEntity.getEncodedData())
                                .build())
                        .collect(Collectors.toList()))
                .totalRecords(transformationRepository.count())
                .totalRecordsToday(5L)
                .build();
    }
}
