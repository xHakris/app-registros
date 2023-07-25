package com.example.servicios_lab.models;


import javax.persistence.*;
import java.util.Stack;

@Entity
@Table(name = "bloques")
public class BloquesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int facultadID;

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

    public int getFacultadID() {
        return facultadID;
    }

    public void setFacultadID(int facultadID) {
        this.facultadID = facultadID;
    }
}
