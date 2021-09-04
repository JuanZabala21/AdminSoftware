package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


    String FIND_EMPLEADOS = "SELECT * FROM `depilarte_usuarios` WHERE Cargo = :charger";
    @Query(nativeQuery = true, value = FIND_EMPLEADOS)
    List<Empleado> findEmpleados(@Param("charger") Long charger);

}
