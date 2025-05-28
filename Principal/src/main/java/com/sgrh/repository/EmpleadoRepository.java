package com.sgrh.repository;

import com.sgrh.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    // Puedes agregar métodos personalizados aquí si lo necesitas luego
}
