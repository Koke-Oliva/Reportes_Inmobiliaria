package com.reportes.controller;

import com.reportes.model.Reporte;
import com.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reportes", description = "API para operaciones de reportes")
@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;
    
    @Operation(summary = "Obtener todos los reportes", description = "Devuelve una lista de todos los reportes")   
    @GetMapping
    public ResponseEntity<List<Reporte>> getAllReportes() {
        return ResponseEntity.ok(reporteService.findAll());
    }
    
    @Operation(summary = "Obtener reporte por ID", description = "Devuelve un reporte específico por su ID")    
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable Long id) {
        return ResponseEntity.ok(reporteService.findById(id));
    }
    
    @Operation(summary = "Crear nuevo reporte", description = "Crea un nuevo reporte")
    @PostMapping
    public ResponseEntity<Reporte> createReporte(@RequestBody Reporte reporte) {
        return ResponseEntity.ok(reporteService.save(reporte));
    }

    @Operation(summary = "Crear múltiples reportes", description = "Crea múltiples reportes")    
    @PostMapping("/batch")
    public ResponseEntity<List<Reporte>> createBatchReportes(@RequestBody List<Reporte> reportes) {
        return ResponseEntity.ok(reporteService.saveAll(reportes));
    }
    
    @Operation(summary = "Actualizar reporte por ID", description = "Actualiza un reporte existente por su ID")    
    @PutMapping("/{id}")
    public ResponseEntity<Reporte> updateReporte(@PathVariable Long id, @RequestBody Reporte reporte) {
        reporte.setId(id);
        return ResponseEntity.ok(reporteService.save(reporte));
    }
    
    @Operation(summary = "Eliminar reporte por ID", description = "Elimina un reporte por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        reporteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
