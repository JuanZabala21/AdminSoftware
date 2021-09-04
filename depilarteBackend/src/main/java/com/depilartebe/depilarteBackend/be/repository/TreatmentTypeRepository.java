package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.TreatmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentTypeRepository extends JpaRepository<TreatmentType, Long> {

    String FIND_TYPETREATMENT_BYID = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_BYID)
    List<String> findTypeTreatmentById(@Param("treatmentId") Long treatmentId);

    String FIND_BY_TREATMENTTYPE = "SELECT * FROM `depilarte_tipotratamientos` WHERE nombreTipo = :treatmentType ";
    @Query(nativeQuery = true, value = FIND_BY_TREATMENTTYPE)
    TreatmentType findByTreatmentType(@Param("treatmentType") String treatmentType);


}
