package com.ceiba.hospedaje.servicio;

import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;

public class ServicioEliminarHospedaje {

    private final RepositorioHospedaje repositorioHospedaje;

    public ServicioEliminarHospedaje(RepositorioHospedaje repositorioHospedaje) {
        this.repositorioHospedaje = repositorioHospedaje;
    }

    public void ejecutar(Long id) {
        this.repositorioHospedaje.eliminar(id);
    }
}
