package com.example.servicios_lab.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reporte")
public class ReporteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int id_periodo;
    @Column
    private int id_Horario;
    @Column
    private int id_Laboratorio;
    @Column
    private int id_Materia;
    @Column
    private String auxiliar;
    @Column
    private String nivel;
    @Column
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public int getId_Horario() {
        return id_Horario;
    }

    public void setId_Horario(int id_Horario) {
        this.id_Horario = id_Horario;
    }

    public int getId_Laboratorio() {
        return id_Laboratorio;
    }

    public void setId_Laboratorio(int id_Laboratorio) {
        this.id_Laboratorio = id_Laboratorio;
    }

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public String getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
