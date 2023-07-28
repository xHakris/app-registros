package com.example.servicios_lab.models;

import javax.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "periodoacademico")
public class PeriodoAcademicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String inicioPeriodo;
    @Column
    private  String finPeriodo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getInicioPeriodo() {
        return inicioPeriodo;
    }
    public void setInicioPeriodo(String inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }
    public String getFinPeriodo() {
        return finPeriodo;
    }
    public void setFinPeriodo(String finPeriodo) {
        this.finPeriodo = finPeriodo;
    }
    
}
