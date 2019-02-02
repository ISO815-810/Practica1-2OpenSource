CREATE DATABASE Unapec;

Use Unapec;

CREATE TABLE estudiantes_fundapec(
	Id int primary key auto_increment,
    IdEstudiante int,
    Cedula varchar(11),
    Matricula varchar(9),
    Carrera varchar(3),
    Creditos_totales int,
    Creditos_cursados int
)ENGINE = InnoDb;

SELECT * FROM estudiantes_fundapec;