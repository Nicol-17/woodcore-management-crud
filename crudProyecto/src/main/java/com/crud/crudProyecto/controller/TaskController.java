package com.crud.crudProyecto.controller;

import com.crud.crudProyecto.entity.TaskEntity;
import com.crud.crudProyecto.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Método GET para obtener todas las tareas
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        List<TaskEntity> taskList = taskService.getAll();
        return ResponseEntity.ok(taskList);
    }

    // Método POST para crear una nueva tarea
    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestBody TaskEntity taskEntity) {
        taskService.create(taskEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarea creada exitosamente");
    }

    // Método PUT para actualizar una tarea existente
    @PutMapping("/tasks")
    public ResponseEntity<String> updateTask(@RequestBody TaskEntity taskEntity) {
        if (taskEntity.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID de tarea requerido para actualizar");
        }
        taskService.update(taskEntity.getId(), taskEntity);
        return ResponseEntity.ok("Tarea actualizada exitosamente");
    }

    // Método DELETE para eliminar una tarea por ID
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        try {
            taskService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarea no encontrada");
        }
    }
}
