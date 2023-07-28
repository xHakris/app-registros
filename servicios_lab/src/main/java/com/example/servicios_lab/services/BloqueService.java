package com.example.servicios_lab.services;

import com.example.servicios_lab.models.BloquesModel;
import com.example.servicios_lab.repositories.IBloqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloqueService {

    @Autowired
    private IBloqueRepository bloqueRepository;
    public BloqueService(IBloqueRepository bloqueRepository) {
        this.bloqueRepository = bloqueRepository;
    }

    // Método para obtener todas las Bloques
    public List<BloquesModel> obtenerTodosLosBloques() {
        return bloqueRepository.findAll();
    }

    // Método para obtener un Bloque por su ID
    public BloquesModel obtenerBloquePorId(Long id) {
        Optional<BloquesModel> optionalBloque = bloqueRepository.findById(id);
        return optionalBloque.orElse(null);
    }
}
