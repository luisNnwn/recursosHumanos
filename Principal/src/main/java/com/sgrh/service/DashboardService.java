
package com.sgrh.service;

import com.sgrh.model.Asistencia;
import com.sgrh.model.EvaluacionDesempeno;
import com.sgrh.model.Permiso;
import com.sgrh.repository.AsistenciaRepository;
import com.sgrh.repository.EvaluacionRepository;
import com.sgrh.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Gráfico 1: Cantidad de permisos por estado
    public Map<String, Long> obtenerPermisosPorEstado() {
        List<Permiso> permisos = permisoRepository.findAll();
        return permisos.stream()
                .collect(Collectors.groupingBy(Permiso::getEstado, Collectors.counting()));
    }

    // Gráfico 2: Top 5 empleados mejor evaluados (por promedio de puntuación)
    public Map<String, Double> obtenerTop5Evaluados() {
        List<EvaluacionDesempeno> evaluaciones = evaluacionRepository.findAll();

        Map<String, List<Integer>> mapaNotas = new HashMap<>();

        for (EvaluacionDesempeno eval : evaluaciones) {
            String nombre = eval.getEmpleado().getNombre() + " " + eval.getEmpleado().getApellido();
            mapaNotas.putIfAbsent(nombre, new ArrayList<>());
            mapaNotas.get(nombre).add(eval.getPuntuacion());
        }

        return mapaNotas.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().mapToInt(i -> i).average().orElse(0),
                        (a, b) -> a,
                        LinkedHashMap::new
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    // Gráfico 3: Cantidad de asistencias por día (últimos 7 días)
    public Map<String, Long> obtenerAsistenciasUltimos7Dias() {
        Map<String, Long> asistenciasPorDia = new LinkedHashMap<>();

        LocalDate hoy = LocalDate.now();
        LocalDate hace7Dias = hoy.minusDays(6);

        List<Asistencia> asistencias = asistenciaRepository.findAll().stream()
                .filter(a -> !a.getFecha().isBefore(hace7Dias))
                .collect(Collectors.toList());

        for (int i = 0; i <= 6; i++) {
            LocalDate fecha = hace7Dias.plusDays(i);
            String fechaStr = fecha.toString();
            asistenciasPorDia.put(fechaStr, 0L);
        }

        asistencias.stream()
                .collect(Collectors.groupingBy(a -> a.getFecha().toString(), Collectors.counting()))
                .forEach(asistenciasPorDia::put);

        return asistenciasPorDia;
    }
}
