package com.sgrh.controller;

import com.sgrh.model.EvaluacionDesempeno;
import com.sgrh.service.EmpleadoService;
import com.sgrh.service.EvaluacionService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("evaluaciones", evaluacionService.listarTodas());
        return "evaluacion_list";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("evaluacion", new EvaluacionDesempeno());
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "evaluacion_form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EvaluacionDesempeno evaluacion) {
        evaluacion.setFecha(LocalDate.now()); // ← Fecha del sistema
        evaluacionService.guardar(evaluacion);
        return "redirect:/evaluaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        evaluacionService.eliminar(id);
        return "redirect:/evaluaciones";
    }
}
