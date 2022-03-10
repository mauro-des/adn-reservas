package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar reservas
     * @return lista de reservas
     */
    List<DtoReserva> listar();

    /**
     * Permite listar las reservas activas de un cliente
     * @param identificacionCliente
     * @return lista de reservas
     */
    List<DtoReserva> listarPorCliente(String identificacionCliente);
}
