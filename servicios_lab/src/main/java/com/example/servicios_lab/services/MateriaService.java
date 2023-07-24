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

@Service
public class MateriaService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MateriaModel> getMaterias() {
        // Utilizamos JPQL para hacer la consulta a la base de datos
        String jpql = "SELECT m.id, m.nombre, d.nombre, c.nombre " +
                "FROM MateriaModel m " +
                "LEFT JOIN m.docente d " +
                "LEFT JOIN m.carrera c";

        List<MateriaModel> materias = entityManager.createQuery(jpql).getResultList();

        return materias;
    }

    // Método para obtener una materia por su ID
    public MateriaModel getMateriaById(int id) {
        return entityManager.find(MateriaModel.class, id);
    }

    // Método para crear una nueva materia
    @Transactional
    public void crearMateria(MateriaModel materia) {
        entityManager.persist(materia);
    }

    // Método para actualizar una materia existente
    @Transactional
    public void actualizarMateria(MateriaModel materia) {
        entityManager.merge(materia);
    }

    // Método para eliminar una materia por su ID
    @Transactional
    public void eliminarMateria(int id) {
        MateriaModel materia = entityManager.find(MateriaModel.class, id);
        if (materia != null) {
            entityManager.remove(materia);
        }
    }
}
