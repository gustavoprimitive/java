CREATE TABLE empleados (
 id                 NUMBER,
 nombre             VARCHAR2(200),
 apellidos          VARCHAR2(200),
 edad               NUMBER,
 categoria          VARCHAR2(100),
 fecha_registro     DATE);
/

CREATE SEQUENCE seq_empleados MINVALUE 1 MAXVALUE 100000 NOCYCLE START WITH 1;
/