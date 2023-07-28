package com.example.servicios_lab.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicios_lab.DTO.ReporteDTO;
import com.example.servicios_lab.models.ReporteModel;
import com.example.servicios_lab.repositories.IReporteRepository;

@Service
public class ReporteService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ReporteModel> getAllReportes() {
        String jpql = "SELECT r FROM reporte r " +
                      "JOIN FETCH r.periodoacademico " +
                      "JOIN FETCH r.horarios " +
                      "JOIN FETCH r.laboratorios " +
                      "JOIN FETCH r.materia " +
                      "JOIN FETCH r.paralelos";

        TypedQuery<ReporteModel> query = entityManager.createQuery(jpql, ReporteModel.class);
        return query.getResultList();
    }

}
