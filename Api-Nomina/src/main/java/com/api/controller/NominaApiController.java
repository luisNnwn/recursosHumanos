package com.api.controller;

import com.api.dto.NominaResponse;
import com.api.model.Empleado;
import com.api.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/nomina/api")
public class NominaApiController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<NominaResponse> obtenerNomina(@PathVariable Long id) {
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(id);

        if (!empleadoOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Empleado empleado = empleadoOpt.get();

        NominaResponse nomina = new NominaResponse();
        nomina.setEmpleadoId(empleado.getId());
        nomina.setNombre(empleado.getNombre() + " " + empleado.getApellido());
        nomina.setSueldoBase(empleado.getSalario());

        // Simulaciones de ejemplo (o puedes almacenarlas también en BD si deseas)
        double bonos = 150.0;
        double descuentos = 50.0;

        nomina.setBonos(bonos);
        nomina.setDescuentos(descuentos);
        nomina.setSueldoNeto(empleado.getSalario() + bonos - descuentos);

        return ResponseEntity.ok(nomina);
    }
}


