DROP TABLE member CASCADE;

create sequence User_sec
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;

CREATE TABLE member(
	code Varchar (30) default nextval ('User_sec') NOT NULL,
	identification VARCHAR (15) NOT NULL PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	firstname VARCHAR(30) NOT NULL,
	lastName VARCHAR(30) NOT NULL,
	email VARCHAR(80) NOT NULL, 
	charge VARCHAR(50) NOT NULL,
	typeID VARCHAR(50) NOT NULL,
	phone VARCHAR(15) ,
	state VARCHAR(30) NOT NULL
);


-- ****************************************************************************************************
DROP TABLE project CASCADE;

create sequence Project_sec
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  DROP TABLE project CASCADE;

CREATE TABLE project(
	code Varchar (30) default nextval ('Project_sec') NOT NULL,
	projectID VARCHAR(20) NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	projectDescription VARCHAR(200) NOT NULL,
	projectManager VARCHAR(30) NOT NULL,
	state Varchar(20),
	FOREIGN KEY (projectManager) REFERENCES member(identification)
);




--******************************************************************************************************
DROP TABLE equipment CASCADE;

create sequence Equip_sec
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  DROP TABLE equipment CASCADE;

CREATE TABLE equipment(
	Code VARCHAR(30) default nextval('Equip_sec') NOT NULL,
	Name VARCHAR(30) NOT NULL,
	SerialNumber VARCHAR(20) NOT NULL PRIMARY KEY, 
	Description VARCHAR(200) NOT NULL,
	State VARCHAR(30) NOT NULL
);



--****************************************************************************************************
DROP TABLE loan CASCADE;

