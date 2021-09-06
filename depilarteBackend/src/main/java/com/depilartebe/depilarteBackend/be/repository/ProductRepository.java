package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

    String FIND_PRODUCTS = "SELECT * FROM `depilarte_productos` WHERE " +
            "(:name IS NULL OR Nombre LIKE %:name%) AND " +
            "(:specialist IS NULL OR Especialista = :specialist) AND " +
            "(:initialDate IS NULL OR fechaRegistro >= :initialDate) AND "+
            "(:finalDate IS NULL OR fechaRegistro <= :finalDate)";
    @Query(nativeQuery = true, value = FIND_PRODUCTS)
    List<Products> findProducts  (@Param("name") String name,
                                  @Param("specialist") String specialist,
                                  @Param("initialDate")String initialDate,
                                  @Param("finalDate") String finalDate);

    String FIND_PRODUCTS_BY_ID = "SELECT * FROM `depilarte_productos` WHERE id_productos = :product";
    @Query(nativeQuery = true, value = FIND_PRODUCTS_BY_ID)
    Products findProductsById (@Param("product") Long product);


}
