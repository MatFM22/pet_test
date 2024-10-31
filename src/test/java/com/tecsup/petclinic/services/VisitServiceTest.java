package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.tecsup.petclinic.entities.Visit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void testFindVisitById() {
        Long ID = 1L;
        Visit visit = null;

        try {
            visit = this.visitService.findById(ID);
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }

        assertNotNull(visit);
        assertEquals(ID, visit.getId());
    }

    /**
     * Test to find visits by petId
     */
    @Test
    public void testFindVisitByPetId() {
        Long PET_ID = 7L;
        int SIZE_EXPECTED = 2;

        List<Visit> visits = this.visitService.findByPetId(PET_ID);

        assertEquals(SIZE_EXPECTED, visits.size());
    }

    /**
     * Test to find visits by visitDate
     */
    @Test
    public void testFindVisitByDate() {
        Date VISIT_DATE = Date.valueOf("2010-03-04");
        int SIZE_EXPECTED = 1;

        List<Visit> visits = this.visitService.findByVisitDate(VISIT_DATE);

        assertEquals(SIZE_EXPECTED, visits.size());
    }

    /**
     * Test to create a new visit
     */
    @Test
    public void testCreateVisit() {
        Long PET_ID = 7L;
        Date VISIT_DATE = Date.valueOf("2024-10-31");
        //Date VISIT_DATE = Date.valueOf("2024-10-31");
        String DESCRIPTION = "Annual Checkup";

        Visit visit = new Visit();
        visit.setPetId(PET_ID);
        visit.setVisitDate(VISIT_DATE);
        visit.setDescription(DESCRIPTION);

        Visit visitCreated = this.visitService.create(visit);

        log.info("Visit Created: {}", visitCreated);

        assertNotNull(visitCreated.getId());
        assertEquals(PET_ID, visitCreated.getPetId());
        assertEquals(VISIT_DATE, visitCreated.getVisitDate());
        assertEquals(DESCRIPTION, visitCreated.getDescription());
    }

    /**
     * Test to update an existing visit
     */
    @Test
    public void testUpdateVisit() {
        Long PET_ID = 7L;
        Date VISIT_DATE = Date.valueOf("2024-10-31");
        //Date VISIT_DATE = Date.valueOf("2024-10-31");
        String DESCRIPTION = "Initial Visit";

        Visit visit = new Visit();
        visit.setPetId(PET_ID);
        visit.setVisitDate(VISIT_DATE);
        visit.setDescription(DESCRIPTION);

        Visit visitCreated = this.visitService.create(visit);
        log.info("Visit Created: {}", visitCreated);

        // Update visit details
        String UPDATED_DESCRIPTION = "Follow-up Visit";
        visitCreated.setDescription(UPDATED_DESCRIPTION);

        Visit updatedVisit = this.visitService.update(visitCreated);
        log.info("Visit Updated: " + updatedVisit);

        assertEquals(UPDATED_DESCRIPTION, updatedVisit.getDescription());
    }

    /**
     * Test to delete a visit
     */
    @Test
    public void testDeleteVisit() {
        Long PET_ID = 7L;
        Date VISIT_DATE = Date.valueOf("2024-10-31");
        String DESCRIPTION = "Vacunación by Arturo";

        Visit visit = new Visit();
        visit.setPetId(PET_ID);
        visit.setVisitDate(VISIT_DATE);
        visit.setDescription(DESCRIPTION);

        Visit visitCreated = this.visitService.create(visit);
        log.info("Visit Created: {}", visitCreated);

        // Delete the visit
        this.visitService.delete(visitCreated.getId());

        // Validation
        try {
            this.visitService.findById(visitCreated.getId());
            fail("Visit should have been deleted");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
}

