package com.example.servicios_lab.models;

import javax.persistence.*;

@Entity
@Table(name = "materia")
public class MateriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private int docenteID;
    @Column
    private int carreraID;
    @Column
    private int nivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
}
