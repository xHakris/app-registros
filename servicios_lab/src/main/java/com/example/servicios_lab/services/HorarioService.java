package com.example.servicios_lab.services;

import com.example.servicios_lab.models.HorarioModel;
import com.example.servicios_lab.repositories.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService  {
     @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<HorarioModel> getHorariosInfo() {
        String query = "SELECT id, horaEntrada, horaSalida, dia FROM horarios";

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            HorarioModel horario = new HorarioModel();
            horario.setId(rs.getLong("id"));
            horario.setHoraEntrada(rs.getString("horaEntrada"));
            horario.setHoraSalida(rs.getString("horaSalida"));
            horario.setDia(rs.getString("dia"));

            return horario;
        });
    }

}
