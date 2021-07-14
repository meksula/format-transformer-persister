package io.meksula.persister.domain;

import lombok.*;

import javax.persistence.Column;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransformerDto {
    private TransformerTypes from;
    private TransformerTypes to;

    @Column(columnDefinition = "TEXT")
    private String encodedData;
    /**
     * Processed by app running on hostname
     * */
    private String hostname;
}
