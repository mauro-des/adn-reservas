package com.ceiba.hospedaje.testdatabuilder;

import com.ceiba.Activo;
import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
//import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoHospedajeTestDataBuilder {

    private Long id;
    private String nombre;
    private int cantidadPersonas;
    private EstadoHospedaje estado;
    private LocalDateTime fecha;
    private Double valorNoche;
    private Double valorRecargoFinSemana;
    private Activo activo;

    public ComandoHospedajeTestDataBuilder() {
        nombre = UUID.randomUUID().toString().substring(0,19);
        cantidadPersonas = 4;
        estado = EstadoHospedaje.DISP;
        fecha = LocalDateTime.now();
        activo = Activo.SI;
        valorNoche = 40000.0;
        valorRecargoFinSemana = 5000.0;

    }

    public ComandoHospedajeTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoHospedajeTestDataBuilder conEstado(EstadoHospedaje estado){
        this.estado = estado;
        return  this;
    }

    public ComandoHospedajeTestDataBuilder conCantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas = cantidadPersonas;
        return this;
    }

    public ComandoHospedajeTestDataBuilder conValorNoche(Double valorNoche){
        this.valorNoche = valorNoche;
        return this;
    }


    public ComandoHospedajeTestDataBuilder conActivo(Activo activo){
        this.activo = activo;
        return this;
    }

    public ComandoHospedajeTestDataBuilder conValorRecargoFinSemana(Double valorRecargoFinSemana){
        this.valorRecargoFinSemana = valorRecargoFinSemana;
        return this;
    }

    public ComandoHospedaje build() {
        return new ComandoHospedaje(id, nombre, cantidadPersonas, estado, valorNoche, activo, valorRecargoFinSemana);
    }
}
