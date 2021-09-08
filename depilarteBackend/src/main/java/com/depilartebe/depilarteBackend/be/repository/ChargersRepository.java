package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Chargers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargersRepository extends JpaRepository<Chargers,Long> {

    String FIND_NAME_BY_ID = "SELECT * FROM `depilarte_cargos` WHERE id_cargo = :idCharge";
    @Query(nativeQuery = true, value = FIND_NAME_BY_ID)
    Chargers findNameById(@Param("idCharge") String idCharge);


}
