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
}
