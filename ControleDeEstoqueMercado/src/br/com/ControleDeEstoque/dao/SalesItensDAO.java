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
import br.com.ControleDeEstoque.model.SalesItens;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 * Classe de acesso a dados (DAO) responsável por realizar operações de CRUD e outras operações
 * relacionadas aos itens de vendas no banco de dados.
 * 
 * @author livia
 */
public class SalesItensDAO {
    private Connection con;

    /**
     * Construtor da classe SalesItensDAO. Inicializa a conexão com o banco de dados.
     */
    public SalesItensDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * Cadastra um novo item de venda no banco de dados.
     * 
     * @param obj O objeto {@link SalesItens} contendo os dados do item de venda a ser cadastrado.
     */
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
    /**
     * Lista todos os itens de venda associados a uma venda específica.
     * 
     * @param venda_id O ID da venda cujos itens serão listados.
     * @return Uma lista de objetos {@link SalesItens} representando os itens da venda.
     */
    public List<SalesItens> listarItensPorId(int venda_id) {
        
        try { 
            
            List<SalesItens> lista = new ArrayList<>();
        String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                 + "inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id= ?";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                SalesItens item = new SalesItens();
                Products prod = new Products();
                
                item.setId(rs.getInt("i.id"));
                prod.setDescricao(rs.getString("p.descricao"));
                item.setSubtotal(rs.getDouble("i.subtotal"));
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
