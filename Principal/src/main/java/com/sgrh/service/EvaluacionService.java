package com.sgrh.service;

import com.sgrh.model.EvaluacionDesempeno;
import com.sgrh.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<EvaluacionDesempeno> listarTodas() {
        return evaluacionRepository.findAll();
    }

    public void guardar(EvaluacionDesempeno evaluacion) {
        evaluacionRepository.save(evaluacion);
    }

    public void eliminar(Integer id) {
        evaluacionRepository.deleteById(id);
    }
}
