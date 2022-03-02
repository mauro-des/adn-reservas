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
    estado varchar(3) not null,
    fecha_creacion datetime not null,
    primary key(id)
);