package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

    Register findById(long id);

    String FIND_REGISTERS = "";
    @Query(nativeQuery = true, value = FIND_REGISTERS)
    List<Register> 


}
