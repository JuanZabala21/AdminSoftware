package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Totales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalesRepository extends JpaRepository<Totales , Long> {

    String FIND_UPDATE_BY_ID = "SELECT * FROM `depilarte_totales` WHERE id = '1' ";
    @Query(nativeQuery = true, value = FIND_UPDATE_BY_ID)
    Totales findByIdUpdate();


}
