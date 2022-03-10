insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into hospedaje(
    nombre,
    capacidad_personas,
    activo,
    estado,
    fecha_creacion,
    valor_noche,
    valor_recargo_fin_semana
) values ('HOSPEDAJE 1',4,'SI','DIS', now(), 40000, 5000);

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
    1L,
    'Cliente Reserva',
    '123456',
    2,
    now(),
    to_date('14-03-2022', 'dd-mm-yyyy'),
    5,
    now(),
    400000,
    'SI',
    'PEN'
);