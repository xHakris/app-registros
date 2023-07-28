package com.example.servicios_lab.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.servicios_lab.DTO.ReporteDTO;
import com.example.servicios_lab.models.ReporteModel;
import com.example.servicios_lab.services.ReporteService;

@RestController
@RequestMapping("/reporte")
public class ReporteController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<ReporteModel> getAllReportes() {
        String jpql = "SELECT r.id, r.auxiliar, r.fecha, " +
                "p.inicioPeriodo, p.finPeriodo, " +
                "h.horaEntrada, h.horaSalida, " +
                "l.nombre, " +
                "m.nombre, " +
                "pa.nombre " +
                "FROM ReporteModel r " +
                "JOIN r.periodo p " +
                "JOIN r.horario h " +
                "JOIN r.laboratorio l " +
                "JOIN r.materia m " +
                "JOIN r.paralelo pa";

        TypedQuery<ReporteModel> query = entityManager.createQuery(jpql, ReporteModel.class);
        return query.getResultList();
    }
}


