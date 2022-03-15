package com.ceiba.hospedaje.comando;

import com.ceiba.Activo;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComandoHospedaje {
    private Long id;
    private String nombre;
    private int capacidadPersonas;
    private EstadoHospedaje estado; //TODO Validar el uso de un enum
    private Double valorNoche;
    private Activo activo;
    private Double valorRecargoFinSemana;

}
