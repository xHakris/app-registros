package com.example.servicios_lab.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reporte")
public class ReporteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_periodo;
    private Long id_Horario;
    private Long id_Laboratorio;
    private Long id_Materia;
    private String auxiliar;
    private Date fecha;
    private Long id_paralelo;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_periodo() {
        return id_periodo;
    }
    public void setId_periodo(Long id_periodo) {
        this.id_periodo = id_periodo;
    }
    public Long getId_Horario() {
        return id_Horario;
    }
    public void setId_Horario(Long id_Horario) {
        this.id_Horario = id_Horario;
    }
    public Long getId_Laboratorio() {
        return id_Laboratorio;
    }
    public void setId_Laboratorio(Long id_Laboratorio) {
        this.id_Laboratorio = id_Laboratorio;
    }
    public Long getId_Materia() {
        return id_Materia;
    }
    public void setId_Materia(Long id_Materia) {
        this.id_Materia = id_Materia;
    }
    public String getAuxiliar() {
        return auxiliar;
    }
    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Long getId_paralelo() {
        return id_paralelo;
    }
    public void setId_paralelo(Long id_paralelo) {
        this.id_paralelo = id_paralelo;
    }


    
}
