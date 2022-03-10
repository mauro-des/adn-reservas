package com.ceiba.hospedaje.modelo.entidad;


import com.ceiba.Activo;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Hospedaje {
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_LA_CAPACIDAD = "Se debe ingresar la capacidad del hospedaje";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_HABITACION = "Se debe ingresar el nombre del hospedaje";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";
    private static final String LA_CAPACIDAD_DEBE_SER_MAYOR_A_CERO = "La capacidad debe ser mayor a cero";
    private static final String EL_VALOR_DE_LA_NOCHE_DEBE_SER_MAYOR_A_CERO = "El valor de la noche debe ser mayor a cero";
    private static final String EL_VALOR_DEL_RECARGO_DEBE_SER_MAYOR_A_CERO = "El valor del recargo debe ser mayor a cero";
    private static final String SE_DEBE_INDICAR_SI_ESTA_ACTIVO = "Se debe indicar si el hospedaje está activo";



    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private String estado; //TODO Validar el uso de un enum
    private String activo = "SI";
    private LocalDateTime fechaCreacion;
    private Double valorNoche;
    private Double valorRecargoFinSemana;

    public Hospedaje(Long id, String nombre, int capacidadPersonas, EstadoHospedaje estado, LocalDateTime fechaCreacion, Double valorNoche, Activo activo, Double valorRecargoFinSemana) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_HABITACION);
        validarObligatorio(capacidadPersonas, SE_DEBE_INGRESAR_LA_CAPACIDAD);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO);
        validarObligatorio(activo, SE_DEBE_INDICAR_SI_ESTA_ACTIVO);
        validarPositivo(Double.valueOf(capacidadPersonas), LA_CAPACIDAD_DEBE_SER_MAYOR_A_CERO);
        validarPositivo(valorNoche, EL_VALOR_DE_LA_NOCHE_DEBE_SER_MAYOR_A_CERO);
        validarPositivo(valorRecargoFinSemana, EL_VALOR_DEL_RECARGO_DEBE_SER_MAYOR_A_CERO);

        this.id = id;
        this.nombre = nombre.toUpperCase();
        this.capacidadPersonas = capacidadPersonas;
        this.fechaCreacion = fechaCreacion;

        this.valorNoche = valorNoche;
        this.estado = estado.name();
        this.activo = activo.name();
        this.valorRecargoFinSemana = valorRecargoFinSemana;
    }

    public EstadoHospedaje getEstado() {
        return EstadoHospedaje.valueOf(this.estado);
    }

    public void setEstado(EstadoHospedaje estado) {
        this.estado = estado.name();
    }

    public Activo getActivo() {
        return Activo.valueOf(this.activo);
    }

    public void setActivo(final Activo activo) {
        this.activo = activo.name();
    }
}