create sequence loan_sec
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  DROP TABLE loan CASCADE;
CREATE TABLE loan(
	code VARCHAR(30) default nextval('loan_sec') NOT NULL,
	userCode VARCHAR(15) NOT NULL,
	serialNumber VARCHAR(20) NOT NULL,
	state VARCHAR(15) NOT NULL,
	loanStartDate DATE NOT NULL,
	loanFinalDate DATE NOT NULL,
	loanDeliveryDate DATE,
	renovaciones integer NOT NULL,
	ticket BOOL NOT NULL,
	
	
	CONSTRAINT loan_pk PRIMARY KEY (userCode, serialNumber, loanStartDate),
	CONSTRAINT loan_fk1 FOREIGN KEY (userCode) REFERENCES member(identification)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT loan_fk2 FOREIGN KEY (serialNumber) REFERENCES equipment(SerialNumber)
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

--****************************************************************************************************
DROP TABLE ticket CASCADE;

create sequence tick_sec
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
CREATE TABLE ticket(
	code VARCHAR(30) DEFAULT nextval('tick_sec') NOT NULL,
	userCode VARCHAR(15) NOT NULL,
	serialNumber VARCHAR(20) NOT NULL,
	ticketDate DATE NOT NULL,
	state VARCHAR(15) NOT NULL,
	tipoMulta VARCHAR (30) NOT NULL,
	description VARCHAR(30),
	costomulta bigint,
	
	CONSTRAINT fine_pk PRIMARY KEY (userCode, serialNumber, ticketDate),
	CONSTRAINT fine_fk1 FOREIGN KEY (userCode) REFERENCES member(identification)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT fine_fk2 FOREIGN KEY (serialNumber) REFERENCES equipment(serialNumber)
	ON UPDATE NO ACTION ON DELETE NO ACTION
	
);

--****************************************************************************************************
DROP TABLE reserve CASCADE;

create sequence reserve_sec
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
CREATE TABLE reserve(
	code VARCHAR(30) DEFAULT nextval('reserve_sec') NOT NULL,
	userCode VARCHAR(15) NOT NULL,
	serialNumber VARCHAR(20) NOT NULL,
	startDate DATE NOT NULL,
	finalDate DATE NOT NULL,
	loanDate DATE,
	state VARCHAR(15) NOT NULL,
	ticket BOOL NOT NULL,
	
	CONSTRAINT reserve_pk PRIMARY KEY (userCode, serialNumber, startDate),
	CONSTRAINT reserve_pk1 FOREIGN KEY (userCode) REFERENCES member(identification)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT reserve_pk2 FOREIGN KEY (serialNumber) REFERENCES equipment(serialNumber)
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

--****************************************************************************************************
Drop TABLE project_member CASCADE;

CREATE TABLE project_member(
	projectID VARCHAR(30) NOT NULL,
	userIdentification VARCHAR(30) NOT NULL,

	CONSTRAINT projectMember_pk PRIMARY KEY(projectID, userIdentification),
	CONSTRAINT projectMember_fk1 FOREIGN KEY(projectID) REFERENCES project(projectID),
	CONSTRAINT projectMember_fk2 FOREIGN KEY(userIdentification) REFERENCES member(identification)
);


--****************************************************************************************************

-- Inserciones tabla member

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1151965345', 'J1151965345T', 'Juan', 'Tello', 'juan.tello@correounivalle.edu.co', 'Director de Laboratorio', 'Cedula de Ciudadania', '3118146141', 'Activo');
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1631514', 'D1631514B', 'Diego', 'Bello', 'diego.bello@correounivalle.edu.co', 'Administrador', 'Codigo de Estudiante', '3168646764', 'Activo');			
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1161924585', 'D1161924585O', 'David', 'Ortiz', 'david.ortiz@correounivalle.edu.co', 'Coordinador de Equipos', 'Cedula de Ciudadania', '3138546755', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1111621567', 'L1111621567A', 'Luis', 'Avila', 'luis.avila@correounivalle.edu.co', 'Coordinador de Equipos', 'Cedula de Ciudadania', '3198346744', 'Activo');			
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1204567', 'A1204567C', 'Arturo', 'Cerquera', 'arturo.cerquera@correounivalle.edu.co', 'Lider de Proyecto', 'Codigo de Estudiante', '3208026754', 'Activo');	

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1143956478', 'F1143956478G', 'Felipe', 'Gaviria', 'felipe.gaviria@correounivalle.edu.co', 'Lider de Proyecto', 'Cedula de Ciudadania', '3188346754', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1304425', 'J1304425A', 'Julian', 'Anacona', 'julian.anacona@correounivalle.edu.co', 'Lider de Proyecto', 'Codigo de Estudiante', '3198006754', 'Activo');
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1403450', 'C1403450R', 'Carolina', 'Rodriguez', 'carolina.rodriguez@correounivalle.edu.co', 'Lider de Proyecto', 'Codigo de Estudiante', '3225016754', 'Activo');
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1503490', 'L1503490P', 'Leidy', 'Palacios', 'leidy.palacios@correounivalle.edu.co', 'Lider de Proyecto', 'Codigo de Estudiante', '3102345412', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('442113', 'E442113E', 'Emanuel', 'Martinez', 'emanuel.martinez@correounivalle.edu.co', 'Miembro', 'Cedula de Extranjeria', '3102366413', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('143675', 'W143675P', 'Wilson', 'Parra', 'wilson.parra@correounivalle.edu.co', 'Miembro', 'Cedula de Extranjeria', '3122357212', 'Activo');			
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('152166', 'B152166S', 'Bergen', 'Scheider', 'bergen.scheider@correounivalle.edu.co', 'Miembro', 'Cedula de Extranjeria', '3152387312', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1628440', 'G1628440M', 'Giovanna', 'Manrique', 'giovanna.manrique@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3125566754', 'Activo');
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1723439', 'A1723439G', 'Andres', 'Gonzalez', 'andres.gonzalez@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3122556672', 'Activo');
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1421239', 'L1421239V', 'Lina', 'Velez', 'lina.velez@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3159004531', 'Activo');
			
INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1521636', 'V1521636C', 'Valeria', 'Castillo', 'valeria.castillo@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3150805521', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1721246', 'C1721246M', 'Camila', 'Mera', 'camila.mera@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3218680552', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1723236', 'V1723236A', 'Valeria', 'Arce', 'valeria.arce@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3008680651', 'Activo');

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1723211', 'M1723211C', 'Mayra Alejandra', 'Chingal', 'mayra.chingal@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3018330651', 'Activo');			

INSERT INTO member (identification, password, firstname, lastName, email, charge, typeID, phone, state) 
			VALUES ('1145221', 'V1145221P', 'Valentina', 'Paredes', 'valentina.paredes@correounivalle.edu.co', 'Miembro', 'Codigo de Estudiante', '3178335956', 'Activo');

			
-- Inserciones tabla equipment

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Computador DELL', '12345678', 'Computador portatil', 'Ocupado');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Computador ACER', '23245678', 'Computador portatil', 'Ocupado');	

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Computador MAC', '42345687', 'Computador de escritorio', 'Ocupado');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Computador HP', '53629865', 'Computador portatil', 'Ocupado');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Computador VAIO', '78569123', 'Computador portatil', 'Ocupado');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Kinect I', '53478209', 'Controlador de juego libre', 'Ocupado');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Kinect I', '67589124', 'Controlador de juego libre', 'Ocupado');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Kinect II', '90873451', 'Controlador de juego libre', 'Activo');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Kinect II', '65478301', 'Controlador de juego libre', 'Activo');

