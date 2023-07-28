package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.FacultadModel;
import com.example.servicios_lab.services.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facultad")
public class FacultadController {
    private final FacultadService facultadService;

    @Autowired
    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping("/obtenerFacultades")
    public List<FacultadModel> obtenerTodasLasBloques() {
        return facultadService.obtenerTodosLosBloques();
    }

    // Ruta para obtener una materia por su ID
    @GetMapping("/{id}")
    public FacultadModel obtenerBloquePorId(@PathVariable Long id) {
        return facultadService.obtenerBloquePorId(id);
    }

}
