package com.sgrh.controller;

import com.sgrh.model.Permiso;
import com.sgrh.service.EmpleadoService;
import com.sgrh.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("permisos", permisoService.listarTodos());
        return "permiso_list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("permiso", new Permiso());
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "permiso_form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Permiso permiso) {
        permiso.setEstado("Pendiente");
        permisoService.guardar(permiso);
        return "redirect:/permisos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        permisoService.eliminar(id);
        return "redirect:/permisos";
    }

    @GetMapping("/aprobar/{id}")
    public String aprobar(@PathVariable Integer id) {
        Permiso permiso = permisoService.obtenerPorId(id);
        permiso.setEstado("Aprobado");
        permisoService.guardar(permiso);
        return "redirect:/permisos";
}

    @GetMapping("/rechazar/{id}")
    public String rechazar(@PathVariable Integer id) {
        Permiso permiso = permisoService.obtenerPorId(id);
        permiso.setEstado("Rechazado");
        permisoService.guardar(permiso);
        return "redirect:/permisos";
}

}
