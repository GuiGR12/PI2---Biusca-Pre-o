/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ggr12
 */
public class ProdutosDAO {
            
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public String url = "jdbc:mysql://127.0.0.1:3306/buscapreco"; 
    public String user = "root"; 
    public String password = "#333porto";       
    
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
           
        }
    }
   
    
    public int cadastrar(Produtos produto){
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO produtos (nome_produto, marca, preco, quantidade, data_compra) VALUES(?,?,?,?,?)");
            String produtolocal = setaLocal(produto.getNomeProduto(), null);
            st.setString(1,produtolocal);
            st.setString(2,produto.getMarca());
            st.setFloat(3,produto.getPreco());
            st.setInt(4,produto.getQuantidade());
            st.setString(5,produto.getDataCompra());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public String setaLocal(String produto, String local){
        if (local.equals("") || local == null){
            return "Estoque - " + "Produto";
        }
        return local + " - " + produto;       
    }
    
    public List<Produtos> consultar(String consulta){
        
        try {
            
            st = conn.prepareStatement("SELECT * from produtos WHERE nome_produto LIKE ?");
            st.setString(1, "%" + consulta + "%");
                                                       
            rs = st.executeQuery();
            
            List<Produtos> listaProdutos = new ArrayList<>();
            
            while(rs.next()){
                Produtos produto = new Produtos();
                
                produto.setId(rs.getInt("id"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDataCompra(rs.getString("data_compra"));
                
                listaProdutos.add(produto);
                
            }
            
            return listaProdutos;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
     public int cadastrarCompra(Compras compra){
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO compras (data_mercado, valor_total, forma_pagamento) VALUES(?,?,?)");
            st.setString(1,compra.getDataMercado());
            st.setFloat(2,compra.getValorTotal());
            st.setString(3,compra.getFormaPagamento());
            
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
     
    public List<Compras> consultarCompras(){
        
        try {
            
            st = conn.prepareStatement("SELECT * from compras");
                                                                   
            rs = st.executeQuery();
            
            List<Compras> listaCompras = new ArrayList<>();
            
            while(rs.next()){
                Compras compra = new Compras();
                
                compra.setId(rs.getInt("id"));
                compra.setDataMercado(rs.getString("data_mercado"));
                compra.setValorTotal(rs.getFloat("valor_total"));
                compra.setFormaPagamento(rs.getString("forma_pagamento"));
                                
                listaCompras.add(compra);
                
            }
            
            return listaCompras;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    } 
    
    public int excluirCompra(Compras compra){
        
        int status;
        
        try {
            st = conn.prepareStatement("DELETE FROM compras WHERE id = ?");
            st.setInt(1, compra.getId());
            
            status = st.executeUpdate();
            return status; 
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    
    public int excluir(Produtos produto){
        
        int status;
        
        try {
            st = conn.prepareStatement("DELETE FROM produtos WHERE id = ?");
            st.setInt(1, produto.getId());
            
            status = st.executeUpdate();
            return status; 
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    
}
    

