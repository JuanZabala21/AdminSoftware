package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

    Register findById(long id);

    String FIND_REGISTERS = "SELECT * FROM `depilarte_registros` WHERE " +
            "(:name IS NULL OR Nombre = :name) AND " +
            "(:lastName IS NULL OR Apellido = :lastName) AND " +
            "(:cedula IS NULL OR Cedula = :cedula) AND " +
            "(:userAt IS NULL OR RegisterUser = :userAt) AND " +
            "(:nameUser IS NULL OR UserAtendio = :nameUser) AND "+
            "(:initialDate IS NULL OR fechaAtendido >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaAtendido <= :finalDate)";
    @Query(nativeQuery = true, value = FIND_REGISTERS)
    List<Register> findRegister(@Param("name") String name,
                                @Param("lastName") String lastName,
                                @Param("cedula") String cedula,
                                @Param("userAt") Long userAt,
                                @Param("nameUser") Long nameUser,
                                @Param("initialDate")String initialDate,
                                @Param("finalDate") String finalDate);


}