package com.example.servicios_lab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.servicios_lab.DTO.ReporteDTO;
import com.example.servicios_lab.models.ReporteModel;
import com.example.servicios_lab.services.ReporteService;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    private final ReporteService reporteService;
    
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/detalle")
    public List<ReporteDTO> getCustomReporte() {
        return reporteService.findCustomReporte();
    }
}

