package com.depilartebe.depilarteBackend.be.repository;

import com.depilartebe.depilarteBackend.be.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
