package com.sgrh.service;

import com.sgrh.model.Empleado;
import com.sgrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    public void guardar(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public Empleado obtenerPorId(Integer id) {
        Optional<Empleado> optional = empleadoRepository.findById(id);
        return optional.orElse(null);
    }

    public void eliminar(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
