package com.sgrh.controller;

import com.sgrh.dto.NominaResponse;
import com.sgrh.service.EmpleadoService;
import com.sgrh.service.NominaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nomina")
public class NominaController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private NominaApiService nominaApiService;

    @GetMapping
    public String verNomina(@RequestParam(required = false) Long empleadoId, Model model) {
        model.addAttribute("empleados", empleadoService.listarTodos());

        if (empleadoId != null) {
            NominaResponse nomina = nominaApiService.obtenerDatosNomina(empleadoId);
            model.addAttribute("nomina", nomina);
        }

        return "nomina";
    }
}


