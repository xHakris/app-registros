package com.example.servicios_lab.services;

import com.example.servicios_lab.models.FacultadModel;
import com.example.servicios_lab.repositories.IFacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {
    @Autowired
    private IFacultadRepository facultadRepository;
    public FacultadService(IFacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    // Método para obtener todas las Bloques
    public List<FacultadModel> obtenerTodosLosBloques() {
        return facultadRepository.findAll();
    }

    // Método para obtener un Bloque por su ID
    public FacultadModel obtenerBloquePorId(Long id) {
        Optional<FacultadModel> optionalBloque = facultadRepository.findById(id);
        return optionalBloque.orElse(null);
    }
}
