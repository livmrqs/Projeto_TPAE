/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.dao;

import br.com.ControleDeEstoque.jdbc.ConnectionFactory;
import br.com.ControleDeEstoque.model.Products;
import br.com.ControleDeEstoque.model.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author livia
 */
public class ProductsDAO {

    private Connection con;

    public ProductsDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrar produto
    public void cadastrarProduto(Products obj) {
        String sql = "INSERT INTO tb_produtos(descricao, preco, qtd_estoque, for_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
}
    //Método excluir produto
    
    //Método listar produtos
    public List<Products> listarProdutos() {
        
        try { 
            
            List<Products> lista = new ArrayList<>();
        String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                + "inner join tb_fornecedores as f on (p.for_id = f.id)";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Products obj = new Products();
                Suppliers f = new Suppliers();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);

                lista.add(obj);
            }
                return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
            return null;
        }
      
}
    //Método listar produtos por nome
}
