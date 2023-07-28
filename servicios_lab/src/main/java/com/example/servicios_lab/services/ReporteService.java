package com.example.servicios_lab.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.servicios_lab.DTO.ReporteDTO;
import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.models.LaboratorioModel;
import com.example.servicios_lab.models.MateriaModel;
import com.example.servicios_lab.models.ParaleloModel;
import com.example.servicios_lab.models.PeriodoAcademicoModel;
import com.example.servicios_lab.models.ReporteModel;
import com.example.servicios_lab.repositories.IReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ReporteModel> getReportesInfo() {
        String query = "SELECT r.id, r.auxiliar, r.fecha, " +
                       "p.inicioPeriodo, p.finPeriodo, " +
                       "h.horaEntrada, h.horaSalida, " +
                       "l.nombre, " +
                       "m.nombre, " +
                       "pa.nombre " +
                       "FROM reporte r " +
                       "JOIN periodoacademico p ON r.id_periodo = p.id " +
                       "JOIN horarios h ON r.id_Horario = h.id " +
                       "JOIN laboratorios l ON r.id_Laboratorio = l.id " +
                       "JOIN materia m ON r.id_Materia = m.id " +
                       "JOIN paralelos pa ON r.id_paralelo = pa.id";

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            ReporteModel reporte = new ReporteModel();
            reporte.setId(rs.getLong("id"));
            reporte.setAuxiliar(rs.getString("auxiliar"));
            reporte.setFecha(rs.getDate("fecha"));

            PeriodoAcademicoModel periodo = new PeriodoAcademicoModel();
            periodo.setInicioPeriodo(rs.getString("inicioPeriodo"));
            periodo.setFinPeriodo(rs.getString("finPeriodo"));
            reporte.setPeriodo(periodo);

            HorarioModel horario = new HorarioModel();
            horario.setHoraEntrada(rs.getString("horaEntrada"));
            horario.setHoraSalida(rs.getString("horaSalida"));
            reporte.setHorario(horario);

            LaboratorioModel laboratorio = new LaboratorioModel();
            laboratorio.setNombre(rs.getString("nombre"));
            reporte.setLaboratorio(laboratorio);

            MateriaModel materia = new MateriaModel();
            materia.setNombre(rs.getString("nombre"));
            reporte.setMateria(materia);

            ParaleloModel paralelo = new ParaleloModel();
            paralelo.setNombre(rs.getString("nombre"));
            reporte.setParalelo(paralelo);

            return reporte;
        });
    }

}
