        #drop database Institucion;
        create database if not exists Institucion;
        use Institucion;
        
        create table if not exists Estudiante(
        ID_Estudiante int not null,
        Cedula char (10) not null,
        Nombre char(30) not null,
        Apellido char(30) not null,
        observacion varchar(90),
        primary key(ID_Estudiante))
        ENGINE = InnoDB;
        
		create table if not exists Materia(
        ID_Materia int not null,
        NombreMat char(30) not null,
        NivelMat char(1) not null,
        primary key(ID_Materia))
        ENGINE = InnoDB;
        
		create table if not exists Profesor(
        ID_Profesor int not null,
        cedula char(10) not null,
        Nombre char(30) not null,
        Apellido char(30) not null,
        Telefono char(10) not null,
        primary key(ID_Profesor))
        ENGINE = InnoDB;
        SET SQL_SAFE_UPDATES = 0;

        create table if not exists Matricula(
        ID_Matricula int not null,
        ID_Estudiante int not null,
		ID_Profesor int not null,
        ID_Materia int not null,
        primary key(ID_Matricula),
        constraint ID_Estudiante1 foreign key(ID_Estudiante) references Estudiante(ID_Estudiante),
        constraint ID_Profesor2 foreign key(ID_Profesor) references Profesor(ID_Profesor),
        constraint ID_Materia3 foreign key(ID_Materia) references Materia(ID_Materia)
        ) Engine  = InnoDB;