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
    private EntityManager em;

    public List<ReporteDTO> findCustomReporte() {
        String queryStr = "SELECT new com.example.servicios_lab.models.ReporteDTO(r.id, l.nombre, d.nombre, m.nombre, m.nivel, c.nombre, f.abreviatura, h.horaEntrada, h.horaSalida, b.nombre) " +
                          "FROM ReporteModel r JOIN r.laboratorio l JOIN r.docente d JOIN r.materia m JOIN m.carrera c JOIN c.facultad f JOIN r.horario h JOIN h.bloque b";
        TypedQuery<ReporteDTO> query = em.createQuery(queryStr, ReporteDTO.class);
        return query.getResultList();
    }

}
