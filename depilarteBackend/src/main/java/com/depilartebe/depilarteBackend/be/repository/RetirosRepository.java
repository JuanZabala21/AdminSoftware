package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Retiros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RetirosRepository extends JpaRepository<Retiros, Long> {

        String SEARCH_RETIREMENT = "SELECT * FROM `depilarte_retiros` WHERE " +
                "(:name IS NULL OR usuario = :name) AND" +
                "(:initialDate IS NULL OR fechaRetiro >= :initialDate) AND "+
                "(:finalDate IS NULL OR fechaRetiro <= :finalDate)";
         @Query(nativeQuery = true, value = SEARCH_RETIREMENT)
         List<Retiros> findByIdName(@Param("name") Long name,
                                   @Param("initialDate") String initialDate,
                                   @Param("finalDate") String finalDate);

    String TOTALES_RETIREMENT = "SELECT SUM(cantidadDinero) FROM `depilarte_retiros` WHERE " +
            "(:name IS NULL OR usuario = :name) AND" +
            "(:initialDate IS NULL OR fechaRetiro >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaRetiro <= :finalDate)";;
        @Query(nativeQuery = true, value = TOTALES_RETIREMENT)
        Integer findTotales(@Param("name") Long name,
                           @Param("initialDate") String initialDate,
                           @Param("finalDate") String finalDate);

}
