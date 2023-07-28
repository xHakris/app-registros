package com.example.servicios_lab.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servicios_lab.models.HorarioModel;

@Repository
public interface IHorarioRepository extends JpaRepository<HorarioModel,Long> {
    
}
