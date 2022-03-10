package com.ceiba.hospedaje.puerto.dao;

import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;

import java.util.List;

public interface DaoHospedaje {

    /**
     * Permite listar hospedajes
     * @return lista de hospedajes
     */
    List<DtoHospedaje> listar();


    /**
     * Consulta un hospedaje por su id
     * @param idHospedaje
     * @return hospedaje
     */
    DtoHospedaje consultarPorId(Long idHospedaje);
}
