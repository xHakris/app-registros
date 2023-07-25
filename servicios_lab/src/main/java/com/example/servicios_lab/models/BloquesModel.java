package com.example.servicios_lab.models;


import javax.persistence.*;
import java.util.Stack;

@Entity
@Table(name = "bloques")
public class BloquesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private int facultadID;

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

    public int getFacultadID() {
        return facultadID;
    }

    public void setFacultadID(int facultadID) {
        this.facultadID = facultadID;
    }
}
