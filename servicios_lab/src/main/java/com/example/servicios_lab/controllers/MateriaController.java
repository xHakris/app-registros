package com.example.servicios_lab.controllers;

import com.example.servicios_lab.DTO.MateriaDTO;
import com.example.servicios_lab.models.MateriaModel;
import com.example.servicios_lab.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
