package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.TreatmentType;
import com.depilartebe.depilarteBackend.be.entities.TreatmentType2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TreatmentType2Repository extends JpaRepository<TreatmentType2, Long> {

    String FIND_TYPETREATMENT_BYID = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_BYID)
    List<String> findTypeTreatmentById(@Param("treatmentId") Long treatmentId);

    String FIND_TYPETREATMENT_BYID_FOR_EDIT = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_BYID_FOR_EDIT)
    List<TreatmentType2> findTypeTreatmentByIdForEdit(@Param("treatmentId") Long treatmentId);

    String FIND_BY_TREATMENTTYPE = "SELECT * FROM `depilarte_tipotratamientos` WHERE nombreTipo = :treatmentType ";
    @Query(nativeQuery = true, value = FIND_BY_TREATMENTTYPE)
    TreatmentType2 findByTreatmentType(@Param("treatmentType") String treatmentType);

    String FIND_TYPETREATMENT_TREAT = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_TREAT)
    List<TreatmentType2> finbTypeTreat2(@Param("treatmentId") Long treatmentId);

    String FIND_TYPETREATMENT_TREATNAME = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_TREATNAME)
    List<TreatmentType2> finbTypeTreatNamePrice(@Param("treatmentId") Long treatmentId);

    String FIND_TYPETREATMENT_ID = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tipo = :treatmentType";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_ID)
    TreatmentType2 findTreatmentTypeById(@Param("treatmentType") Long treatmentId);






}
