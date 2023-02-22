CREATE SCHEMA santa_schema AUTHORIZATION santa; 

DROP TABLE PRESENTS IF EXISTS;

CREATE TABLE PRESENTS ( 
   Id INT NOT NULL, 
   Title VARCHAR(50) NOT NULL,  
   Weight INT NOT NULL,
   Created_by VARCHAR(50) NOT NULL,
   Created_date DATE NOT NULL,
   Hooded_Flag BOOLEAN DEFAULT FALSE
);

INSERT INTO PRESENTS values(1, 'present1', 30, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(2, 'present2', 100, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(3, 'present3', 130, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(4, 'present4', 20, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(5, 'present5', 12, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(6, 'present5', 21, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(7, 'present5', 35, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(8, 'present5', 10, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(9, 'present5', 15, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(10, 'present5', 10, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(11, 'present5', 10, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(12, 'present5', 2, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(13, 'present5', 2, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(14, 'present5', 121, 'system', CURRENT_DATE(), false);
INSERT INTO PRESENTS values(15, 'present5', 90, 'system', CURRENT_DATE(), false);