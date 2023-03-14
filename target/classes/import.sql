INSERT INTO clientes (id, nombre, apellido, forma_pago, creado_en, editado_en) VALUES (1,'Brian','Guerra','Credito',NULL,NULL),(2,'John','Doe','Debito',NULL,NULL),(4,'Pepa','Doe','Debito',NULL,NULL),(5,'Luci','Martinez','Credito',NULL,NULL),(6,'Luna','Garcia','Debito',NULL,NULL),(9,'Brian','Guerra','Mercado Pago',NULL,NULL),(10,'Lou','Loe','Paypal',NULL,NULL),(11,'Lalo','Mena','WebPay','2022-12-14 17:40:15','2022-12-14 18:57:45'),(12,'Pia','Perez','PaypalPlus','2022-12-14 19:05:14','2022-12-14 19:05:56');
INSERT INTO alumnos (id, nombre, apellido) VALUES(1, 'Johana', 'Doe');
INSERT INTO alumnos (id, nombre, apellido) VALUES(2, 'Pepe', 'Goe');
INSERT INTO cursos (id, titulo, profesor) VALUES(1, 'Curso Spring', 'Brian');
INSERT INTO cursos (id, titulo, profesor) VALUES(2, 'Curso Java EE 9', 'Brian');
INSERT INTO direcciones (calle, numero) VALUES('Vaticano',123);
INSERT INTO direcciones (calle, numero) VALUES('Colon', 456);
INSERT INTO tbl_clientes_direcciones (id_cliente, id_direccion) VALUES (1, 1);
INSERT INTO tbl_clientes_direcciones (id_cliente, id_direccion) VALUES (1, 2);
INSERT INTO clientes_detalles (prime, puntos_acumulados, cliente_detalle_id) VALUES (1 ,8000 ,1);
INSERT INTO tbl_alumnos_cursos (alumno_id, curso_id) VALUES (1, 1);
INSERT INTO tbl_alumnos_cursos (alumno_id, curso_id) VALUES (1, 2);
INSERT INTO facturas (description, total, id_Cliente) VALUES ('oficina', 4000, 1);
INSERT INTO facturas (description, total, id_Cliente) VALUES ('casa', 2000, 1);
INSERT INTO facturas (description, total, id_Cliente) VALUES ('deporte', 3000, 1);
INSERT INTO facturas (description, total, id_Cliente) VALUES ('computacion', 7000, 2);
