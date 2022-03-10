package com.ceiba.hospedaje.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoHospedaje {
    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private String estado;
    private LocalDateTime fechaCreacion;
    private Double valorNoche;
    private String activo;
    private Double valorRecargoFinSemana;
}
