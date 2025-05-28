package com.sgrh.repository;

import com.sgrh.model.Asistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    List<Asistencia> findByHoraSalidaIsNull();


}
