package com.ceiba.reserva.comando.manejador;

import com.ceiba.Activo;
import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.comando.fabrica.FabricaHospedaje;
import com.ceiba.hospedaje.consulta.ManejadorListarHospedajes;
import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.servicio.ServicioActualizarHospedaje;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioPagarReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPagarReserva implements ManejadorComando<ComandoReserva> {

    private final FabricaReserva fabricaReserva;
    private final ServicioPagarReserva servicioPagarReserva;
    private final ServicioActualizarHospedaje servicioActualizarHospedaje;
    private final FabricaHospedaje fabricaHospedaje;
    private final ManejadorListarHospedajes manejadorListarHospedajes;

    public ManejadorPagarReserva(FabricaReserva fabricaReserva,
                                 FabricaHospedaje fabricaHospedaje,
                                 ManejadorListarHospedajes manejadorListarHospedajes,
                                 ServicioPagarReserva servicioPagarReserva,
                                 ServicioActualizarHospedaje servicioActualizarHospedaje) {
        this.fabricaReserva = fabricaReserva;
        this.servicioPagarReserva = servicioPagarReserva;
        this.servicioActualizarHospedaje = servicioActualizarHospedaje;
        this.fabricaHospedaje = fabricaHospedaje;
        this.manejadorListarHospedajes = manejadorListarHospedajes;
    }

    public void ejecutar(ComandoReserva comandoReserva) {
        Reserva reserva = fabricaReserva.crear(comandoReserva);
        servicioPagarReserva.ejecutar(reserva);

        DtoHospedaje dtoHospedaje = manejadorListarHospedajes.ejecutar().get(0);
        ComandoHospedaje comandoHospedaje = ComandoHospedaje.builder().
                id(dtoHospedaje.getId()).
                capacidadPersonas(dtoHospedaje.getCapacidadPersonas())
                .nombre(dtoHospedaje.getNombre())
                .valorNoche(dtoHospedaje.getValorNoche())
                .valorRecargoFinSemana(dtoHospedaje.getValorRecargoFinSemana())
                .activo(Activo.valueOf(dtoHospedaje.getActivo()))
                .estado(EstadoHospedaje.valueOf(dtoHospedaje.getEstado()))
                .build();
        Hospedaje hospedaje = fabricaHospedaje.crear(comandoHospedaje);

        hospedaje.setEstado(EstadoHospedaje.DIS);

        servicioActualizarHospedaje.ejecutar(hospedaje);
    }
}
