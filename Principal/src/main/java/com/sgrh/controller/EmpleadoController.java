package com.sgrh.controller;

import com.sgrh.model.Empleado;
import com.sgrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Mostrar lista de empleados
    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "empleado_list";
    }

    // Mostrar formulario para nuevo empleado
    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleado_form";
    }

    // Guardar empleado (nuevo o editado)
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }

    // Mostrar formulario para editar empleado
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        model.addAttribute("empleado", empleado);
        return "empleado_form";
    }

    // Eliminar empleado
    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.eliminar(id);
        return "redirect:/empleados";
    }
}
