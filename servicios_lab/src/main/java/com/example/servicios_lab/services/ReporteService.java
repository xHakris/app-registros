package com.example.servicios_lab.services;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.servicios_lab.DTO.ReporteDTO;
import com.example.servicios_lab.models.ReporteModel;
import com.example.servicios_lab.repositories.IReporteRepository;

@Service
public class ReporteService {
    private final IReporteRepository reporteRepository;

    @Autowired
    public ReporteService(IReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;


    public ReporteModel save(ReporteModel reporte) {
        return reporteRepository.save(reporte);
    }

    public ReporteModel findById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public List<ReporteModel> findAll() {
        return reporteRepository.findAll();
    }

    public ReporteModel update(ReporteModel reporte, Long id) {
        reporte.setId(id);
        return reporteRepository.save(reporte);
    }

    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ReporteDTO> findCustomReporte() {
        String sql = "SELECT r.id as reporte_id, l.nombre as nombre_laboratorio, d.nombre as nombre_docente, m.nombre as nombre_materia, m.nivel as nivel_materia, c.nombre as nombre_carrera, f.abreviatura as abreviatura_facultad, h.horaEntrada as hora_entrada, h.horaSalida as hora_salida, b.nombre as nombre_bloque "
           + "FROM reporte r "
           + "JOIN materia m ON r.id_Materia = m.id "
           + "JOIN horarios h ON r.id_Horario = h.id "
           + "JOIN laboratorios l ON r.id_Laboratorio = l.id "
           + "JOIN docentes d ON m.docenteID = d.id "
           + "JOIN carrera c ON m.carreraID = c.id "
           + "JOIN bloques b ON c.bloqueID = b.id "
           + "JOIN facultades f ON b.facultadID = f.id";

    
        Query query = entityManager.createNativeQuery(sql);
        List<Tuple> tuples = query.getResultList();
    
        List<ReporteDTO> reporteDTOs = new ArrayList<>();
    
        for (Tuple tuple : tuples) {
            ReporteDTO reporteDTO = new ReporteDTO(
                tuple.get("id", Long.class),
                tuple.get("nombre_laboratorio", String.class),
                tuple.get("nombre_docente", String.class),
                tuple.get("nombre_materia", String.class),
                tuple.get("nivel_materia", String.class),
                tuple.get("nombre_carrera", String.class),
                tuple.get("abreviatura_facultad", String.class),
                tuple.get("hora_entrada", Time.class),
                tuple.get("hora_salida", Time.class),
                tuple.get("nombre_bloque", String.class)
            );
            reporteDTOs.add(reporteDTO);
        }
    
        return reporteDTOs;
    }
    

}
