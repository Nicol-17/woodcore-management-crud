package com.crud.crudProyecto.controller;

import com.crud.crudProyecto.entity.Crudproyecto;
import com.crud.crudProyecto.service.CrudproyectoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController


public class CrudproyectoController {

    @Autowired
    CrudproyectoService crudproyectoService;

    @GetMapping("/crudProyecto")
    public ResponseEntity<List<Crudproyecto>> verCrudproyecto() {
        List<Crudproyecto> proyectos = crudproyectoService.verCrudproyecto();
        return ResponseEntity.ok(proyectos);
    }

    @PostMapping("/crudProyecto")
    public ResponseEntity<String> crearCrudproyecto(@RequestBody Crudproyecto crudproyecto) {
        crudproyectoService.crearYActualizarCrudproyecto(crudproyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Proyecto creado exitosamente");
    }

    @PutMapping("/crudProyecto/{id}")
    public ResponseEntity<String> editarCrudproyecto(@RequestBody Crudproyecto crudproyecto) {
        if (crudproyecto.getId_proyecto() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID de proyecto requerido para actualizar");
        }
        crudproyectoService.crearYActualizarCrudproyecto(crudproyecto);
        return ResponseEntity.ok("Proyecto actualizado exitosamente");
    }

    @DeleteMapping("/crudProyecto/{id}")
    public ResponseEntity<String> eliminarCrudproyecto(@PathVariable("id") Long id) {
        try {
            crudproyectoService.eliminarCrudproyecto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proyecto no encontrado");
        }
    }
}
