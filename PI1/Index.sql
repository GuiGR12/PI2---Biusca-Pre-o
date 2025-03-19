CREATE INDEX idx_marca_produto ON produtos(marca, nome_produto);

CREATE INDEX idx_usuario_compra ON compras(usuarios_id, valor_total, data_mercado);