package com.ceiba.reserva.modelo.entidad;


import com.ceiba.Activo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Reserva {
    private static final String SE_DEBE_INGRESAR_UN_HOSPEDAJE = "Se debe ingresar un hospedaje";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PERSONAS = "Se debe ingresar la cantidad de personas";
    private static final String LA_CANTIDAD_DE_PERSONAS_DEBE_SER_MAYOR_A_CERO = "La cantidad de personas debe ser mayor a cero";
    private static final String SE_DEBEN_INGRESAR_LOS_DATOS_DEL_CLIENTE = "Se deben ingresar los datos del cliente";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";
    private static final String LA_CAPACIDAD_DEBE_SER_MAYOR_A_CERO = "La capacidad debe ser mayor a cero";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIAL = "Se debe ingresar la fecha inicial";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FINAL = "Se debe ingresar la fecha final";
    private static final String LA_FECHA_INICIAL_DEBE_SER_MAYOR_A_LA_FINAL = "La fecha inicial debe ser menor a la fecha final";
    private static final String LA_FECHA_INICIAL_DEBE_SER_MAYOR_IGUAL_A_LA_FECHA_ACTUAL = "La fecha inicial debe ser mayor o igual a la fecha actual";


    private Long id;
    private Long idHospedaje;
    private String nombreCliente;
    private String identificacionCliente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;
    private int cantidadPersonas;
    private long cantidadDias;
    private String activo = "SI";
    private String estado = "PEN";
    private Double valorReserva;

    public Reserva(Long id, Long idHospedaje, String nombreCliente, String identificacionCliente, int cantidadPersonas,
                   LocalDateTime fechaInicio, LocalDateTime fechaFin, LocalDateTime fechaCreacion,
                   Activo activo, EstadoReserva estado, Double valorReserva) {

        validarObligatorio(idHospedaje, SE_DEBE_INGRESAR_UN_HOSPEDAJE);
        validarObligatorio(cantidadPersonas, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PERSONAS);
        validarPositivo(Double.valueOf(cantidadPersonas), LA_CANTIDAD_DE_PERSONAS_DEBE_SER_MAYOR_A_CERO);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIAL);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FINAL);
        validarObligatorio(nombreCliente, SE_DEBEN_INGRESAR_LOS_DATOS_DEL_CLIENTE);
        validarObligatorio(identificacionCliente, SE_DEBEN_INGRESAR_LOS_DATOS_DEL_CLIENTE);
        validarMenor(fechaInicio, fechaFin, LA_FECHA_INICIAL_DEBE_SER_MAYOR_A_LA_FINAL);
        validarMenor(LocalDateTime.now(), fechaInicio, LA_FECHA_INICIAL_DEBE_SER_MAYOR_IGUAL_A_LA_FECHA_ACTUAL);

        this.id = id;
        this.idHospedaje = idHospedaje;
        this.nombreCliente = nombreCliente;
        this.identificacionCliente = identificacionCliente;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        if(activo != null){
            this.activo = activo.name();
        }

        if(estado != null) {
            this.estado = estado.name();
        }

        this.fechaCreacion = fechaCreacion;
        this.valorReserva = valorReserva;
        cantidadDias = getNumeroDiasReserva();
    }

    private long getNumeroDiasReserva(){
        return fechaInicio.until(fechaFin, ChronoUnit.DAYS);
    }

    public void setValorReservar(Double valorReserva) {
        this.valorReserva = valorReserva;
    }

    public Activo getActivo() {
        return Activo.valueOf(this.activo);
    }

    public void setActivo(final Activo activo) {
        this.activo = activo.name();
    }

    public EstadoReserva getEstado() {
        return EstadoReserva.valueOf(this.estado);
    }

    public void setEstado(final EstadoReserva estado) {
        this.estado = estado.name();
    }
}
