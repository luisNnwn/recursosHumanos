package com.sgrh.controller;

import com.sgrh.model.Asistencia;
import com.sgrh.model.Empleado;
import com.sgrh.service.AsistenciaService;
import com.sgrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listarAsistencias(Model model) {
        List<Asistencia> asistencias = asistenciaService.listarTodas();
        
        List<Asistencia> completadas = asistencias.stream()
            .filter(a -> a.getHoraSalida() != null)
            .toList();

        List<Asistencia> sinSalida = asistencias.stream()
            .filter(a -> a.getHoraSalida() == null)
            .toList();

        model.addAttribute("asistenciasCompletas", completadas);
        model.addAttribute("asistenciasSinSalida", sinSalida);
        return "asistencia_list";
    }
    
    @GetMapping("/entrada")
    public String registrarEntrada(Model model) {
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "asistencia_entrada_form";
    }

    @PostMapping("/guardarEntrada")
    public String guardarEntrada(@RequestParam("empleadoId") Integer empleadoId) {
        Empleado empleado = empleadoService.obtenerPorId(empleadoId);
        Asistencia asistencia = new Asistencia();
        asistencia.setEmpleado(empleado);
        asistencia.setFecha(LocalDate.now());
        asistencia.setHoraEntrada(LocalTime.now());
        asistenciaService.guardar(asistencia);
        return "redirect:/asistencias";
    }

    @GetMapping("/salida")
    public String registrarSalida(Model model) {
        model.addAttribute("entradas", asistenciaService.obtenerEntradasSinSalida());
        return "asistencia_salida_form";
    }

    @PostMapping("/guardarSalida")
    public String guardarSalida(@RequestParam("asistenciaId") Integer asistenciaId) {
        Asistencia asistencia = asistenciaService.obtenerPorId(asistenciaId);
        asistencia.setHoraSalida(LocalTime.now());
        asistenciaService.guardar(asistencia);
        return "redirect:/asistencias";
    }

}
