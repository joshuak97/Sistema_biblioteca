drop schema if exists basebiblioteca; 
create schema basebiblioteca;
use basebiblioteca;


create table Usuarios(
idUsuario int auto_increment not null primary key,
nombre varchar(50) not null,
Apaterno varchar(50) not null,
Amaterno varchar(50) not null,
usuario varchar(50) not null,
telefono varchar(20) null,
correo varchar(50) null,
perfil varchar(50) not null,
preguntaDeSeguridad varchar(100)not null,
respuestaPS varchar(100) not null

)ENGINE=InnoDB;

create table Carrera(

carrera_id int auto_increment not null primary key,
nombre_carrera varchar(200) not null,
plantel varchar(100) not null,
modalidad varchar(60) not null

)ENGINE=InnoDB;

create table Areas(

area_id int auto_increment not null primary key,
nombre_area varchar(100) not null


)ENGINE=InnoDB;

create table Tipo_Documento(

id_documento int auto_increment not null primary key,
tipo_documento varchar(100)
 

)ENGINE=InnoDB;

create table Alumno(

alumno_id varchar(10) not null primary key,
no_control varchar(8) not null,
nombre varchar(40) not null,
apellidoP varchar(40) not null,
apellidoM varchar(40) not null,
semestre int not null,
foto varchar(100) null,
email varchar(100) null,
telefono varchar(100) null,
carrera_id int not null,
FOREIGN KEY(carrera_id) REFERENCES Carrera(carrera_id) on delete cascade on update cascade
)ENGINE=InnoDB;

create table Libro(

libro_id int not null auto_increment primary key,
titulo varchar(500) not null,
autor varchar(100) not null,
isbn varchar(13) null,
editorial varchar(100) not null,
edicion varchar(100) null,
area_id int not null,
id_documento int not null,
FOREIGN KEY(area_id) REFERENCES Areas(area_id) on delete cascade on update cascade,
FOREIGN key(id_documento) REFERENCES Tipo_Documento(id_documento) on delete cascade on update cascade
)ENGINE=InnoDB;

create table Residencias_Tesis(

residencia_id int auto_increment primary key,
titulo varchar(500) not null,
alumno varchar(200) not null,
obs varchar(300) not null,
carrera_id varchar(50) not null,
formato_documento varchar(10) not null ,/* Digital o impreso*/
id_documento int not null,
FOREIGN KEY(id_documento) REFERENCES Tipo_Documento(id_documento) on delete cascade on update cascade
)ENGINE=InnoDB;




create table inventario(

id_unico varchar(15) not null primary key,
estado varchar(30) not null,
id_documento int not null,
FOREIGN key(id_documento) REFERENCES Tipo_Documento(id_documento) on update cascade on delete cascade


)ENGINE=InnoDB;

create table Prestamo(

folioP int not null primary key,
tipo_prestamo varchar(40) not null,
fecha_prestamo datetime not null,
estado varchar(30) not null,
alumno_id varchar(10) not null,
id_unico varchar(15) not null,
FOREIGN key(alumno_id) REFERENCES Alumno(alumno_id) on delete cascade on update cascade,
FOREIGN KEY(id_unico) REFERENCES  inventario(id_unico) on delete cascade on update cascade
)ENGINE=InnoDB;

create table Refrendo(

folioR int not null primary key,
fecha_refrendo datetime not null,
usuario_receptor varchar(50) not null,
id_unico varchar(15) not null,
alumno_id varchar(10) not null,
FOREIGN KEY(id_unico) REFERENCES Prestamo(id_unico) on delete cascade on update cascade,
FOREIGN KEY(alumno_id) REFERENCES Prestamo(alumno_id) on delete cascade on update cascade

)ENGINE=InnoDB;

create table Multas(

folioM int auto_increment not null primary key,
monto real not null,
folioP int not null,
alumno_id varchar(10) not null,
FOREIGN KEY(folioP) REFERENCES Prestamo(folioP) on delete cascade on update cascade,
FOREIGN KEY(alumno_id) REFERENCES Prestamo(alumno_id) on delete cascade on update cascade  

)ENGINE=InnoDB;


delimiter //

create procedure agregararea(in nombreArea varchar(100))
begin

