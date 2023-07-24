package com.example.servicios_lab.controllers;

import com.example.servicios_lab.DTO.MateriaDTO;
import com.example.servicios_lab.models.MateriaModel;
import com.example.servicios_lab.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/obtenerMaterias")
    public List<MateriaModel> getMaterias() {
        return this.materiaService.getMaterias();
    }

    // Ruta para obtener una materia por su ID
    @GetMapping("/{id}")
    public MateriaModel getMateriaById(@PathVariable int id) {
        return this.materiaService.getMateriaById(id);
    }

    // Ruta para crear una nueva materia
    @PostMapping("/crearMateria")
    public ResponseEntity<String> crearMateria(@RequestBody MateriaModel materia) {
        this.materiaService.crearMateria(materia);
        return ResponseEntity.ok("Materia creada exitosamente");
    }

    // Ruta para actualizar una materia existente
    @PutMapping("/actualizarMateria")
    public ResponseEntity<String> actualizarMateria(@RequestBody MateriaModel materia) {
        this.materiaService.actualizarMateria(materia);
        return ResponseEntity.ok("Materia actualizada exitosamente");
    }

    // Ruta para eliminar una materia por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMateria(@PathVariable int id) {
        this.materiaService.eliminarMateria(id);
        return ResponseEntity.ok("Materia eliminada exitosamente");
    }
}
