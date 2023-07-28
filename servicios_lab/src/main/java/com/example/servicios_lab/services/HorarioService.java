package com.example.servicios_lab.services;

import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.repositories.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService  {
    private final IHorarioRepository horarioRepository;
    @Autowired
    public HorarioService(IHorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }
    public List<HorarioModel> listarHorarios() {
        return horarioRepository.findAll();
    }
    public HorarioModel obtenerHorarioPorId(Long id) {
        Optional<HorarioModel> horarioOptional = horarioRepository.findById(id);
        if (horarioOptional.isPresent()) {
            return horarioOptional.get();
        } else {
            throw new RuntimeException("El horario con el id " + id + " no se encontró");
        }
    }
    public void crearHorario(HorarioModel horario) {
        horarioRepository.save(horario);
    }
    public void actualizarHorario(HorarioModel horario) {
        horarioRepository.save(horario);
    }
    public void eliminarHorario(Long id) {
        horarioRepository.deleteById(id);
    }

}
