package com.ceiba.hospedaje.servicio.testdatabuilder;

import com.ceiba.Activo;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;

import java.time.LocalDateTime;

public class HospedajeTestDataBuilder {

    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private EstadoHospedaje estado;
    private LocalDateTime fecha;
    private Double valorNoche;
    private Double valorRecargoFinSemana;
    private Activo activo;

    public HospedajeTestDataBuilder() {
        id = 1L;
        nombre = "HospedajePrueba";
        capacidadPersonas = 1;
        estado = EstadoHospedaje.DIS;
        fecha = LocalDateTime.now();
        valorNoche = 10000.0;
        activo = Activo.SI;
        valorRecargoFinSemana = 1000.0;
    }

    public HospedajeTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public HospedajeTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public HospedajeTestDataBuilder conEstado(EstadoHospedaje estado){
        this.estado = estado;
        return  this;
    }

    public HospedajeTestDataBuilder conCapacidadPersonas(int capacidadPersonas){
        this.capacidadPersonas = capacidadPersonas;
        return this;
    }

    public HospedajeTestDataBuilder conFechaCreacion(LocalDateTime fecha){
        this.fecha = fecha;
        return  this;
    }

    public HospedajeTestDataBuilder conValorNoche(Double valorNoche){
        this.valorNoche = valorNoche;
        return  this;
    }

    public HospedajeTestDataBuilder conValorvalorRecargoFinSemana(Double valorRecargoFinSemana){
        this.valorRecargoFinSemana = valorRecargoFinSemana;
        return  this;
    }

    public HospedajeTestDataBuilder conActivo(Activo activo){
        this.activo = activo;
        return  this;
    }


    public Hospedaje build() {
        return new Hospedaje(id,nombre, capacidadPersonas, estado, fecha, valorNoche,activo, valorRecargoFinSemana);
    }
}
