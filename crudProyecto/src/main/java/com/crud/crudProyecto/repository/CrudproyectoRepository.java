package com.crud.crudProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.crudProyecto.entity.Crudproyecto;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudproyectoRepository extends JpaRepository <Crudproyecto, Long> {
}
