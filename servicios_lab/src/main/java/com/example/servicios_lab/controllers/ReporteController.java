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

    @Autowired
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<ReporteModel> createReporte(@RequestBody ReporteModel reporte) {
        ReporteModel savedReporte = reporteService.save(reporte);
        return new ResponseEntity<>(savedReporte, HttpStatus.CREATED);
    }

    @GetMapping("/obtenerReporte/{id}")
    public ResponseEntity<ReporteModel> getReporte(@PathVariable Long id) {
        ReporteModel reporte = reporteService.findById(id);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping("/obtenerReportes")
    public ResponseEntity<List<ReporteModel>> getAllReportes() {
        List<ReporteModel> reportes = reporteService.findAll();
        return new ResponseEntity<>(reportes, HttpStatus.OK);
    }

    @PutMapping("/modificarReporte/{id}")
    public ResponseEntity<ReporteModel> updateReporte(@RequestBody ReporteModel reporte, @PathVariable Long id) {
        ReporteModel updatedReporte = reporteService.update(reporte, id);
        return new ResponseEntity<>(updatedReporte, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarReporte/{id}")
    public ResponseEntity<?> deleteReporte(@PathVariable Long id) {
        reporteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detalle")
    public ResponseEntity<List<ReporteDTO>> getCustomReporte() {
        List<ReporteDTO> reporte = reporteService.findCustomReporte();
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }
}
