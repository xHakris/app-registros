package com.example.servicios_lab.repositories;

import com.example.servicios_lab.models.DocenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocentesRepository extends JpaRepository<DocenteModel, Long> {
}