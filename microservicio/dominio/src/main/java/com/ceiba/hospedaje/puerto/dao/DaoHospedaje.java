package com.ceiba.hospedaje.puerto.dao;

import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;

import java.util.List;

public interface DaoHospedaje {

    /**
     * Permite listar hospedajes
     * @return lista de hospedajes
     */
    List<DtoHospedaje> listar();
}