insert into Areas(nombre_area)values(nombreArea);

end//





create procedure agregarcarrera(in nombrecarrera varchar(200),plantelc varchar(100),modalidadc varchar(60))
begin

insert into carrera(nombre_carrera,plantel,modalidad)values(nombre_carrera,plantelc,modalidadc);

end//

create procedure agregartipodocumento(in tipo_documento varchar(100))
begin

insert into Tipo_Documento(tipo_documento) values(tipo_documento);

end//


create procedure agregaralumno(in alumno_id varchar(200),no_control varchar(10),nombre varchar(40),apellidoP varchar(40),apellidoM varchar(40),semestre int,foto varchar(100))
begin

insert into Alumno values(alumno_id,no_control,nombre,apellidoP,apellidoM,semestre,foto);

end//

create procedure agregarlibro(in titulo varchar(500),autor varchar(100),isbn varchar(13),editorial varchar(100),edicion varchar(100))
begin

insert into Libro values(titulo,autor,isbn,editorial,edicion);

end//


create procedure agregarresidenciatesis(in titulo varchar(500),alumno varchar(200),obs varchar(300) ,carrera_id int)
begin

insert into Residencias_Tesis values(titulo,alumno,obs,carrera_id);

end//

create procedure agregarinventario(in id_unico varchar(10),estado varchar(30),id_documento int)
begin

insert into inventario values(id_unico,estado,id_documento);

end//

create procedure agregarprestamo(in folioP int,tipo_prestamo varchar(40),fecha_prestamo datetime,estado varchar(30),alumno_id varchar(10),id_unico varchar(15))
begin

insert into Prestamo values(folioP,tipo_prestamo,fecha_prestamo,estado,alumno_id,id_unico);

end//

create procedure agregarrefrendo(in folioR int,fecha_refrendo datetime,usuario_receptor varchar(50),id_unico varchar(15),alumno_id varchar(10))
begin

insert into Refrendo values(folioR,fecha_refrendo,usuario_receptor,id_unico,alumno_id);

end//

create procedure agregarmulta(in folioM int,monto real,id_unico varchar(15),alumno_id varchar(10)) 
begin

insert into Multas values(folioM,monto,id_unico ,alumno_id);

end//




delimiter ;

/* Insertamos las carreras*/

call agregarcarrera("INGENIERIA EN SISTEMAS COMPUTACIONALES","XOYOTITLA","ESCOLARIZADO");


call agregarcarrera("INGENIERIA INDUSTRIAL","XOYOTITLA","ESCOLARIZADO");


call agregarcarrera("INGENIERIA INDUSTRIAS ALIMENTARIAS","XOYOTITLA","ESCOLARIZADO");


call agregarcarrera("INGENIERIA EN ADMINISTRACION","XOYOTITLA","ESCOLARIZADO");


call agregarcarrera("INGENIERIA AMBIENTAL","XOYOTITLA","ESCOLARIZADO");



call agregarcarrera("INGENIERIA INDUSTRIAL","XOYOTITLA","SISTEMA ABIERTO");


call agregarcarrera("INGENIERIA EN ADMINISTRACION","XOYOTITLA","SISTEMA ABIERTO");


call agregarcarrera("INGENIERIA INDUSTRIAL","TUXPAN","ESCOLARIZADO");


call agregarcarrera("INGENIERIA AMBIENTAL","TUXPAN","ESCOLARIZADO");


call agregarcarrera("INGENIERIA EN TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES","TUXPAN","ESCOLARIZADO");


call agregarcarrera("INGENIERIA AMBIENTAL","ALAMO","ESCOLARIZADO");


call agregarcarrera("INGENIERIA EN SISTEMAS COMPUTACIONALES","ALAMO","ESCOLARIZADO");




call agregarArea("CULTURA GENERAL");
call agregarArea("SISTEMAS COMPUTACIONALES");
call agregarArea("ADMINISTRACION");
call agregarArea("INDUSTRIAL");
call agregarArea("INDUSTRIAS ALIMENTARIAS");
call agregarArea("AMBIENTAL");
call agregarArea("CIENCIAS BASICAS");


call agregartipodocumento("LIBRO");
call agregartipodocumento("RESIDENCIA O TESIS");









