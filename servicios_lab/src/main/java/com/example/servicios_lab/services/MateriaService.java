package com.example.servicios_lab.services;

import com.example.servicios_lab.DTO.MateriaDTO;
import com.example.servicios_lab.models.MateriaModel;
import com.example.servicios_lab.repositories.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;
    public MateriaService(IMateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    // Método para obtener todas las materias
    public List<MateriaModel> obtenerTodasLasMaterias() {
        return materiaRepository.findAll();
    }

    // Método para obtener una materia por su ID
    public MateriaModel obtenerMateriaPorId(Long id) {
        Optional<MateriaModel> optionalMateria = materiaRepository.findById(id);
        return optionalMateria.orElse(null);
    }

    // Método para crear una nueva materia

    public MateriaModel crearMateria(MateriaModel materiaModel) {
        return materiaRepository.save(materiaModel);
    }

    // Método para actualizar una materia existente
    @Transactional
    public void actualizarMateria(MateriaModel materia) {
        materiaRepository.save(materia);
    }

    // Método para eliminar una materia por su ID
    @Transactional
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }
}
