package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.CarreraModel;
import com.example.servicios_lab.models.DocenteModel;
import com.example.servicios_lab.services.CarreraService;
import com.example.servicios_lab.services.DocentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraController {
    private final CarreraService carreraService;

    @Autowired
    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping("/obtenerCarreras")
    public List<CarreraModel> obtenerTodasLasCarreras() {
        return carreraService.obtenerTodosLosCarreras();
    }

    // Ruta para obtener una materia por su ID
    @GetMapping("/{id}")
    public CarreraModel obtenerCarreraPorId(@PathVariable Long id) {
        return carreraService.obtenerCarreraPorId(id);
    }

}
