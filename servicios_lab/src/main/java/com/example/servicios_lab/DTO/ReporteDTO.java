package com.example.servicios_lab.DTO;

import java.sql.Time;

public class ReporteDTO {
   
    private Long reporteId;

    private String nombreLaboratorio;
    private String nombreDocente;
    private String nombreMateria;
    private String nivelMateria;
    private String nombreCarrera;
    private String abreviaturaFacultad;
    private Time horaEntrada;
    private Time horaSalida;
    private String nombreBloque;

    public ReporteDTO(Long reporteId, String nombreLaboratorio, String nombreDocente, String nombreMateria, 
                      String nivelMateria, String nombreCarrera, String abreviaturaFacultad, Time horaEntrada, 
                      Time horaSalida, String nombreBloque) {
        this.reporteId = reporteId;
        this.nombreLaboratorio = nombreLaboratorio;
        this.nombreDocente = nombreDocente;
        this.nombreMateria = nombreMateria;
        this.nivelMateria = nivelMateria;
        this.nombreCarrera = nombreCarrera;
        this.abreviaturaFacultad = abreviaturaFacultad;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.nombreBloque = nombreBloque;
    }

    public Long getReporteId() {
        return reporteId;
    }

    public void setReporteId(Long reporteId) {
        this.reporteId = reporteId;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNivelMateria() {
        return nivelMateria;
    }

    public void setNivelMateria(String nivelMateria) {
        this.nivelMateria = nivelMateria;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getAbreviaturaFacultad() {
        return abreviaturaFacultad;
    }

    public void setAbreviaturaFacultad(String abreviaturaFacultad) {
        this.abreviaturaFacultad = abreviaturaFacultad;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

}
