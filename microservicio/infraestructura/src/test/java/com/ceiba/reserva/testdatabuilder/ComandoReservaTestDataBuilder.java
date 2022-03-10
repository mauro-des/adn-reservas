package com.ceiba.reserva.testdatabuilder;

import com.ceiba.Activo;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.EstadoReserva;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Long idHospedaje;
    private String nombreCliente;
    private String identificacionCliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadPersonas;
    private long cantidadDias;
    private Activo activo;
    private EstadoReserva estado;
    private Double valorReserva;

    public ComandoReservaTestDataBuilder() {
        idHospedaje = 5444L;
        nombreCliente = "Cliente Reserva";
        identificacionCliente = "123456789";
        cantidadPersonas = 2;
        fechaInicio = LocalDate.now();
        estado = EstadoReserva.PEN;
        fechaFin = LocalDate.now().plusDays(1);
        valorReserva = 400000.0;
    }

    public ComandoReservaTestDataBuilder conNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
        return this;
    }


    public ComandoReservaTestDataBuilder conEstado(EstadoReserva estado){
        this.estado = estado;
        return  this;
    }

    public ComandoReservaTestDataBuilder conCantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas = cantidadPersonas;
        return this;
    }

    public ComandoReservaTestDataBuilder conValorReserva(Double valorReserva){
        this.valorReserva = valorReserva;
        return this;
    }


    public ComandoReservaTestDataBuilder conActivo(Activo activo){
        this.activo = activo;
        return this;
    }


    public ComandoReserva build() {
        return new ComandoReserva(id, idHospedaje,nombreCliente, identificacionCliente, fechaInicio, fechaFin, cantidadPersonas, cantidadDias, activo, estado, valorReserva);
    }
}
