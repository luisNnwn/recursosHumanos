package com.sgrh.converter;

import com.sgrh.model.Empleado;
import com.sgrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEmpleadoConverter implements Converter<String, Empleado> {

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    public Empleado convert(String id) {
        try {
            Integer empleadoId = Integer.valueOf(id);
            return empleadoService.obtenerPorId(empleadoId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
