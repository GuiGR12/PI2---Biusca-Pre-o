/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package data;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutosDAOTest {
    
    public ProdutosDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSetaLocal(){
        
        Produtos produto = null;
        ProdutosDAO instance = new ProdutosDAO();
        
        produto.setId(1);
        produto.setNomeProduto("Banana");
        produto.setMarca("Bananosa");
        produto.setPreco(100);
        produto.setQuantidade(2);
        produto.setDataCompra("11/10/2020");
        
        
        String local1 = null;
        String local2 = "";
        String local3 = "Geladeira";
        
        String setaLocal1 = instance.setaLocal(produto.getNomeProduto(), local1);
        String setaLocal2 = instance.setaLocal(produto.getNomeProduto(), local2);
        String setaLocal3 = instance.setaLocal(produto.getNomeProduto(), local3);
        assertEquals(setaLocal1, null);
        assertEquals(setaLocal2, "");
        assertEquals(setaLocal3, "Geladeira - Banana");
    }      

    
}
