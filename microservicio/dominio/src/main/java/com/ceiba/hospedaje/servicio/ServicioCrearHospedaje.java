package com.ceiba.hospedaje.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;


public class ServicioCrearHospedaje {

    private static final String EL_HOSPEDAJE_YA_EXISTE_EN_EL_SISTEMA = "El hospedaje ya existe en el sistema";

    private final RepositorioHospedaje repositorioHospedaje;

    public ServicioCrearHospedaje(RepositorioHospedaje repositorioHospedaje) {
        this.repositorioHospedaje = repositorioHospedaje;
    }

    public Long ejecutar(Hospedaje hospedaje) {
        validarExistenciaPrevia(hospedaje);
        return this.repositorioHospedaje.crear(hospedaje);
    }

    private void validarExistenciaPrevia(Hospedaje hospedaje) {
        boolean existe = this.repositorioHospedaje.existe(hospedaje.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_HOSPEDAJE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
