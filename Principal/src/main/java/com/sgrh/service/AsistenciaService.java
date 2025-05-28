package com.sgrh.service;

import com.sgrh.model.Asistencia;
import com.sgrh.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> listarTodas() {
        return asistenciaRepository.findAll();
    }

    public void guardar(Asistencia asistencia) {
        asistenciaRepository.save(asistencia);
    }

    public Asistencia obtenerPorId(Integer id) {
        Optional<Asistencia> optional = asistenciaRepository.findById(id);
        return optional.orElse(null);
    }

    public void eliminar(Integer id) {
        asistenciaRepository.deleteById(id);
    }

    public List<Asistencia> obtenerEntradasSinSalida() {
        return asistenciaRepository.findByHoraSalidaIsNull();
    }
    
}
