package com.ceiba.hospedajes.adaptador.repositorio;

import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHospedajeH2 implements RepositorioHospedaje {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "hospedaje", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "hospedaje", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace= "hospedaje", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace= "hospedaje", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace= "hospedaje", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioHospedajeH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Hospedaje hospedaje) {
        return this.customNamedParameterJdbcTemplate.crear(hospedaje, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Hospedaje hospedaje) {
        this.customNamedParameterJdbcTemplate.actualizar(hospedaje, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
