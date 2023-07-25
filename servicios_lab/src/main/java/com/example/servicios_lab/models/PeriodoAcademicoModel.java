package com.example.servicios_lab.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "periodoacademico")
public class PeriodoAcademicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date inicioPeriodo;
    @Column
    private  Date finPeriodo;
}
