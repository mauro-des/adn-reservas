package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.jetbrains.annotations.NotNull;

public class ServicioActualizarReserva {

    private static final String LA_RESERVA_NO_EXISTE = "La reserva no existe";

    private final RepositorioReserva repositorioReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        repositorioReserva.actualizar(reserva);
    }

    private void validarExistenciaPrevia(@NotNull Reserva reserva) {
        boolean existe = repositorioReserva.existe(reserva.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_NO_EXISTE);
        }
    }
}
