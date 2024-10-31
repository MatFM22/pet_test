package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    // Fetch visits by petId
    List<Visit> findByPetId(Long petId);

    // Fetch visits by visitDate
    List<Visit> findByVisitDate(Date visitDate);

    // Fetch visits by petId and visitDate
    List<Visit> findByPetIdAndVisitDate(Long petId, Date visitDate);

    @Override
    List<Visit> findAll();
}

