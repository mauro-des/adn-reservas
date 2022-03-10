package com.ceiba.hospedaje.comando;

import com.ceiba.Activo;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
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
    private EstadoHospedaje estado; //TODO Validar el uso de un enum
    private Double valorNoche;
    private Activo activo;
    private Double valorRecargoFinSemana;

}
