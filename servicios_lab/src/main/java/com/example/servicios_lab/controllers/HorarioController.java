package com.example.servicios_lab.controllers;

import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/horarios")
public class HorarioController {
    private final HorarioService horarioService;

   @Autowired
   public HorarioController(HorarioService horarioService) {
       this.horarioService = horarioService;
   }

   @GetMapping("")
   public String listarHorarios(Model model) {
       model.addAttribute("horarios", horarioService.listarHorarios());
       return "horarios/lista"; // Vista que muestra la lista de horarios
   }

   @GetMapping("/{id}")
   public String verHorario(@PathVariable Long id, Model model) {
       HorarioModel horario = horarioService.obtenerHorarioPorId(id);
       model.addAttribute("horario", horario);
       return "horarios/detalle"; // Vista que muestra los detalles de un horario específico
   }

   @PostMapping("")
   public String crearHorario(@ModelAttribute HorarioModel horario) {
       horarioService.crearHorario(horario);
       return "redirect:/horarios";
   }

   @PutMapping("/{id}")
   public String actualizarHorario(@PathVariable Long id, @ModelAttribute HorarioModel horario) {
       horario.setId(id);
       horarioService.actualizarHorario(horario);
       return "redirect:/horarios";
   }

   @DeleteMapping("/{id}")
   public String eliminarHorario(@PathVariable Long id) {
       horarioService.eliminarHorario(id);
       return "redirect:/horarios";
   }
}
