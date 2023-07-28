package com.example.servicios_lab.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.models.MateriaModel;
import com.example.servicios_lab.repositories.IHorarioRepository;

@Service
public class HorarioService  {
    private final IHorarioRepository horarioRepository;

    @Autowired
    public HorarioService(IHorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<HorarioModel> getAllRegistros() {
        return horarioRepository.findAll();
    }

    public HorarioModel getRegistroById(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow();
    }

    public HorarioModel createRegistro(HorarioModel registro) {
        return horarioRepository.save(registro);
    }

    public HorarioModel updateRegistro(Long id, HorarioModel registro) {
        HorarioModel existingRegistro = getRegistroById(id);

        existingRegistro.setHoraEntrada(registro.getHoraEntrada());
        existingRegistro.setHoraSalida(registro.getHoraSalida());
        existingRegistro.setDia(registro.getDia());

        return horarioRepository.save(existingRegistro);
    }

    public void deleteRegistro(Long id) {
        HorarioModel existingRegistro = getRegistroById(id);
        horarioRepository.delete(existingRegistro);
    }

}
