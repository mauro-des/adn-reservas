package com.ceiba.hospedaje.comando.manejador;

import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.comando.fabrica.FabricaHospedaje;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.servicio.ServicioActualizarHospedaje;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarHospedaje implements ManejadorComando<ComandoHospedaje> {

    private final FabricaHospedaje fabricaHospedaje;
    private final ServicioActualizarHospedaje servicioActualizarHospedaje;

    public ManejadorActualizarHospedaje(FabricaHospedaje fabricaHospedaje, ServicioActualizarHospedaje servicioActualizarHospedaje) {
        this.fabricaHospedaje = fabricaHospedaje;
        this.servicioActualizarHospedaje = servicioActualizarHospedaje;
    }

    public void ejecutar(ComandoHospedaje comandoHospedaje) {
        Hospedaje hospedaje = this.fabricaHospedaje.crear(comandoHospedaje);
        this.servicioActualizarHospedaje.ejecutar(hospedaje);
    }
}
