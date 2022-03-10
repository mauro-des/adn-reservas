update reserva
set
    id_hospedaje = :idHospedaje,
    nombre_cliente = :nombreCliente,
    identificacion_cliente = :identificacionCliente,
    cantidad_personas = :cantidadPersonas,
    fecha_inicio =  :fechaInicio,
    fecha_fin = :fechaFin,
    cantidad_dias = :cantidadDias,
    fecha_creacion = :fechaCreacion,
    valor_reserva = :valorReserva,
    activo = :activo,
    estado = :estado
where id = :id