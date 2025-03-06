package com.crud.crudProyecto.repository;

import com.crud.crudProyecto.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}