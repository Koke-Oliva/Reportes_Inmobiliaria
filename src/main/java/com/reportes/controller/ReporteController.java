package com.reportes.controller;

import com.reportes.model.Reporte;
import com.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> getAllReportes() {
        return ResponseEntity.ok(reporteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable Long id) {
        return ResponseEntity.ok(reporteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Reporte> createReporte(@RequestBody Reporte reporte) {
        return ResponseEntity.ok(reporteService.save(reporte));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Reporte>> createBatchReportes(@RequestBody List<Reporte> reportes) {
        return ResponseEntity.ok(reporteService.saveAll(reportes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> updateReporte(@PathVariable Long id, @RequestBody Reporte reporte) {
        reporte.setId(id);
        return ResponseEntity.ok(reporteService.save(reporte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        reporteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
