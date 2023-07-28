package com.example.servicios_lab.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reporte")
public class ReporteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private PeriodoAcademicoModel periodo;

    @ManyToOne
    @JoinColumn(name = "id_Horario")
    private HorarioModel horario;

    @ManyToOne
    @JoinColumn(name = "id_Laboratorio")
    private LaboratorioModel laboratorio;

    @ManyToOne
    @JoinColumn(name = "id_Materia")
    private MateriaModel materia;

    @ManyToOne
    @JoinColumn(name = "id_paralelo")
    private ParaleloModel paralelo;

    private String auxiliar;
    private Date fecha;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PeriodoAcademicoModel getPeriodo() {
        return periodo;
    }
    public void setPeriodo(PeriodoAcademicoModel periodo) {
        this.periodo = periodo;
    }
    public HorarioModel getHorario() {
        return horario;
    }
    public void setHorario(HorarioModel horario) {
        this.horario = horario;
    }
    public LaboratorioModel getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(LaboratorioModel laboratorio) {
        this.laboratorio = laboratorio;
    }
    public MateriaModel getMateria() {
        return materia;
    }
    public void setMateria(MateriaModel materia) {
        this.materia = materia;
    }
    public ParaleloModel getParalelo() {
        return paralelo;
    }
    public void setParalelo(ParaleloModel paralelo) {
        this.paralelo = paralelo;
    }
    public String getAuxiliar() {
        return auxiliar;
    }
    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
