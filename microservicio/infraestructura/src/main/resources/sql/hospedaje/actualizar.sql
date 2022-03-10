update hospedaje
set
    nombre = :nombre,
    capacidad_personas = :capacidadPersonas,
    estado = :estado,
    valor_noche = :valorNoche,
    activo = :activo
where id = :id