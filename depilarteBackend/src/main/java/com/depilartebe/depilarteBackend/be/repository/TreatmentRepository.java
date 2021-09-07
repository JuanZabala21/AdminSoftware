package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    String FIND_TREATMENT_ID = "SELECT * FROM `depilarte_tratamientos` WHERE id_tratamientos = :treatment ";
    @Query(nativeQuery = true, value = FIND_TREATMENT_ID)
    Treatment findTreatmentById(@Param("treatment") Long treatmentId);

    String FIND_TREATMENT = "SELECT * FROM `depilarte_tratamientos` WHERE " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:specialist IS NULL OR Especialista = :specialist) AND " +
            "(:initialDate IS NULL OR fechaRegistro >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaRegistro <= :finalDate)";
    @Query(nativeQuery = true, value = FIND_TREATMENT)
    List<Treatment> findTreatment(@Param("name") String name,
                                @Param("specialist") String specialist,
                                @Param("initialDate")String initialDate,
                                @Param("finalDate") String finalDate);

    String FIND_TRATAMIENTOS_COUNT = "SELECT count(*) FROM `depilarte_tratamientos`";
    @Query(nativeQuery = true, value = FIND_TRATAMIENTOS_COUNT)
    Integer findTratamientosCount();


}
