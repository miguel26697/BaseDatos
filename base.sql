drop database if exists conjunto;
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
id_parqueadero varchar(6) primary key,
bahia varchar(30)  ,
pp varchar(2),
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
foreign key (id_parqueadero) references parqueadero(id_parqueadero)
);

create table recibo(
id_recibo varchar(10) primary key,
fecha_exp varchar(15),
fecha_lim varchar(10),
valor int,
id_propietarios varchar(10),
foreign key(id_propietarios) references propietarios(id_propietarios)
);

create table pago(
pagor varchar(3),
id_recibo varchar(10),
foreign key (id_recibo)  references recibo(id_recibo)
);
create table turnos(
id_turno varchar(10) primary key,
pago_hora integer,
tipo  varchar(30),
dias varchar(30),
horario_entrada varchar(10),
horario_salida varchar(10)
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
fecha date,
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


insert into propietarios values ("1234","jairo","caro","350750");
insert into usuario values("jairo","1234","admin");
insert into usuario values("miguel","1234","celador");
insert into usuario values("johan","1234","Contra");
insert into apto values("T1A2b","normal","1234");

insert into apto values("T1A101","Normal","1234");
insert into apto values("T1A102","Duplex","1234");
insert into apto values("T1A103","Normal","1234");
insert into apto values("T1A201","Duplex","1234");
insert into apto values("T1A202","Normal","1234");
insert into apto values("T1A203","Normal","1234");

select * from residentes;
select * from turnos;
insert into residentes value("1","miguel","rippe","350750","T1A2b");


insert into tipoemp values("1","celador");
insert into turnos values("1",5000,"nocturno","7","24:00","8:00");
insert into tipoemp values("2","aseador");
insert into turnos values("2",5000,"nocturno","7","8:00","17:00");

insert into recibo values("01","12/01/2020","12/02/2020",250000,"1234");


insert into pago values("si","01");

select * from turnos;
insert into zonas values("1","Libres");
insert into parqueadero values("1","2","si","1");
insert into carro values("1","negro","nissam","2010","1","1");

select*from residentes;

insert into zonas values("3","recreacion");

create table auditoria_visitantes(
id int not null auto_increment primary key,
nombre varchar(30),
placa varchar(30),
id_apto varchar (30),
usuario varchar(20),
fecha_cambio datetime
);

select * from auditoria_visitantes;
create trigger auditoria1
after insert on visitante
for each row
insert into auditoria_visitantes (id, nombre,placa,id_apto,usuario, fecha_cambio)
values (new.id_visitante, new.nombre,new.placa,new.id_apto,current_user(), now());

