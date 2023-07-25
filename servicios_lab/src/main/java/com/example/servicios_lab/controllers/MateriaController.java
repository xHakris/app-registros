package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.MateriaModel;
import com.example.servicios_lab.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {
    private final MateriaService materiaService;

    @Autowired
    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/obtenerMaterias")
    public List<MateriaModel> obtenerTodasLasMaterias() {
        return materiaService.obtenerTodasLasMaterias();
    }

    // Ruta para obtener una materia por su ID
    @GetMapping("/{id}")
    public MateriaModel obtenerMateriaPorId(@PathVariable Long id) {
        return materiaService.obtenerMateriaPorId(id);
    }

    // Ruta para crear una nueva materia
    @PostMapping("/guardar")
    public MateriaModel crearMateria(@RequestBody MateriaModel materia) {
        return this.materiaService.crearMateria(materia);
    }

    // Ruta para actualizar una materia existente
    @PutMapping("/actualizarMateria")
    public ResponseEntity<String> actualizarMateria(@RequestBody MateriaModel materia) {
        this.materiaService.actualizarMateria(materia);
        return ResponseEntity.ok("Materia actualizada exitosamente");
    }

    // Ruta para eliminar una materia por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMateria(@PathVariable Long id) {
        this.materiaService.eliminarMateria(id);
        return ResponseEntity.ok("Materia eliminada exitosamente");
    }
}
