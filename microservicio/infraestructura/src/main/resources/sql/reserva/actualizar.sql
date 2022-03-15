update reserva
set
    nombre_cliente = :nombreCliente,
    identificacion_cliente = :identificacionCliente,
    cantidad_personas = :cantidadPersonas,
    activo = :activo,
    estado = :estado
where id = :id