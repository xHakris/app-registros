package com.example.servicios_lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicios_lab.models.PeriodoAcademicoModel;
import com.example.servicios_lab.repositories.IPeriodoRepository;

@Service
public class PeriodoService {

    @Autowired
    private IPeriodoRepository periodoRepository;
    public PeriodoService(IPeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }
    
    // Método para obtener todas las Periodos
    public List<PeriodoAcademicoModel> obtenerTodasLasPeriodos() {
        return periodoRepository.findAll();
    }

    // Método para obtener una materia por su ID
    public PeriodoAcademicoModel obtenerPeriodoPorId(Long id) {
        Optional<PeriodoAcademicoModel> optionalMateria = periodoRepository.findById(id);
        return optionalMateria.orElse(null);
    }

}
