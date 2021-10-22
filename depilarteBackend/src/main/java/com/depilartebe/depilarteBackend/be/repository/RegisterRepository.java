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
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:lastName IS NULL OR Apellido LIKE %:lastName%) AND " +
            "(:cedula IS NULL OR Cedula LIKE %:cedula%) AND " +
            "(:userAt IS NULL OR RegisterUser = :userAt) AND " +
            "(:formPay IS NULL OR FormaPago = :formPay) AND" +
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
                                @Param("finalDate") String finalDate,
                                @Param("formPay") Long formPay);

        String FIND_REGISTER_COUNT = "SELECT count(*) FROM `depilarte_registros`";
        @Query(nativeQuery = true, value = FIND_REGISTER_COUNT)
        Integer findRegisterCount();

        String FIND_REGISTROS_POR_MES = "select month(fechaAtendido) as month, sum(1) as total from depilarte_registros where year(fechaAtendido) = year(now()) group by  month(fechaAtendido)";
        @Query(nativeQuery = true, value= FIND_REGISTROS_POR_MES)
        List<List<Integer>> findRegisterByMonth();

        String FIND_REGISTER_FOR_ID = "SELECT * FROM `depilarte_registros` WHERE id = :id";
         @Query(nativeQuery = true, value= FIND_REGISTER_FOR_ID)
         Register findRegisterById(@Param("id") Long id);

        String FIND_REFERENCE_PER_MONTH_INSTAGRAM = "select month(fechaAtendido) as month, sum(1) as total from depilarte_registros where year(fechaAtendido) = year(now()) AND Referencia  = 1  group by  month(fechaAtendido)";
        @Query(nativeQuery = true, value = FIND_REFERENCE_PER_MONTH_INSTAGRAM)
        List<List<Integer>> findReferenceByMonthInstagram();

        String FIND_REFERENCE_PER_MONTH_AMIGOS = "select month(fechaAtendido) as month, sum(1) as total from depilarte_registros where year(fechaAtendido) = year(now()) AND Referencia  = 2  group by  month(fechaAtendido)";
        @Query(nativeQuery = true, value = FIND_REFERENCE_PER_MONTH_AMIGOS)
        List<List<Integer>> findReferenceByMonthAmigos();

        String FIND_REFERENCE_PER_MONTH_OTROS = "select month(fechaAtendido) as month, sum(1) as total from depilarte_registros where year(fechaAtendido) = year(now()) AND Referencia  = 3  group by  month(fechaAtendido)";
        @Query(nativeQuery = true, value = FIND_REFERENCE_PER_MONTH_OTROS)
        List<List<Integer>> findReferenceByMonthOtros();

    String TOTAL_ZELLE = "SELECT SUM(PrecioTotal) FROM `depilarte_registros` WHERE " +
            " FormaPago = '1' AND " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:lastName IS NULL OR Apellido LIKE %:lastName%) AND " +
            "(:cedula IS NULL OR Cedula LIKE %:cedula%) AND " +
            "(:userAt IS NULL OR RegisterUser = :userAt) AND " +
            "(:formPay IS NULL OR FormaPago = :formPay) AND" +
            "(:nameUser IS NULL OR UserAtendio = :nameUser) AND "+
            "(:initialDate IS NULL OR fechaAtendido >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaAtendido <= :finalDate)";
    @Query(nativeQuery = true, value = TOTAL_ZELLE)
    Integer findTotalZelle(@Param("name") String name,
                           @Param("lastName") String lastName,
                           @Param("cedula") String cedula,
                           @Param("userAt") Long userAt,
                           @Param("nameUser") Long nameUser,
                            @Param("initialDate")String initialDate,
                            @Param("finalDate") String finalDate,
                           @Param("formPay") Long formPay);

    String TOTAL_PAGOM = "SELECT SUM(PrecioTotal) FROM `depilarte_registros` WHERE " +
            " FormaPago = '2' AND " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:lastName IS NULL OR Apellido LIKE %:lastName%) AND " +
            "(:cedula IS NULL OR Cedula LIKE %:cedula%) AND " +
            "(:userAt IS NULL OR RegisterUser = :userAt) AND " +
            "(:formPay IS NULL OR FormaPago = :formPay) AND" +
            "(:nameUser IS NULL OR UserAtendio = :nameUser) AND "+
            "(:initialDate IS NULL OR fechaAtendido >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaAtendido <= :finalDate)";
    @Query(nativeQuery = true, value = TOTAL_PAGOM)
    Integer findTotalPagoM(@Param("name") String name,
                           @Param("lastName") String lastName,
                           @Param("cedula") String cedula,
                           @Param("userAt") Long userAt,
                           @Param("nameUser") Long nameUser,
                           @Param("initialDate")String initialDate,
                           @Param("finalDate") String finalDate,
                           @Param("formPay") Long formPay);

    String TOTAL_EFECTIVO = "SELECT SUM(PrecioTotal) FROM `depilarte_registros` WHERE " +
            " FormaPago = '3' AND " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:lastName IS NULL OR Apellido LIKE %:lastName%) AND " +
            "(:cedula IS NULL OR Cedula LIKE %:cedula%) AND " +
            "(:userAt IS NULL OR RegisterUser = :userAt) AND " +
            "(:formPay IS NULL OR FormaPago = :formPay) AND" +
            "(:nameUser IS NULL OR UserAtendio = :nameUser) AND "+
            "(:initialDate IS NULL OR fechaAtendido >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaAtendido <= :finalDate)";
    @Query(nativeQuery = true, value = TOTAL_EFECTIVO)
    Integer findTotalEfectivo(@Param("name") String name,
                              @Param("lastName") String lastName,
                              @Param("cedula") String cedula,
                              @Param("userAt") Long userAt,
                              @Param("nameUser") Long nameUser,
                              @Param("initialDate")String initialDate,
                              @Param("finalDate") String finalDate,
                              @Param("formPay") Long formPay);

    String TOTAL_ABONADO = "SELECT SUM(Abonado) FROM `depilarte_registros` WHERE " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:lastName IS NULL OR Apellido LIKE %:lastName%) AND " +
            "(:cedula IS NULL OR Cedula LIKE %:cedula%) AND " +
            "(:userAt IS NULL OR RegisterUser = :userAt) AND " +
            "(:formPay IS NULL OR FormaPago = :formPay) AND" +
            "(:nameUser IS NULL OR UserAtendio = :nameUser) AND "+
            "(:initialDate IS NULL OR fechaAtendido >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaAtendido <= :finalDate)";
    @Query(nativeQuery = true, value = TOTAL_ABONADO)
    Integer findTotalAbonado(@Param("name") String name,
                             @Param("lastName") String lastName,
                             @Param("cedula") String cedula,
                             @Param("userAt") Long userAt,
                             @Param("nameUser") Long nameUser,
                             @Param("initialDate")String initialDate,
                             @Param("finalDate") String finalDate,
                             @Param("formPay") Long formPay);

    
}
