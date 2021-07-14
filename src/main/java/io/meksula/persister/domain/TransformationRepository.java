package io.meksula.persister.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TransformationRepository extends JpaRepository<TransformationEntity, Long> {

    @Query("select distinct t.hostname from TransformationEntity t")
    Set<String> findAllHostnames();

    @Query("select t from TransformationEntity t order by t.id desc")
    Set<TransformerDto> findRecords();
}
