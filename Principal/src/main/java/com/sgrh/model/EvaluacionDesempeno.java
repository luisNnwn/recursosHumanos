package com.sgrh.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evaluacion_desempeno")
public class EvaluacionDesempeno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    private LocalDate fecha;
    private String evaluador;
    private Integer puntuacion;
    private String observaciones;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getEvaluador() {
        return evaluador;
    }
    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }
    public Integer getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Getters y Setters
}
