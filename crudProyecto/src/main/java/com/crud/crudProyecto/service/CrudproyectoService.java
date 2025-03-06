package com.crud.crudProyecto.service;

import com.crud.crudProyecto.entity.Crudproyecto;
import com.crud.crudProyecto.repository.CrudproyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CrudproyectoService {

    @Autowired
    CrudproyectoRepository crudproyectoRepository;

    public void crearYActualizarCrudproyecto(Crudproyecto crudproyecto){
        crudproyectoRepository.save(crudproyecto);

    }
    public List<Crudproyecto> verCrudproyecto(){
        List<Crudproyecto> crudproyectos = new ArrayList<Crudproyecto>();
        crudproyectos.addAll(crudproyectoRepository.findAll());
        return crudproyectos;

    }
    public void eliminarCrudproyecto(Long id){
        crudproyectoRepository.deleteAllById(Collections.singleton(id));

    }

}
