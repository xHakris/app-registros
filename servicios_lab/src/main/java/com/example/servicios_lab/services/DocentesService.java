package com.example.servicios_lab.services;

import com.example.servicios_lab.models.DocenteModel;
import com.example.servicios_lab.repositories.IDocentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class DocentesService {
    @Autowired
    private IDocentesRepository docentesRepository;
    public DocentesService(IDocentesRepository docentesRepository) {
        this.docentesRepository = docentesRepository;
    }

    // Método para obtener todas las docentes
    public List<DocenteModel> obtenerTodosLosDocentes() {
        return docentesRepository.findAll();
    }

    // Método para obtener una docente por su ID
    public DocenteModel obtenerDocentePorId(Long id) {
        Optional<DocenteModel> optionalDocente = docentesRepository.findById(id);
        return optionalDocente.orElse(null);
    }

    // Método para crear una nueva docente

    public DocenteModel crearDocente(DocenteModel docenteModel) {
        return docentesRepository.save(docenteModel);
    }

    // Método para actualizar una docente existente
    @Transactional
    public void actualizarDocente(DocenteModel docente) {
        docentesRepository.save(docente);
    }

    // Método para eliminar una docente por su ID
    @Transactional
    public void eliminarDocente(Long id) {
        docentesRepository.deleteById(id);
    }

}
