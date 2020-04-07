
-- Creación de un procedimiento para insertar un nuevo producto. El nombre del
-- procedimiento será INSERTAR_PRODUCTO y debe devolver un mensaje de error si
-- algo falla.

CREATE OR REPLACE PROCEDURE INSERTAR_PRODUCTO( IN ParamCodigo INTEGER, IN ParamNombre VARCHAR(20), IN ParamColor INTEGER, IN FECHA_CREACION DATE, OUT MsgError VARCHAR(50) )
LANGUAGE SQL
BEGIN ATOMIC
   DECLARE ExisteProducto INTEGER DEFAULT 0;
   DECLARE ExisteColor INTEGER DEFAULT 0;
   
   SET MsgError = '';
   
   SELECT COUNT(CODIGO) INTO ExisteProducto 
   FROM PRODUCTO WHERE CODIGO = ParamCodigo;
   
   IF ExisteProducto > 0 THEN
       SET MsgError = 'El producto ya existe';
       RETURN 1;
   END IF;
   
   SELECT COUNT(CODIGO) INTO ExisteColor 
   FROM COLORES WHERE CODIGO = ParamColor;
   
   IF ExisteColor < 1 THEN
       SET MsgError = 'El color no existe';
       RETURN 1;
   END IF;
   
   
   
   	
   INSERT INTO PRODUCTO (CODIGO,NOMBRE,COLOR,FECHA_CREACION) VALUES(ParamCodigo,ParamNombre,ParamColor,FECHA_CREACION);
   
END;

-- Creación de un procedure que elimine un producto.

CREATE OR REPLACE PROCEDURE BORRAR_PRODUCTO( IN ParamCodigo INTEGER, OUT MsgError VARCHAR(50) )
LANGUAGE SQL
BEGIN ATOMIC
   DECLARE ExisteProducto INTEGER DEFAULT 0;
   
   SET MsgError = '';
   
   SELECT COUNT(CODIGO) INTO ExisteProducto 
   FROM PRODUCTO WHERE CODIGO = ParamCodigo;
   
   IF ExisteProducto < 1 THEN
       SET MsgError = 'El producto no existe';
       RETURN 1;
   END IF;
   
   
   
   	
   DELETE FROM PRODUCTO WHERE CODIGO = ParamCodigo;
   
END;

-- Creación de una función que devuelva el número de productos que hay en la
-- categoría que indiquemos.



CREATE OR REPLACE FUNCTION COUNT_PRODUCTO_CATEGORY(IN ParamCategoria VARCHAR(20)) RETURNS INTEGER
BEGIN
  DECLARE NumProductos INTEGER DEFAULT 0;
  
  SELECT COUNT(*) INTO NumProductos
	FROM PRODUCTO INNER JOIN PRODUCTO_CATEGORIA 
	ON PRODUCTO_CATEGORIA.CODIGO_PRODUCTO = PRODUCTO.CODIGO
	INNER JOIN CATEGORIA 
	ON CATEGORIA.CODIGO = PRODUCTO_CATEGORIA.CODIGO_CATEGORIA
	WHERE CATEGORIA.NOMBRE LIKE ParamCategoria
	GROUP BY PRODUCTO_CATEGORIA.CODIGO_CATEGORIA;
  
  RETURN NumProductos;
END;

-- Ejemplos

-- Procedure insertar producto

CALL INSERTAR_PRODUCTO(15,'Persiana',1,'20/06/2006',?MSGERROR$VARCHAR$OUT);

-- Procedure borrar producto

CALL BORRAR_PRODUCTO (15, ?MSGERROR$VARCHAR$OUT);


-- Function buscar por categoria

SELECT COUNT_PRODUCTO_CATEGORY('SONIDO') FROM SYSIBM.SYSDUMMY1;

