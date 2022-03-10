select
    id,
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
from
    reserva
where
    activo = 'SI'