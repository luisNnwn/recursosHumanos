package com.api.dto;

public class NominaResponse {
    private Long empleadoId;
    private String nombre;
    private Double sueldoBase;
    private Double bonos;
    private Double descuentos;
    private Double sueldoNeto;

    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(Double sueldoBase) { this.sueldoBase = sueldoBase; }

    public Double getBonos() { return bonos; }
    public void setBonos(Double bonos) { this.bonos = bonos; }

    public Double getDescuentos() { return descuentos; }
    public void setDescuentos(Double descuentos) { this.descuentos = descuentos; }

    public Double getSueldoNeto() { return sueldoNeto; }
    public void setSueldoNeto(Double sueldoNeto) { this.sueldoNeto = sueldoNeto; }
}
