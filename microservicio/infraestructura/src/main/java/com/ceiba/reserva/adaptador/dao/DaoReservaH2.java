package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoReservaH2 implements DaoReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "reserva", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace= "reserva", value="consultarPorCliente")
    private static String sqlConsultarPorCliente;

    public DaoReservaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoReserva> listar() {
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> listarPorCliente(String identificacionCliente) {
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultarPorCliente, new MapeoReserva());
    }

}
