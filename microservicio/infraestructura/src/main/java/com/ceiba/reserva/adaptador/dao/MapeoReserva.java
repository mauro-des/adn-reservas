package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idHospedaje = resultSet.getLong("id_hospedaje");
        String nombreCliente = resultSet.getString("nombre_cliente");
        String identificacionCliente = resultSet.getString("identificacion_cliente");
        int cantidadPersonas = resultSet.getInt("cantidad_personas");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet, "fecha_fin");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
        Double valorReserva = resultSet.getDouble("valor_reserva");
        String activo = resultSet.getString("activo");
        String estado = resultSet.getString("estado");
        int cantidadDias  = resultSet.getInt("cantidad_dias");

        return new DtoReserva(id, idHospedaje, nombreCliente, identificacionCliente, fechaInicio,
                fechaFin, fechaCreacion,cantidadPersonas,
                cantidadDias,activo,estado, valorReserva);
    }

}
