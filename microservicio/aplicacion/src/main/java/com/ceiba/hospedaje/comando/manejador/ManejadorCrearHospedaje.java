package com.ceiba.hospedaje.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.comando.fabrica.FabricaHospedaje;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.servicio.ServicioCrearHospedaje;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearHospedaje implements ManejadorComandoRespuesta<ComandoHospedaje, ComandoRespuesta<Long>> {

    private final FabricaHospedaje fabricaHospedaje;
    private final ServicioCrearHospedaje servicioCrearHospedaje;

    public ManejadorCrearHospedaje(FabricaHospedaje fabricaHospedaje, ServicioCrearHospedaje servicioCrearHospedaje) {
        this.fabricaHospedaje = fabricaHospedaje;
        this.servicioCrearHospedaje = servicioCrearHospedaje;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoHospedaje comandoHospedaje) {
        Hospedaje hospedaje = this.fabricaHospedaje.crear(comandoHospedaje);
        return new ComandoRespuesta<>(this.servicioCrearHospedaje.ejecutar(hospedaje));
    }
}
