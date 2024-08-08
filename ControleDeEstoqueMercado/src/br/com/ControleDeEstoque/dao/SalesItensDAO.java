/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.dao;

import br.com.ControleDeEstoque.jdbc.ConnectionFactory;
import br.com.ControleDeEstoque.model.Products;
import br.com.ControleDeEstoque.model.SalesItens;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author livia
 */
public class SalesItensDAO {
    private Connection con;

    public SalesItensDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Método que cadastra itens
    public void cadastraItem(SalesItens obj){
        try {
             String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal) values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProdutos().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());

            stmt.execute();
            stmt.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: "+ erro);
        }
       
    }
    ////metodo que lista itens de uma venda por id
    public List<SalesItens> listarItensPorId(int venda_id) {
        
        try { 
            
            List<SalesItens> lista = new ArrayList<>();
        String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                 + "inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id=?";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                SalesItens item = new SalesItens();
                Products prod = new Products();
                
                item.setId(rs.getInt("i.id"));
                prod.setDescricao(rs.getString("p.descricao"));
                item.setSubtotal(rs.getInt("i.subtotal"));
                prod.setPreco(rs.getDouble("p.preco"));
                item.setQtd(rs.getInt("i.qtd"));
                
                item.setProdutos(prod);
                
                lista.add(item);
                
            }
                return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
            return null;
        }
    
}
}
