insert into hospedaje (
    nombre,
    capacidad_personas,
    estado,
    activo,
    valor_noche,
    valor_recargo_fin_semana,
    fecha_creacion
) values (
    :nombre,
    :capacidadPersonas,
    :estado,
    :activo,
    :valorNoche,
    :valorRecargoFinSemana,
    :fechaCreacion
)