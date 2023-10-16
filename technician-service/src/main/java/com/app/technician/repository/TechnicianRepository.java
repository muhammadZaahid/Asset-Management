package com.app.technician.repository;

import com.app.technician.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, String> {

    @Query(value = " SELECT * FROM technician t " +
            " WHERE t.id = ?1", nativeQuery = true)
    Technician findTechnicianById(String id);
}
