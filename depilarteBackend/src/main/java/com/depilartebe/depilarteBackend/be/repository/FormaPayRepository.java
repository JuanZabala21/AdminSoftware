package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Treatment;
import com.depilartebe.depilarteBackend.be.entities.formaPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormaPayRepository extends JpaRepository<formaPay, Long> {

    String FIND_FORMAPAY_BY_ID = "SELECT * FROM `depilarte_metodopagos` WHERE id_pagos = :idPago";
    @Query(nativeQuery = true, value = FIND_FORMAPAY_BY_ID)
    formaPay findformaPayById(@Param("idPago") Long idPago);

}
