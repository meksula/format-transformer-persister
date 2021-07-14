package io.meksula.persister.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDto {
    private Long totalRecords;
    private Long totalRecordsToday;
    private LocalDateTime oldestRecordDate;
    private LocalDateTime newestRecordDate;
    private Set<String> hostnames;
    private List<TransformerDto> records;
}
