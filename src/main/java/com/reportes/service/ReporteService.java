package com.reportes.service;

import com.reportes.model.Reporte;
import com.reportes.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public List<Reporte> saveAll(List<Reporte> reportes) {
        return reporteRepository.saveAll(reportes);
    }

    public List<Reporte> findAll() {
        return reporteRepository.findAll();
    }

    public Reporte findById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }
}
