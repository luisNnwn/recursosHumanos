package com.sgrh.service;

import com.sgrh.model.Permiso;
import com.sgrh.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Permiso> listarTodos() {
        return permisoRepository.findAll();
    }

    public void guardar(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    public Permiso obtenerPorId(Integer id) {
        return permisoRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        permisoRepository.deleteById(id);
    }
    
}
