create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table hospedaje(
    id int(11) not null auto_increment,
    nombre varchar(20) not null,
    capacidad_personas int(2) not null,
    activo varchar(2) not null,
    estado varchar(4) not null,
    fecha_creacion datetime not null,
    valor_noche double not null,
    valor_recargo_fin_semana double not null,
    primary key(id)
);

create table reserva(
    id int(11) not null auto_increment,
    id_hospedaje int not null,
    nombre_cliente varchar(200) not null,
    identificacion_cliente varchar(15) not null,
    cantidad_personas int not null,
    fecha_inicio datetime not null,
    fecha_fin datetime not null,
    cantidad_dias int not null,
    fecha_creacion datetime not null,
    valor_reserva double not null,
    activo varchar(2) not null,
    estado varchar(3) not null,
    primary key(id)
)