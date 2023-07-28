package com.example.servicios_lab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicios_lab.models.PeriodoAcademicoModel;
import com.example.servicios_lab.services.PeriodoService;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {
    private final PeriodoService periodoService;

    @Autowired
    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping("/obtenerPeriodos")
    public List<PeriodoAcademicoModel> obtenerTodasLasPeriodos() {
        return periodoService.obtenerTodasLasPeriodos();
    }

    // Ruta para obtener una Periodo por su ID
    @GetMapping("/obtrnerPeriodos/{id}")
    public PeriodoAcademicoModel obtenerPeriodoPorId(@PathVariable Long id) {
        return periodoService.obtenerPeriodoPorId(id);
    }
}
