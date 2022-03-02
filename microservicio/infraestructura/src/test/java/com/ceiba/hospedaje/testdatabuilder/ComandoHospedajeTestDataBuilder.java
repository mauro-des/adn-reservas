package com.ceiba.hospedaje.testdatabuilder;

import com.ceiba.hospedaje.comando.ComandoHospedaje;
//import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoHospedajeTestDataBuilder {

    private Long id;
    private String nombre;
    private int cantidadPersonas;
    private String estado;
    private LocalDateTime fecha;

    public ComandoHospedajeTestDataBuilder() {
        nombre = UUID.randomUUID().toString().substring(0,19);
        cantidadPersonas = 1;
        estado = "ACT";
        fecha = LocalDateTime.now();
    }

    public ComandoHospedajeTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoHospedajeTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return  this;
    }

    public ComandoHospedajeTestDataBuilder conCantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas = cantidadPersonas;
        return this;
    }

    public ComandoHospedaje build() {
        return new ComandoHospedaje(id, nombre, cantidadPersonas, estado);
    }
}
