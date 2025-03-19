DELIMITER //
CREATE PROCEDURE compras_realizadas (usuarios_id INT)
BEGIN
	DECLARE usuario INT;
    
    SELECT usuarios.id, usuarios.nome, compras.data_mercado, compras.valor_total
    FROM usuarios JOIN compras ON usuarios.id = compras.usuarios_id
	WHERE usuario = usuarios_id;
    
END//
DELIMITER ;

CALL compras_realizadas (1);