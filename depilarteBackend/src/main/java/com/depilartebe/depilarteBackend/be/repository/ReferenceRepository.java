package com.depilartebe.depilarteBackend.be.repository;


import com.depilartebe.depilarteBackend.be.entities.References;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReferenceRepository extends JpaRepository<References, Long> {

    String FIND_REFERENCE_BY_ID = "SELECT * FROM `depilarte_referencia` WHERE id_ref = :idRef";
    @Query(nativeQuery = true, value = FIND_REFERENCE_BY_ID)
    References findReferenceById(@Param("idRef") Long idRef);

}
