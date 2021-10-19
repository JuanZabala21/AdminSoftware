package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.GunValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GunValueRepository  extends JpaRepository<GunValue, Long> {

    String FIND_UPDATE_BY_ID = "SELECT * FROM `depilarte_disparos` WHERE id = '1' ";
    @Query(nativeQuery = true, value = FIND_UPDATE_BY_ID)
    GunValue findByIdUpdate();

    String GET_SHOT_VALUE = "SELECT cantidad FROM `depilarte_disparos` WHERE id = '1' ";
    @Query(nativeQuery = true, value = GET_SHOT_VALUE)
    Integer getGunValue();


}
