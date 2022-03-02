package com.ceiba.hospedaje.consulta;

import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import com.ceiba.hospedaje.puerto.dao.DaoHospedaje;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarHospedajes {

    private final DaoHospedaje daoHospedaje;

    public ManejadorListarHospedajes(DaoHospedaje daoHospedaje){
        this.daoHospedaje = daoHospedaje;
    }

    public List<DtoHospedaje> ejecutar(){ return this.daoHospedaje.listar(); }
}
