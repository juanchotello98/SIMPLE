/*


*/
CREATE TABLE member(
	userCode VARCHAR(7) NOT NULL PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	email VARCHAR(30) NOT NULL,
	charge VARCHAR(20) NOT NULL,
	cedula VARCHAR(12),
	phone VARCHAR(10)
);

CREATE TABLE project(
	projectCode VARCHAR(4) NOT NULL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	projectDescription VARCHAR(30) NOT NULL,
	projectManager VARCHAR(30) NOT NULL,
	FOREIGN KEY (projectManager) REFERENCES member(userCode)
);

CREATE TABLE user_project(
	userCode VARCHAR(7) NOT NULL,
	projectCode VARCHAR(4) NOT NULL,
	
	CONSTRAINT user_project_pk PRIMARY KEY (userCode,projectCode),
	CONSTRAINT user_project_fk1 FOREIGN KEY (userCode) REFERENCES member(userCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT user_project_fk2 FOREIGN KEY (projectCode) REFERENCES project(projectCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE equipment(
	equipmentCode VARCHAR(5) NOT NULL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	serialNumber VARCHAR(20) NOT NULL, 
	serialNumber VARCHAR(20) NOT NULL, 
	equipmentDescription VARCHAR(30) NOT NULL,
	equipmentState VARCHAR(1) NOT NULL
);	

CREATE TABLE loan(
	userCode VARCHAR(7) NOT NULL,
	equipmentCode VARCHAR(5) NOT NULL,
	loanStartDate DATE NOT NULL,
	loanFinalDate DATE NOT NULL,
	
	CONSTRAINT loan_pk PRIMARY KEY (userCode, equipmentCode, loanStartDate),
	CONSTRAINT loan_fk1 FOREIGN KEY (userCode) REFERENCES member(userCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT loan_fk2 FOREIGN KEY (equipmentCode) REFERENCES equipment(equipmentCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE fine(
	userCode VARCHAR(7) NOT NULL,
	equipmentCode VARCHAR(5) NOT NULL,
	fineDate DATE NOT NULL,
	fineState BOOL,
	fineDescriprion VARCHAR(30),
	
	CONSTRAINT fine_pk PRIMARY KEY (userCode, equipmentCode, fineDate),
	CONSTRAINT fine_fk1 FOREIGN KEY (userCode) REFERENCES member(userCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT fine_fk2 FOREIGN KEY (equipmentCode) REFERENCES equipment(equipmentCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION
	
);

CREATE TABLE reserve(
	userCode VARCHAR(7) NOT NULL,
	equipmentCode VARCHAR(5) NOT NULL,
	reserveStartDate DATE NOT NULL,
	reserveFinalDate DATE NOT NULL,
	reserveState BOOL,
	
	CONSTRAINT reserve_pk PRIMARY KEY (userCode, equipmentCode, reserveStartDate),
	CONSTRAINT reserve_pk1 FOREIGN KEY (userCode) REFERENCES member(userCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	
	CONSTRAINT reserve_pk2 FOREIGN KEY (equipmentCode) REFERENCES equipment(equipmentCode)
	ON UPDATE NO ACTION ON DELETE NO ACTION
)

