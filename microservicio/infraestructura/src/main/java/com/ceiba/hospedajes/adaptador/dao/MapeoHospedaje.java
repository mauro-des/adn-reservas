package com.ceiba.hospedajes.adaptador.dao;

import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoHospedaje implements RowMapper<DtoHospedaje>, MapperResult {

    @Override
    public DtoHospedaje mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String estado = resultSet.getString("estado");
        int capacidad = resultSet.getInt("capacidad_personas");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoHospedaje(id, nombre, capacidad, estado, fecha);
    }

}
