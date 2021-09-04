package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {

}
