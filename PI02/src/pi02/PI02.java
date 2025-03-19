/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PI02 {

    
    public static void main(String[] args) {
        
    JFrame janela = new JFrame();
    janela.setSize(400, 300);
    janela.setTitle("Busca Preço");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setLayout(new FlowLayout());
    
    JLabel cadastro = new JLabel();
    cadastro.setText("CADASTRO DE PRODUTO");
    janela.add(cadastro);
   
    JLabel nome = new JLabel();
    nome.setText("Digite o nome do produto:");
    janela.add(nome);
        
    JTextField campo1 = new JTextField(7);
    janela.add(campo1);
    
    
    JLabel marca = new JLabel();
    marca.setText("Digite a marca do produto:");
    janela.add(marca);
        
    JTextField campo2 = new JTextField(7);
    janela.add(campo2);
    
    
    JLabel preco = new JLabel();
    preco.setText("Digite o preço do produto:");
    janela.add(preco);
        
    JTextField campo3 = new JTextField(7);
    janela.add(campo3);
    
    
    JLabel quantidade = new JLabel();
    quantidade.setText("Digite a quantidade do produto:");
    janela.add(quantidade);
        
    JTextField campo4 = new JTextField(7);
    janela.add(campo4);
    
    JLabel dataCompra = new JLabel();
    dataCompra.setText("Digite a data da compra do produto:");
    janela.add(dataCompra);
        
    JTextField campo5 = new JTextField(7);
    janela.add(campo5);
    
    
    JButton botao = new JButton();
    botao.setText("OK");
    janela.add(botao);
    
        botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(janela, "Produto cadastrado com sucesso!\n Nome: " + campo1.getText() + "\nMarca: " + campo2.getText() + "\nPreço: " + campo3.getText() + 
                        "\nQuantidade: " + campo4.getText() + "Data de compra: " + campo5.getText());
            }      
        });    
            
        janela.setVisible(true);
        
    }
    
}
