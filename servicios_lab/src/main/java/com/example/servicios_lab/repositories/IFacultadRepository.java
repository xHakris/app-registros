package com.example.servicios_lab.repositories;

import com.example.servicios_lab.models.FacultadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacultadRepository extends JpaRepository<FacultadModel, Long> {
}
