select
    id,
    nombre,
    capacidad_personas,
    estado,
    valor_noche,
    valor_recargo_fin_semana,
    fecha_creacion,
    activo
from
    hospedaje
where
    activo = 'SI'
and
    estado = "DIS"