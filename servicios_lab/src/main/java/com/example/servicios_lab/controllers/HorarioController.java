package com.example.servicios_lab.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.services.HorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    private final HorarioService registroHorasService;

    @Autowired
    public HorarioController(HorarioService registroHorasService) {
        this.registroHorasService = registroHorasService;
    }

    @GetMapping("/obtenerHorarios")
    public List<HorarioModel> getAllRegistros() {
        return registroHorasService.getAllRegistros();
    }

    @GetMapping("/obtenerHorario/{id}")
    public HorarioModel getRegistroById(@PathVariable Long id) {
        return registroHorasService.getRegistroById(id);
    }

    @PostMapping("crearHorario")
    public HorarioModel createRegistro(@RequestBody HorarioModel registro) {
        return registroHorasService.createRegistro(registro);
    }

    @PutMapping("/editarHorario/{id}")
    public HorarioModel updateRegistro(@PathVariable Long id, @RequestBody HorarioModel registro) {
        return registroHorasService.updateRegistro(id, registro);
    }

    @DeleteMapping("/eliminarHorario/{id}")
    public ResponseEntity<String> deleteRegistro(@PathVariable Long id) {
        registroHorasService.deleteRegistro(id);
        return ResponseEntity.ok("Registro eliminado correctamente");
    }
}
