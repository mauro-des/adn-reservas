package com.ceiba.hospedaje.servicio.testdatabuilder;

import com.ceiba.hospedaje.modelo.entidad.Hospedaje;

import java.time.LocalDateTime;

public class HospedajeTestDataBuilder {

    private Long id;
    private String nombre;
    private int cantidadPersonas;
    private String estado;
    private LocalDateTime fecha;

    public HospedajeTestDataBuilder() {
        id = 1L;
        nombre = "HospedajePrueba";
        cantidadPersonas = 0;
        estado = "ACT";
        fecha = LocalDateTime.now();
    }

    public HospedajeTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public HospedajeTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public HospedajeTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return  this;
    }

    public HospedajeTestDataBuilder conCantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas = cantidadPersonas;
        return this;
    }

    public HospedajeTestDataBuilder conFechaCreacion(LocalDateTime fecha){
        this.fecha = fecha;
        return  this;
    }

    public Hospedaje build() {
        return new Hospedaje(id,nombre, cantidadPersonas, estado, fecha);
    }
}
