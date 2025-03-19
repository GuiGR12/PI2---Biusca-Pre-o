CREATE USER 'user_principal'@'localhost' IDENTIFIED BY 'testuser123';
CREATE ROLE 'membros_casa';
GRANT SELECT, INSERT, UPDATE, DELETE ON buscapreco.* TO 'membros_casa';
GRANT 'membros_casa' TO 'user_principal'@'localhost';