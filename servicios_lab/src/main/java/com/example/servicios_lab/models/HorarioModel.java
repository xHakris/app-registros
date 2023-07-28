package com.example.servicios_lab.models;

import javax.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "horarios")
public class HorarioModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "horaEntrada")
   private String horaEntrada;
   @Column(name = "horaSalida")
   private String horaSalida;
   @Column(name = "dia")
   private String dia;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getHoraEntrada() {
    return horaEntrada;
}
public void setHoraEntrada(String horaEntrada) {
    this.horaEntrada = horaEntrada;
}
public String getHoraSalida() {
    return horaSalida;
}
public void setHoraSalida(String horaSalida) {
    this.horaSalida = horaSalida;
}
public String getDia() {
    return dia;
}
public void setDia(String dia) {
    this.dia = dia;
}

    
}
