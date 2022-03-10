package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private Long idHospedaje;
    private String nombreCliente;
    private String identificacionCliente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaCreacion;
    private int cantidadPersonas;
    private long cantidadDias;
    private String activo;
    private String estado;
    private Double valor;
}
