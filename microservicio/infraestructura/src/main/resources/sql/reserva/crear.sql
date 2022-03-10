insert into reserva (
    id_hospedaje,
    nombre_cliente,
    identificacion_cliente,
    cantidad_personas,
    fecha_inicio,
    fecha_fin,
    cantidad_dias,
    fecha_creacion,
    valor_reserva,
    activo,
    estado
) values (
    :idHospedaje,
    :nombreCliente,
    :identificacionCliente,
    :cantidadPersonas,
    :fechaInicio,
    :fechaFin,
    :cantidadDias,
    :fechaCreacion,
    :valorReserva,
    :activo,
    :estado
);