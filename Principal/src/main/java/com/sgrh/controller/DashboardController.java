package com.sgrh.controller;

import com.sgrh.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String mostrarDashboard(Model model) {
        model.addAttribute("permisosPorEstado", dashboardService.obtenerPermisosPorEstado());
        model.addAttribute("topEvaluados", dashboardService.obtenerTop5Evaluados());
        model.addAttribute("asistenciasPorDia", dashboardService.obtenerAsistenciasUltimos7Dias());
        return "dashboard";
    }
}
