/*
 * The MIT License
 *
 * Copyright 2024 Lívia Marques.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
 * Classe de acesso a dados (DAO) responsável por realizar operações de CRUD e outras operações
 * relacionadas à tabela de produtos no banco de dados.
 * 
 * @author livia
 */

public class ProductsDAO {

    private Connection con;
    
    /**
     * Construtor da classe ProductsDAO. Inicializa a conexão com o banco de dados.
     */
    public ProductsDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * Cadastra um novo produto no banco de dados.
     * 
     * @param obj O objeto {@link Products} contendo os dados do produto a ser cadastrado.
     */
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
    /**
     * Exclui um produto do banco de dados.
     * 
     * @param obj O objeto {@link Products} representando o produto a ser excluído.
     */
    public void excluirProduto(Products obj) {
        String sql = "DELETE FROM tb_produtos WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }
    
    /**
     * Lista todos os produtos cadastrados no banco de dados.
     * 
     * @return Uma lista de objetos {@link Products} representando todos os produtos.
     */
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
    /**
     * Lista produtos por nome.
     * 
     * @param nome O nome ou parte do nome do produto a ser buscado.
     * @return Uma lista de objetos {@link Products} representando os produtos encontrados.
     */
    public List<Products> listarProdutosPorNome(String nome) {
        
        try { 
            
            List<Products> lista = new ArrayList<>();
        String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like?";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
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
    /**
     * Altera os dados de um produto existente no banco de dados.
     * 
     * @param obj O objeto {@link Products} contendo os dados atualizados do produto.
     */
    public void alterarProdutos(Products obj) {
        
        try {
             String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
}
    /**
     * Consulta um produto pelo nome.
     * 
     * @param nome O nome do produto a ser consultado.
     * @return O objeto {@link Products} representando o produto encontrado.
     */
    public Products consultaProdutoPorNome(String nome) {
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Products obj = new Products();
            Suppliers f = new Suppliers();

            if (rs.next()) {
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
    
    /**
     * Consulta um produto pelo ID.
     * 
     * @param id O ID do produto a ser consultado.
     * @return O objeto {@link Products} representando o produto encontrado.
     */
    public Products buscaPorId(int id) {
        try {
            String sql = "select * from tb_produtos where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Products obj = new Products();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
    
     /**
     * Atualiza a quantidade em estoque de um produto.
     * 
     * @param id O ID do produto a ter seu estoque atualizado.
     * @param qtd_nova A nova quantidade de estoque.
     */
    public void atualizaEstoque(int id, int qtd_nova){
        try {
            String sql = "update tb_produtos set qtd_estoque=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado no estoque");
        }
    }
    
    /**
     * Retorna a quantidade atual em estoque de um produto.
     * 
     * @param id O ID do produto a ser consultado.
     * @return A quantidade atual em estoque.
     */
    public int retornaEstoqueAtual(int id){
        try {
            int qtd_estoque = 0;
            String sql = "select qtd_estoque from tb_produtos where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Products p = new Products();
                
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            return qtd_estoque;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Adiciona uma nova quantidade ao estoque existente de um produto.
     * 
     * @param id O ID do produto a ter seu estoque atualizado.
     * @param qtd_nova A nova quantidade de estoque a ser adicionada.
     */
    public void adicionarEstoque(int id, int qtd_nova){
        try {
            String sql = "update tb_produtos set qtd_estoque=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado no estoque");
        }
    }
}
