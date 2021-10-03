DROP TABLE IF EXISTS ventas_contienen_productos;
DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS trabajadores;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS categorias;

DROP SEQUENCE IF EXISTS categorias_secuencia;
DROP SEQUENCE IF EXISTS productos_secuencia;
DROP SEQUENCE IF EXISTS ventas_secuencia;
DROP SEQUENCE IF EXISTS trabajadores_secuencia;

DROP TRIGGER IF EXISTS TR_insertar_venta ON Ventas;
DROP TRIGGER IF EXISTS TR_insertar_trabajador ON Trabajadores;
DROP TRIGGER IF EXISTS TR_insertar_producto ON Productos;
DROP TRIGGER IF EXISTS TR_insertar_categoria ON Categorias;



CREATE SEQUENCE categorias_secuencia;
CREATE SEQUENCE productos_secuencia;
CREATE SEQUENCE ventas_secuencia;
CREATE SEQUENCE trabajadores_secuencia;
   
    
    CREATE TABLE categorias
(

    categoria_id bigint NOT NULL,
    categoria_descripcion character varying(255)  NOT NULL,
    categoria_estado integer NOT NULL DEFAULT 1,
    categoria_fecha_creacion timestamp without time zone ,
    categoria_nombre character varying(255) NOT NULL,
    CONSTRAINT categorias_pkey PRIMARY KEY (categoria_id)
);
    CREATE TABLE productos
(
    producto_id bigint NOT NULL,
    producto_descripcion character varying(255) NOT NULL,
    producto_estado integer NOT NULL DEFAULT 1,
    producto_existencias integer NOT NULL,
    producto_fecha_creacion timestamp without time zone,
    producto_nombre character varying(255) NOT NULL,
    producto_precio double precision NOT NULL,
    CONSTRAINT productos_pkey PRIMARY KEY (producto_id)
);
    CREATE TABLE trabajadores
(
    trabajador_id bigint,
    trabajador_apellido character varying(255)  NOT NULL,
    trabajador_celular character varying(255) NOT NULL,
    trabajador_contrasena character varying(255)   NOT NULL,
    trabajador_correo character varying(255) NOT NULL,
    trabajador_documento character varying(255) NOT NULL,
    trabajador_estado integer DEFAULT 1,
    trabajador_nombre character varying(255)  NOT NULL,
    CONSTRAINT trabajadores_pkey PRIMARY KEY (trabajador_id)
);
    CREATE TABLE ventas
(
    venta_id bigint NOT NULL,
    venta_estado integer NOT NULL DEFAULT 1,
    venta_fecha timestamp without time zone ,
    venta_total double precision,
    CONSTRAINT ventas_pkey PRIMARY KEY (venta_id)
);
    CREATE TABLE ventas_contienen_productos
(
    ventas_contienen_productos_unidades double precision NOT NULL,
    ventas_contienen_productos_valor double precision NOT NULL,
    producto_id bigint NOT NULL,
    venta_id bigint NOT NULL,
    CONSTRAINT ventas_contienen_productos_pkey PRIMARY KEY (producto_id, venta_id),
    CONSTRAINT fk_producto FOREIGN KEY (producto_id)
        REFERENCES public.productos (producto_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_venta FOREIGN KEY (venta_id)
        REFERENCES public.ventas (venta_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



CREATE OR REPLACE FUNCTION F_insertar_venta() RETURNS TRIGGER AS $$
 DECLARE
 BEGIN
    NEW.venta_id := NEXTVAL('ventas_secuencia');
    NEW.venta_fecha := SELECT CURRENT_DATE;
    RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION F_insertar_categoria() RETURNS TRIGGER AS $$
 DECLARE
 BEGIN
    NEW.categoria_id := NEXTVAL('categorias_secuencia');
    NEW.categoria_fecha_creacion := SELECT CURRENT_DATE;
    RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION F_insertar_producto() RETURNS TRIGGER AS $$
 DECLARE
 BEGIN
    NEW.producto_id := NEXTVAL('productos_secuencia');
    NEW.producto_fecha_creacion := SELECT CURRENT_DATE;
    RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION F_insertar_trabajador() RETURNS TRIGGER AS $$
 DECLARE
 BEGIN
    NEW.trabajador_id := NEXTVAL('trabajadores_secuencia');
    RETURN NEW;
END
$$ LANGUAGE plpgsql;


CREATE TRIGGER TR_insertar_trabajador BEFORE INSERT
ON Trabajadores FOR EACH ROW
EXECUTE PROCEDURE F_insertar_trabajador();

CREATE TRIGGER TR_insertar_producto BEFORE INSERT
ON Productos FOR EACH ROW
EXECUTE PROCEDURE F_insertar_producto();
    
CREATE TRIGGER TR_insertar_categoria BEFORE INSERT
ON Categorias FOR EACH ROW
EXECUTE PROCEDURE F_insertar_categoria();

CREATE TRIGGER TR_insertar_venta BEFORE INSERT
ON Ventas FOR EACH ROW
EXECUTE PROCEDURE F_insertar_venta();


INSERT INTO trabajadores (trabajador_nombre,trabajador_apellido,trabajador_correo,trabajador_celular,trabajador_documento,trabajador_contrasena)
VALUES('Cristian', 'Pascumal', 'cristianpascumal@gmail.com', '3166891624','1113696488','lamejor');

INSERT INTO trabajadores (trabajador_nombre,trabajador_apellido,trabajador_correo,trabajador_celular,trabajador_documento,trabajador_contrasena)
VALUES('Maria', 'Dorado', 'mariadorado1110@gmail.com', '3178145209','59650873','lamejor');

INSERT INTO categoriras (categoria_nombre,categoria_descripcion) VALUES ('Aseo','Productos de aseo');


