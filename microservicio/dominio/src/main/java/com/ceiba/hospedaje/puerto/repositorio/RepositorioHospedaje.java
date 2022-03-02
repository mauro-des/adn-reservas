package com.ceiba.hospedaje.puerto.repositorio;

import com.ceiba.hospedaje.modelo.entidad.Hospedaje;

public interface RepositorioHospedaje {
    /**
     * Permite crear un hospedaje
     * @param hospedaje
     * @return el id generado
     */
    Long crear(Hospedaje hospedaje);

    /**
     * Permite actualizar un hospedaje
     * @param hospedaje
     */
    void actualizar(Hospedaje hospedaje);

    /**
     * Permite eliminar un hospedaje
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un hospedaje con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un hospedaje por su id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
