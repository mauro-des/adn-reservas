package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.Activo;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
import com.ceiba.reserva.modelo.entidad.EstadoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private Long idHospedaje;
    private String nombreCliente;
    private String identificacionCliente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;
    private int cantidadPersonas;
    private Activo activo = Activo.SI;
    private EstadoReserva estado = EstadoReserva.PEN;
    private Double valorReserva;

    public ReservaTestDataBuilder() {
        idHospedaje = 1L;
        nombreCliente = "Cliente Prueba";
        identificacionCliente = "123456";
        fechaInicio = LocalDateTime.now();
        fechaFin = LocalDateTime.now().plusDays(1);
        fechaCreacion = LocalDateTime.now();
        cantidadPersonas = 1;
        valorReserva = 140000.0;
    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public ReservaTestDataBuilder conIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
        return this;
    }

    public ReservaTestDataBuilder conEstado(EstadoReserva estado){
        this.estado = estado;
        return  this;
    }

    public ReservaTestDataBuilder conActivo(Activo activo){
        this.activo = activo;
        return  this;
    }

    public ReservaTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
        return  this;
    }

    public ReservaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio){
        this.fechaInicio = fechaInicio;
        return  this;
    }

    public ReservaTestDataBuilder conFechaFin(LocalDateTime fechaFin){
        this.fechaFin = fechaFin;
        return  this;
    }

    public ReservaTestDataBuilder conValorReserva(Double valorReserva){
        this.valorReserva = valorReserva;
        return  this;
    }

    public ReservaTestDataBuilder conCantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas = cantidadPersonas;
        return  this;
    }

    public ReservaTestDataBuilder conIdHospedaje(Long idHospedaje){
        this.idHospedaje = idHospedaje;
        return  this;
    }



    public Reserva build() {
        return new Reserva(id, idHospedaje, nombreCliente, identificacionCliente, cantidadPersonas, fechaInicio, fechaFin,
                fechaCreacion, activo, estado, valorReserva);
    }
}
