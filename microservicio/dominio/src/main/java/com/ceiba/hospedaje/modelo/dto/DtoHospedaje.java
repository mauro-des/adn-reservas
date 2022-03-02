package com.ceiba.hospedaje.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class DtoHospedaje {
    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private String estado;
    private LocalDateTime fechaCreacion;
}
