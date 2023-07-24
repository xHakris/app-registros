package com.example.servicios_lab.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrera")
public class CarreraModel {
    @Id
    private int id;
    private  String nombre;
    private int bloqueID;

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

    public int getBloqueID() {
        return bloqueID;
    }

    public void setBloqueID(int bloqueID) {
        this.bloqueID = bloqueID;
    }
}
