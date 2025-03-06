package com.crud.crudProyecto.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tareas_f")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarea_id", nullable = false)
    private Long tarea_id;
    private String nombre_tarea;
    private String prioridad;
    private String resumen;
    private String encargado_tarea;
    private String estado;
    private LocalDate sprint_tarea;

    public Long getId() {
        return this.tarea_id;
    }



}