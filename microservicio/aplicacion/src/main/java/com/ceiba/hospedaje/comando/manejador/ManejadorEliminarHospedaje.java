package com.ceiba.hospedaje.comando.manejador;

import com.ceiba.hospedaje.servicio.ServicioEliminarHospedaje;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarHospedaje implements ManejadorComando<Long> {

    private final ServicioEliminarHospedaje servicioEliminarHospedaje;

    public ManejadorEliminarHospedaje(ServicioEliminarHospedaje servicioEliminarHospedaje) {
        this.servicioEliminarHospedaje = servicioEliminarHospedaje;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarHospedaje.ejecutar(idUsuario);
    }
}
