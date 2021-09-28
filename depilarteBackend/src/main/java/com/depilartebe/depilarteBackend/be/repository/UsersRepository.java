package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long> {

    String FIND_USERNAME_ATTEMPTION = "SELECT * FROM `depilarte_usuarios` WHERE id_usuarios = :idUser";
    @Query(nativeQuery = true, value = FIND_USERNAME_ATTEMPTION)
    Users findUsernameById (@Param("idUser") Long user);
}
