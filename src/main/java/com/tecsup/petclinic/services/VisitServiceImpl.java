package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.repositories.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
@Slf4j
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * Crear una nueva visita
     *
     * @param visit
     * @return
     */
    @Override
    public Visit create(Visit visit) {
        return visitRepository.save(visit);
    }

    /**
     * Actualizar una visita existente
     *
     * @param visit
     * @return
     */
    @Override
    public Visit update(Visit visit) {
        return visitRepository.save(visit);
    }

    /**
     * Eliminar una visita por su ID
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        Visit visit = findById(id);
        visitRepository.delete(visit);
    }

    /**
     * Buscar una visita por su ID
     *
     * @param id
     * @return
     */
    @Override
    public Visit findById(Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if (!visit.isPresent()) {
            log.warn("Visit not found with id: " + id);
            throw new RuntimeException("Visit not found...!");
        }
        return visit.get();
    }

    /**
     * Buscar visitas por petId
     *
     * @param petId
     * @return
     */
    @Override
    public List<Visit> findByPetId(Long petId) {
        List<Visit> visits = visitRepository.findByPetId(petId);
        visits.forEach(visit -> log.info("Visit: " + visit));
        return visits;
    }

    /**
     * Buscar visitas por visitDate
     *
     * @param visitDate
     * @return
     */
    @Override
    public List<Visit> findByVisitDate(Date visitDate) {
        List<Visit> visits = visitRepository.findByVisitDate(visitDate);
        visits.forEach(visit -> log.info("Visit: " + visit));
        return visits;
    }

    /**
     * Buscar visitas por petId y visitDate
     *
     * @param petId
     * @param visitDate
     * @return
     */
    @Override
    public List<Visit> findByPetIdAndVisitDate(Long petId, Date visitDate) {
        List<Visit> visits = visitRepository.findByPetIdAndVisitDate(petId, visitDate);
        visits.forEach(visit -> log.info("Visit: " + visit));
        return visits;
    }

    /**
     * Obtener todas las visitas
     *
     * @return
     */
    @Override
    public List<Visit> findAll() {
        List<Visit> visits = visitRepository.findAll();
        visits.forEach(visit -> log.info("Visit: " + visit));
        return visits;
    }
}

