create database conjunto;
use conjunto;

create table propietarios(
id_propietarios varchar(10) primary key,
nombres varchar(30),
apellidos varchar(30),
telefono varchar(30)
);
create table apto(
id_apto varchar(30) primary key,
tipo varchar(30),
id_propietario varchar(10),
foreign key (id_propietario)references propietarios(id_propietarios)
);
create table residentes(
id_residente varchar(30) primary key,
nombre varchar(30),
apellidos varchar(30),
telefono varchar(30),
id_apto varchar(30),
foreign key (id_apto) references apto(id_apto)
);
create table parqueadero(
bahia varchar(30)  primary key,
id_residente varchar(30),
foreign key (id_residente) references residentes(id_residente)
);
create table carro(
placa varchar(30) primary key,
color varchar(30),
marca varchar(30),
modelo varchar(10),
id_residente varchar(30),
id_parqueadero varchar(10),
foreign key (id_residente) references residentes(id_residente),
foreign key (id_parqueadero) references parqueadero(bahia)
);

create table deudores(
id_deuda varchar(10) primary key,
saldo integer not null,
fecha date,
id_propietario varchar(30),
foreign key (id_propietario)  references propietarios(id_propietarios)
);
create table pago(
id_pago varchar(10),
saldo integer not null,
fecha date,
id_propietario varchar(30),
foreign key (id_propietario)  references propietarios(id_propietarios)
);
create table turnos(
id_turno varchar(10) primary key,
pago_hora integer,
tipo  varchar(30),
dias varchar(30),
horario_entrada time,
horario_salida time
);
create table tipoemp(
id_tipo varchar(10) primary key,
tipo varchar(30)
);
create table trabajadores(
id_trabajdor varchar(30) primary key,
nombre varchar(30),
apellidos varchar(30),
direccion varchar(30),
fecha_inicio date,
telefono varchar(30),
eps varchar(30),
caja_com varchar(30),
id_tipo varchar(10),
id_turno varchar(10),
foreign key (id_tipo) references tipoemp(id_tipo),
foreign key (id_turno) references turnos(id_turno)
);
create table visitante(
id_visitante varchar(10) primary key,
nombre varchar(30),
apellidos varchar(30),
carro varchar(2),
placa varchar(30),
fecha datetime,
id_apto varchar(10),
foreign key (id_apto) references apto(id_apto)
);
create table usuario(
usuario varchar(30) primary key,
clave varchaR(30), 
tipo varchar(10)
);
create table zonas(
id_zona varchar(10)primary key ,
actividad varchar(30)
);
create table usozona(
id_uso varchar(10) primary key,
fecha datetime,
dia varchar(30),
id_residente varchar(30),
id_zona varchar(10),
foreign key (id_zona) references zonas(id_zona),
foreign key (id_residente) references residentes(id_residente));

create table cliente(
id varchar(10) primary key,
nombre varchar(30),
apellidos varchar(30),
email varchar(30),
direccion varchar(30),
telefono varchar(30)
);
select*from cliente;

insert into propietarios values ("1234","jairo","caro","350750");
insert into usuario values("jairo","1234","admin");
insert into usuario values("miguel","1234","celador");

hola




