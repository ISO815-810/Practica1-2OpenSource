CREATE DATABASE Fundapec;

Use Fundapec;

CREATE TABLE Estudiantes(
	Id int primary key auto_increment,
    CedulaEstudiante varchar(11) not null,
    MatriculaEstudiante varchar(9) not null,
    CarreraAbrev varchar(3), 
    CreditosTotal smallint not null,
    CreditosCursados smallint not null
)ENGINE=InnoDb;

INSERT INTO Estudiantes(CedulaEstudiante, MatriculaEstudiante, CarreraAbrev, CreditosTotal, CreditosCursados) 
VALUES('40215563657','20162511','ISO',237,105);
INSERT INTO Estudiantes(CedulaEstudiante, MatriculaEstudiante, CarreraAbrev, CreditosTotal, CreditosCursados) 
 VALUES('00104070560','20162223','ISC',247,190);

SELECT * FROM Estudiantes;
