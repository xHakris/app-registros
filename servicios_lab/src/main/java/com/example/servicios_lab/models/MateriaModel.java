package com.example.servicios_lab.models;

import javax.persistence.*;

@Entity
@Table(name = "materia")
public class MateriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nombre;
    @Column
    private int docenteID;
    @Column
    private int carreraID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocenteID() {
        return docenteID;
    }

    public void setDocenteID(int docenteID) {
        this.docenteID = docenteID;
    }

    public int getCarreraID() {
        return carreraID;
    }

    public void setCarreraID(int carreraID) {
        this.carreraID = carreraID;
    }
}
