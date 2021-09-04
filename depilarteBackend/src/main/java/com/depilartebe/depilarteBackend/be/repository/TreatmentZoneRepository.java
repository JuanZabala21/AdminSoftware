package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.TreatmentType;
import com.depilartebe.depilarteBackend.be.entities.TreatmentZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentZoneRepository extends JpaRepository<TreatmentZone, Long> {

    String FIND_ZONETREATMENT_BY_ID = "SELECT * FROM `depilarte_zonatratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_ZONETREATMENT_BY_ID)
    List<String> findZoneTreatmentById(@Param("treatmentId") Long treatmentId);

    String FIND_ZONETREATMENT = "SELECT * FROM `depilarte_zonatratamientos` WHERE nombreTipo = :treatmentZone ";
    @Query(nativeQuery = true, value = FIND_ZONETREATMENT)
    TreatmentZone findByTreatmentZone(@Param("treatmentZone") String treatmentZone);


}
