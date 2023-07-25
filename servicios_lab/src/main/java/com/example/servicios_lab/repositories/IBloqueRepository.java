package com.example.servicios_lab.repositories;

import com.example.servicios_lab.models.BloquesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBloqueRepository extends JpaRepository<BloquesModel, Long> {
}
