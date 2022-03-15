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
     * Permite validar si existe una reserva
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Actualiza el estado de una reserva a Pagado
     * @param reserva
     */
    void pagar(Reserva reserva);

    /**
     * Permite validar si existe una reserva para el hospedaje especificado
     * @return si existe o no
     */
    boolean existePorHospedaje(Long idHospedaje);
}
