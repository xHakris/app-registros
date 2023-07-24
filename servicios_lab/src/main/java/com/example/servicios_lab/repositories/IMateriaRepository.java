package com.example.servicios_lab.repositories;

import com.example.servicios_lab.models.MateriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<MateriaModel, Long> {
}
