package com.example.servicios_lab.models;

import javax.persistence.*;

@Entity
@Table(name = "facultades")
public class FacultadModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @Column
    private String abreviatura;
    @Column
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
