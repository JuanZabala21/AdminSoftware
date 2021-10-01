package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.TreatmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentTypeRepository extends JpaRepository<TreatmentType, Long> {

    String FIND_TYPETREATMENT_BYID_FOR_EDIT = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_BYID_FOR_EDIT)
    List<TreatmentType> findTypeTreatmentByIdForEdit(@Param("treatmentId") Long treatmentId);

    String FIND_TYPETREATMENT_TREAT = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tratamientos = :treatmentId ";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_TREAT)
    List<TreatmentType> finbTypeTreat(@Param("treatmentId") Long treatmentId);

    String FIND_TYPETREATMENT_ID = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tipo = :treatmentType";
    @Query(nativeQuery = true, value = FIND_TYPETREATMENT_ID)
    TreatmentType findTreatmentTypeById(@Param("treatmentType") Long treatmentId);

    String FIND_PRICE_AND_COMISION = "SELECT * FROM `depilarte_tipotratamientos` WHERE id_tipo = :typePrice";
    @Query(nativeQuery = true, value = FIND_PRICE_AND_COMISION)
    TreatmentType findPriceAndComision(@Param("typePrice") Long typePrice);

    String FIND_NAME_TYPETREATMENT = "SELECT * FROM `depilarte_tipotratamientos` WHERE typeTreatment = :typeName";
    @Query(nativeQuery = true, value = FIND_NAME_TYPETREATMENT)
    TreatmentType findTreatmentName(@Param("typeName") String typeName);



}
