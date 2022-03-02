package com.ceiba.hospedaje.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHospedaje {
    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private String estado; //TODO Validar el uso de un enum
}
