/*==============================================================*/
/* Table: CLASSDETAIL							                */
/*==============================================================*/		
DROP TABLE IF EXISTS CLASSDETAIL CASCADE;

CREATE TABLE CLASSDETAIL(
PID SERIAL,
CLASS VARCHAR(20) NOT NULL,
DESCRIPTION VARCHAR(30),
MEDIUM VARCHAR(2),
TUTIONFEE NUMERIC,
PRIMARY KEY (PID)
);

/*==============================================================*/
/* Table: ADDRESS							                    */
/*==============================================================*/		
DROP TABLE IF EXISTS ADDRESS CASCADE;

CREATE TABLE ADDRESS(
PID SERIAL,
ADDRESSLINE1 VARCHAR(255),
ADDRESSLINE2 VARCHAR(255),
VILLAGE VARCHAR(255) NOT NULL,
MANDAL VARCHAR(100),
PHONE BIGINT,
ALTPHONE BIGINT,
PRIMARY KEY(PID)
);

/*==============================================================*/
/* Table: ADMISSION							                    */
/*==============================================================*/		
DROP TABLE IF EXISTS ADMISSION CASCADE;

CREATE TABLE ADMISSION(
PID SERIAL,
ADMISSIONID VARCHAR(255) NOT NULL UNIQUE,
SURNAME VARCHAR(255) ,
FIRSTNAME VARCHAR(255) ,
LASTNAME VARCHAR(255),
DOB DATE ,
FATHERNAME VARCHAR(255) ,
MOTHERNAME VARCHAR(255) ,
DOJ DATE ,
ADMITTEDCLASSFID INT ,
CASTE VARCHAR(50) ,
CURRENTSTATUS VARCHAR(10) ,
PRIMARY KEY(PID),
FOREIGN KEY (ADMITTEDCLASSFID) REFERENCES CLASSDETAIL(PID)
);

/*==============================================================*/
/* Table: STUDENT							                	*/
/*==============================================================*/		
DROP TABLE IF EXISTS STUDENT CASCADE;

CREATE TABLE STUDENT (
PID SERIAL,
ADMISSIONFID BIGINT NOT NULL,
PRESENTCLASSFID INT NOT NULL,
ADDRESSFID BIGINT NOT NULL,
PRIMARY KEY(PID),
FOREIGN KEY (ADMISSIONFID) REFERENCES ADMISSION(PID),
FOREIGN KEY (PRESENTCLASSFID) REFERENCES CLASSDETAIL(PID),
FOREIGN KEY (ADDRESSFID) REFERENCES ADDRESS(PID)
);

/*==============================================================*/
/* Table: FEETRANSACTION										*/
/*==============================================================*/	
CREATE TABLE FEETRANSACTION (
PID SERIAL,
STUDENTFID BIGINT NOT NULL,
TRANSACTIONDATE TIMESTAMP NOT NULL,
AMOUNT NUMERIC NOT NULL,
PRIMARY KEY(PID),
FOREIGN KEY (STUDENTFID) REFERENCES STUDENT(PID)
);

/*===============================================================
 * Table: STUDENTCSV 
 *================================================================*/
CREATE TABLE STUDENTCSVEXPORT(
PID BIGINT NOT NULL AUTO_INCREMENT,
ADMISSIONID VARCHAR(100),
NAME VARCHAR(100),
class varchar(20),
PHONE varchar(11),
VILLAGE VARCHAR(255),
PRIMARY KEY(PID)
)ENGINE=INNODB AUTO_INCREMENT=0; 
