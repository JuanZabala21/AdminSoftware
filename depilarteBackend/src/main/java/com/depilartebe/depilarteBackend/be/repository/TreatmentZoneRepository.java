package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.TreatmentType;
import com.depilartebe.depilarteBackend.be.entities.TreatmentZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentZoneRepository extends JpaRepository<TreatmentZone, Long> {

    String FIND_ZONETREATMENT_BY_ID = "SELECT * FROM `depilarte_zonatratamientos` WHERE id_tratamiento = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_ZONETREATMENT_BY_ID)
    List<String> findZoneTreatmentById(@Param("treatmentId") Long treatmentId);

    String FIND_ZONETREATMENT = "SELECT * FROM `depilarte_zonatratamientos` WHERE nombreTipo = :treatmentZone ";
    @Query(nativeQuery = true, value = FIND_ZONETREATMENT)
    TreatmentZone findByTreatmentZone(@Param("treatmentZone") String treatmentZone);

    String FIND_TYPETREATMENT_TREAT = "SELECT * FROM `depilarte_zonatratamientos` WHERE id_tratamiento = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_TREAT)
    List<TreatmentZone> finbTypeTreat(@Param("treatmentId") Long treatmentId);

    String FIND_ZONETREATMENT_ID = "SELECT * FROM `depilarte_zonatratamientos` WHERE id_zona = :treatmentZone ";
    @Query(nativeQuery = true, value = FIND_ZONETREATMENT_ID)
    TreatmentZone findTreatmentZoneById(@Param("treatmentZone") Long treatmentId);

    String FIND_NAME_ZONE = "SELECT ZonaNombre FROM `depilarte_zonatratamientos` WHERE id_tratamiento = :treatmentZone";
    @Query(nativeQuery = true, value = FIND_NAME_ZONE)
    List<String> findTreatmentZoneNames(@Param("treatmentZone") Long treatmentId);

}
