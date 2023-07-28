package com.example.servicios_lab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicios_lab.models.ReporteModel;
import com.example.servicios_lab.repositories.IReporteRepository;

@Service
public class ReporteService {
    private final IReporteRepository reporteRepository;

    @Autowired
    public ReporteService(IReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    public ReporteModel save(ReporteModel reporte) {
        return reporteRepository.save(reporte);
    }

    public ReporteModel findById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public List<ReporteModel> findAll() {
        return reporteRepository.findAll();
    }

    public ReporteModel update(ReporteModel reporte, Long id) {
        reporte.setId(id);
        return reporteRepository.save(reporte);
    }

    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }
}
