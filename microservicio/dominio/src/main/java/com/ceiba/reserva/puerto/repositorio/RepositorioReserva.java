package com.ceiba.reserva.puerto.repositorio;


import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {
    /**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar una reserva
     * @param reserva
     */
    void actualizar(Reserva reserva);

    /**
     * Permite eliminar una reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una reserva por su id
     * @return si existe o no
     */
    boolean existe(Long id);

}
