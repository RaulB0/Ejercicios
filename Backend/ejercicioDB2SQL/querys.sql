-- SELECCIONAR TODOS LOS PRODUCTOS DE COLOR NEGRO

SELECT PRODUCTO.CODIGO,PRODUCTO.NOMBRE
FROM PRODUCTO,COLORES
WHERE COLORES.NOMBRE = 'NEGRO'
AND PRODUCTO.COLOR = COLORES.CODIGO


-- Seleccionar todos los productos de iluminación.

SELECT PRODUCTO.NOMBRE
FROM PRODUCTO INNER JOIN PRODUCTO_CATEGORIA 
ON PRODUCTO_CATEGORIA.CODIGO_PRODUCTO = PRODUCTO.CODIGO
INNER JOIN CATEGORIA 
ON CATEGORIA.CODIGO = PRODUCTO_CATEGORIA.CODIGO_CATEGORIA
WHERE CATEGORIA.NOMBRE LIKE 'ILUMINACION'

-- Cambiar el nombre del color VERDE pasa a ser AMARILLO.

UPDATE COLORES
SET NOMBRE = 'AMARILLO'
WHERE NOMBRE LIKE 'VERDE'


-- Eliminar todos los productos de la categoría ILUMINACIÓN.

DELETE FROM PRODUCTO
WHERE PRODUCTO.CODIGO IN (SELECT PRODUCTO.CODIGO
	FROM PRODUCTO INNER JOIN PRODUCTO_CATEGORIA 
	ON PRODUCTO_CATEGORIA.CODIGO_PRODUCTO = PRODUCTO.CODIGO
	INNER JOIN CATEGORIA 
	ON CATEGORIA.CODIGO = PRODUCTO_CATEGORIA.CODIGO_CATEGORIA
	WHERE CATEGORIA.NOMBRE LIKE 'ILUMINACION')
	
-- Retornar el nombre de todos los productos que estén en mas de una categoría.

SELECT PRODUCTO.NOMBRE
FROM PRODUCTO INNER JOIN PRODUCTO_CATEGORIA 
ON PRODUCTO_CATEGORIA.CODIGO_PRODUCTO = PRODUCTO.CODIGO
GROUP BY PRODUCTO_CATEGORIA.CODIGO_PRODUCTO,PRODUCTO.NOMBRE
HAVING COUNT(PRODUCTO_CATEGORIA.CODIGO_PRODUCTO) > 1
	