INSERT INTO equipment (Name, SerialNumber, Description, State) VALUES ('Kinect II', '90381526', 'Controlador de juego libre', 'Ocupado');


-- Inserciones tabla project

INSERT INTO project (projectID, name, projectDescription, projectManager, state) VALUES ('97363881', 'SWEET TYMMY', 'Proyecto de videojuego', '1204567', 'Activo');

INSERT INTO project (projectID, name, projectDescription, projectManager, state) VALUES ('34678219', 'ICO LEARNS', 'Proyecto de videojuego', '1143956478', 'Activo');

INSERT INTO project (projectID, name, projectDescription, projectManager, state) VALUES ('61304425', 'HISTORIC TALE', 'Proyecto de videojuego', '1304425', 'Activo');

INSERT INTO project (projectID, name, projectDescription, projectManager, state) VALUES ('52819182', 'SPACE LAN', 'Proyecto de videojuego', '1403450', 'Activo');

INSERT INTO project (projectID, name, projectDescription, projectManager, state) VALUES ('56473819', 'BUSCA MINAS', 'Proyecto de videojuego', '1503490', 'Activo');


-- Prestamos

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket, loanDeliveryDate) VALUES ('1145221', '12345678', 'Activo','2016-12-04','2016-12-11', 0, 'false', '2016-12-11');

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket, loanDeliveryDate) VALUES ('1145221', '12345678', 'Activo','2016-10-04','2016-10-11', 0, 'false', '2016-10-11');

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket, loanDeliveryDate) VALUES ('1521636', '65478301', 'Activo','2016-12-04','2016-12-11', 0, 'false', '2016-12-11');

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket, loanDeliveryDate) VALUES ('1521636', '78569123', 'Activo','2016-12-04','2016-12-11', 0, 'false', '2016-12-11');

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('143675', '67589124', 'Activo','2017-12-09','2016-12-16', 0, 'false'); --para reserva

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('143675', '42345687', 'Activo','2017-12-10','2016-12-17', 0, 'false'); -- para reserva

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('442113', '53629865', 'Activo','2017-12-09','2016-12-16', 0, 'false'); -- para renovar 

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('1161924585', '90381526', 'Activo','2017-12-10','2016-12-17', 0, 'false'); -- para renovar

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('1304425', '12345678', 'Activo','2017-12-06','2016-12-13', 0, 'false');-- para multa atraso

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('1151965345', '23245678', 'Activo','2017-12-05','2016-12-12', 0, 'false');-- para multa atraso

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('1628950', '78569123', 'Activo','2017-12-01','2016-12-08', 0, 'false');-- para multa reserva

INSERT INTO loan(userCode, serialNumber, state, loanstartdate, loanfinaldate, renovaciones,ticket) VALUES ('1161924585', '53478209', 'Activo','2017-12-03','2016-12-10', 0, 'false');-- para multa reserva


--Insert de usuaos en proyectos

INSERT INTO project_member VALUES ('97363881','442113');
INSERT INTO project_member VALUES ('97363881','143675');
INSERT INTO project_member VALUES ('97363881','152166');

INSERT INTO project_member VALUES ('34678219','442113');
INSERT INTO project_member VALUES ('34678219','143675');
INSERT INTO project_member VALUES ('34678219','1723439');

INSERT INTO project_member VALUES ('61304425','1628440');
INSERT INTO project_member VALUES ('61304425','1421239');
INSERT INTO project_member VALUES ('61304425','1521636');

INSERT INTO project_member VALUES ('52819182','1628440');
INSERT INTO project_member VALUES ('52819182','1721246');
INSERT INTO project_member VALUES ('52819182','1723211');

INSERT INTO project_member VALUES ('56473819','1721246');
INSERT INTO project_member VALUES ('56473819','1723211');
INSERT INTO project_member VALUES ('56473819','1145221');

