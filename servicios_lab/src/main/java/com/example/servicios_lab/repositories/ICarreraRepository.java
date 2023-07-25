package com.example.servicios_lab.repositories;

import com.example.servicios_lab.models.CarreraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarreraRepository extends JpaRepository<CarreraModel, Long> {
}
