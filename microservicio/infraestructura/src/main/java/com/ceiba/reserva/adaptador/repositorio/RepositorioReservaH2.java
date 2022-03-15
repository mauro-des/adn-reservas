package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaH2 implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "reserva", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "reserva", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace= "reserva", value="eliminar")
    private static String sqlEliminar;


    @SqlStatement(namespace= "reserva", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace= "reserva", value="existePorHospedaje")
    private static String sqlExistePorHospedaje;


    @SqlStatement(namespace= "reserva", value="pagar")
    private static String sqlPagar;

    public RepositorioReservaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    @Override
    public void pagar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlPagar);
    }

    @Override
    public boolean existePorHospedaje(Long idHospedaje) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idHospedaje", idHospedaje);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorHospedaje,paramSource, Boolean.class);
    }
}
