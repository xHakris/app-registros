package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.BloquesModel;
import com.example.servicios_lab.models.CarreraModel;
import com.example.servicios_lab.services.BloqueService;
import com.example.servicios_lab.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bloque")
public class BloqueController {
    private final BloqueService bloqueService;

    @Autowired
    public BloqueController(BloqueService bloqueService) {
        this.bloqueService = bloqueService;
    }

    @GetMapping("/obtenerBloques")
    public List<BloquesModel> obtenerTodasLasBloques() {
        return bloqueService.obtenerTodosLosBloques();
    }

    // Ruta para obtener una materia por su ID
    @GetMapping("/{id}")
    public BloquesModel obtenerBloquePorId(@PathVariable Long id) {
        return bloqueService.obtenerBloquePorId(id);
    }
}
