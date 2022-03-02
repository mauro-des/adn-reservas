package com.ceiba.hospedajes.adaptador.dao;

import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import com.ceiba.hospedaje.puerto.dao.DaoHospedaje;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoHospedajeH2 implements DaoHospedaje {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "hospedaje", value="listar")
    private static String sqlListar;

    public DaoHospedajeH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoHospedaje> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoHospedaje());
    }
}
