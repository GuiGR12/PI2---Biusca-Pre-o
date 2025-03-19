CREATE VIEW gastos_gerais AS SELECT compras.valor_total, compras.data_mercado, mercados.nome_mercado
FROM compras JOIN mercados ON compras.mercados_id = mercados.id 
WHERE compras.valor_total > 300.00 ORDER BY compras.data_mercado DESC;

CREATE VIEW produtos_preco AS SELECT produtos.data_compra, produtos.marca, produtos.nome_produto, produtos.preco, mercados.nome_mercado
FROM produtos JOIN mercados ON produtos.mercados_id = mercados.id  
ORDER BY produtos.preco DESC;

CREATE VIEW compras_usuario AS SELECT usuarios.id, usuarios.nome, compras.data_mercado, mercados.nome_mercado
FROM usuarios JOIN compras ON usuarios.id = compras.usuarios_id 
JOIN mercados ON compras.mercados_id = mercados.id 
WHERE usuarios.id = 1 ORDER BY compras.data_mercado DESC;