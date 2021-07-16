package io.meksula.persister.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transformation")
public class TransformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "from_format")
    @Enumerated(EnumType.STRING)
    private TransformerTypes from;

    @Column(name = "to_format")
    @Enumerated(EnumType.STRING)
    private TransformerTypes to;

    @Column(columnDefinition = "TEXT")
    private String encodedData;
    private String hostname;
}
