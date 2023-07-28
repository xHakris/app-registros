package com.example.servicios_lab.repositories;

import com.example.servicios_lab.DTO.ReporteDTO;
import com.example.servicios_lab.models.ReporteModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface IReporteRepository extends JpaRepository<ReporteModel, Long> {
}