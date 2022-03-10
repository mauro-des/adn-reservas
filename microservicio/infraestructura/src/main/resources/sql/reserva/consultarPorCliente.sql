select
    id,
    id_hospedaje,
    nombre_cliente,
    identificacion_cliente,
    cantidad_personas,
    fecha_inicio,
    fecha_fin,
    fecha_creacion,
    valor_reserva,
    activo,
    estado
from
    reserva
where
    identificacion_cliente = :identificacionCliente