package com.ceiba.hospedaje.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import org.jetbrains.annotations.NotNull;

public class ServicioActualizarHospedaje {

    private static final String EL_HOSPEDAJE_NO_EXISTE = "El hospedaje no existe";

    private final RepositorioHospedaje repositorioHospedaje;

    public ServicioActualizarHospedaje(RepositorioHospedaje repositorioUsuario) {
        this.repositorioHospedaje = repositorioUsuario;
    }

    public void ejecutar(Hospedaje hospedaje) {
        validarExistenciaPrevia(hospedaje);
        this.repositorioHospedaje.actualizar(hospedaje);
    }

    private void validarExistenciaPrevia(@NotNull Hospedaje hospedaje) {
        boolean existe = this.repositorioHospedaje.existePorId(hospedaje.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_HOSPEDAJE_NO_EXISTE);
        }
    }
}
