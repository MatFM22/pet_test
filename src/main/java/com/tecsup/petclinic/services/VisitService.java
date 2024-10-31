package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import java.util.List;
import java.util.Date;

/**
 *
 * Servicio para gestionar visitas
 *
 */
public interface VisitService {

    /**
     * Crear una nueva visita
     *
     * @param visit
     * @return
     */
    Visit create(Visit visit);

    /**
     * Actualizar una visita existente
     *
     * @param visit
     * @return
     */
    Visit update(Visit visit);

    /**
     * Eliminar una visita por su ID
     *
     * @param id
     */
    void delete(Long id);

    /**
     * Buscar una visita por su ID
     *
     * @param id
     * @return
     */
    Visit findById(Long id);

    /**
     * Buscar visitas por petId
     *
     * @param petId
     * @return
     */
    List<Visit> findByPetId(Long petId);

    /**
     * Buscar visitas por visitDate
     *
     * @param visitDate
     * @return
     */
    List<Visit> findByVisitDate(Date visitDate);

    /**
     * Buscar visitas por petId y visitDate
     *
     * @param petId
     * @param visitDate
     * @return
     */
    List<Visit> findByPetIdAndVisitDate(Long petId, Date visitDate);

    /**
     * Obtener todas las visitas
     *
     * @return
     */
    List<Visit> findAll();
}

