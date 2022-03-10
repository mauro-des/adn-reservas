package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva) {
        return new Reserva(
                comandoReserva.getId(),
                comandoReserva.getIdHospedaje(),
                comandoReserva.getNombreCliente(),
                comandoReserva.getIdentificacionCliente(),
                comandoReserva.getCantidadPersonas(),
                comandoReserva.getFechaInicio().atStartOfDay(),
                comandoReserva.getFechaFin().atStartOfDay(),
                LocalDateTime.now(),
                comandoReserva.getActivo(),
                comandoReserva.getEstado(),
                comandoReserva.getValorReserva()
        );
    }
}
