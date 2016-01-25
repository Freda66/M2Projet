#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Resultat
#------------------------------------------------------------

CREATE TABLE Resultat(
        idRun        int (11) Auto_increment  NOT NULL ,
        resultatInit Numeric ,
        resultatOpt  Numeric ,
        resultatMpfr Numeric ,
        PRIMARY KEY (idRun )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Measurement
#------------------------------------------------------------

CREATE TABLE Measurement(
        id     int (11) Auto_increment  NOT NULL ,
        nomVar Text ,
        min    Numeric ,
        max    Numeric ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;

