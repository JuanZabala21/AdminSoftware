package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.TreatmentType;
import com.depilartebe.depilarteBackend.be.entities.TreatmentZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentTypeRepository extends JpaRepository<TreatmentType, Long> {

    String FIND_TYPETREATMENT_BYID = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_BYID)
    List<String> findTypeTreatmentById(@Param("treatmentId") Long treatmentId);

    String FIND_BY_TREATMENTTYPE = "SELECT * FROM `depilarte_tipotratamientos` WHERE nombreTipo = :treatmentType ";
    @Query(nativeQuery = true, value = FIND_BY_TREATMENTTYPE)
    TreatmentType findByTreatmentType(@Param("treatmentType") String treatmentType);

    String FIND_TYPETREATMENT_TREAT = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_TREAT)
    List<TreatmentType> finbTypeTreat(@Param("treatmentId") Long treatmentId);

    String FIND_TYPETREATMENT_ID = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tipo = :treatmentType";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_ID)
    TreatmentType findTreatmentTypeById(@Param("treatmentType") Long treatmentId);

    String FIND_NAME_TYPE = "SELECT nombreTipo FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentType";
    @Query(nativeQuery = true, value = FIND_NAME_TYPE)
    List<String> findTreatmentTypeNames(@Param("treatmentType") Long treatmentId);




}
