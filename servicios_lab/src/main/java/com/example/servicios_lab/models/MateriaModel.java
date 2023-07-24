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
    @ManyToOne
    @JoinColumn(name = "docenteID")
    private DocenteModel docente;

    @ManyToOne
    @JoinColumn(name = "carreraID")
    private CarreraModel carrera;

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

    public DocenteModel getDocente() {
        return docente;
    }

    public void setDocente(DocenteModel docente) {
        this.docente = docente;
    }

    public CarreraModel getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraModel carrera) {
        this.carrera = carrera;
    }
}
