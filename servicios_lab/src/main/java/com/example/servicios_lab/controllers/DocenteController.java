package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.DocenteModel;
import com.example.servicios_lab.services.DocentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {
    private final DocentesService docentesService;

    @Autowired
    public DocenteController(DocentesService docentesService) {
        this.docentesService = docentesService;
    }

    @GetMapping("/obtenerDocentes")
    public List<DocenteModel> obtenerTodasLosDocentes() {
        return docentesService.obtenerTodosLosDocentes();
    }

    // Ruta para obtener una materia por su ID
    @GetMapping("/{id}")
    public DocenteModel obtenerdocentePorId(@PathVariable Long id) {
        return docentesService.obtenerDocentePorId(id);
    }

    // Ruta para crear una nueva materia
    @PostMapping("/guardar")
    public DocenteModel crearDocente(@RequestBody DocenteModel docenteModel) {
        return this.docentesService.crearDocente(docenteModel);
    }

    // Ruta para actualizar una materia existente
    @PutMapping("/actualizarMateria")
    public ResponseEntity<String> actualizarDocente(@RequestBody DocenteModel docenteModel) {
        this.docentesService.actualizarDocente(docenteModel);
        return ResponseEntity.ok("Docente actualizada exitosamente");
    }

    // Ruta para eliminar una materia por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDocente(@PathVariable Long id) {
        this.docentesService.eliminarDocente(id);
        return ResponseEntity.ok("Docente eliminada exitosamente");
    }
}
