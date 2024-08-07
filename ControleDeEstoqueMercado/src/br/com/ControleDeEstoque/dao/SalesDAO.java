/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.dao;

import br.com.ControleDeEstoque.jdbc.ConnectionFactory;
import br.com.ControleDeEstoque.model.Sales;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author livia
 */
public class SalesDAO {
    private Connection con;

    public SalesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Cadastrar venda
    public void cadastrarVenda(Sales obj){
        try {
             String sql = "insert into tb_vendas(cliente_id, data_venda, total_venda, observacoes) values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3, obj.getTotal_venda());
            stmt.setString(4, obj.getObs());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: "+ erro);
        }
       
    }
    
    //Retorna a última venda
    public int retornaUltimaVenda(){
        try {
            int idvenda=0;
            
            String query = "select max(id) id from tb_vendas";
            PreparedStatement ps = con.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                Sales p = new Sales();
                
                p.setId(rs.getInt("id"));
                
                idvenda = p.getId();
            }
            return idvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
  
} 
}
