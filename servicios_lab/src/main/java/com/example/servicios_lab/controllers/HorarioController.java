package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.services.HorarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/horarios")
public class HorarioController {
    private final HorarioService horariosService;

    @Autowired
    public HorarioController(HorarioService horariosService) {
        this.horariosService = horariosService;
    }

    @GetMapping
    public List<HorarioModel> getAllHorarios() {
        return horariosService.getHorariosInfo();
    }
}
