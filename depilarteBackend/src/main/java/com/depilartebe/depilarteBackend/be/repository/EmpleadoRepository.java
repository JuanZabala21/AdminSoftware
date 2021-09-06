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


    String FIND_WORKERS = "SELECT * FROM `depilarte_usuarios` WHERE " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:cedula IS NULL OR Cedula LIKE %:cedula%) AND " +
            "(:charge IS NULL OR Cargo = :charge) AND" +
            "(:initialDate IS NULL OR fechaIngreso >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaIngreso <= :finalDate)";
    @Query(nativeQuery = true, value = FIND_WORKERS)
    List<Empleado> findWorkers( @Param("name") String name,
                                @Param("cedula") String cedula,
                                @Param("charge") Long charge,
                                @Param("initialDate")String initialDate,
                                @Param("finalDate") String finalDate);

    String FIND_WORKERS_BY_ID = "SELECT * FROM  `depilarte_usuarios` WHERE id_usuarios = :idWorker";
    @Query(nativeQuery = true, value = FIND_WORKERS_BY_ID)
    Empleado findWorkersById(@Param("idWorker") Long worker);



}
