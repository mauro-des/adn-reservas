package com.ceiba.hospedaje.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Locale;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Hospedaje {
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_LA_CAPACIDAD = "Se debe ingresar la capacidad del hospedaje";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_HABITACION = "Se debe ingresa el nombre o número de la habitación";


    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private String estado; //TODO Validar el uso de un enum
    private LocalDateTime fechaCreacion;

    public Hospedaje(Long id, String nombre, int capacidadPersonas,String estado, LocalDateTime fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_HABITACION);
        validarObligatorio(capacidadPersonas, SE_DEBE_INGRESAR_LA_CAPACIDAD);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre.toUpperCase();
        this.capacidadPersonas = capacidadPersonas;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

}
