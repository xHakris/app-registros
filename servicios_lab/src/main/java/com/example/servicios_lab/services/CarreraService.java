package com.example.servicios_lab.services;

import com.example.servicios_lab.models.CarreraModel;
import com.example.servicios_lab.models.DocenteModel;
import com.example.servicios_lab.repositories.ICarreraRepository;
import com.example.servicios_lab.repositories.IDocentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {
    @Autowired
    private ICarreraRepository carreraRepository;
    public CarreraService(ICarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    // Método para obtener todas las Carreras
    public List<CarreraModel> obtenerTodosLosCarreras() {
        return carreraRepository.findAll();
    }

    // Método para obtener una Carrera por su ID
    public CarreraModel obtenerCarreraPorId(Long id) {
        Optional<CarreraModel> optionalCarrera = carreraRepository.findById(id);
        return optionalCarrera.orElse(null);
    }

}
