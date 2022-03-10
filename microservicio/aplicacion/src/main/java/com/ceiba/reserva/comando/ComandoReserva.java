package com.ceiba.reserva.comando;

import com.ceiba.Activo;
import com.ceiba.reserva.modelo.entidad.EstadoReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {
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
}
