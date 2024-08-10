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
import br.com.ControleDeEstoque.model.Clientes;
import br.com.ControleDeEstoque.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe de acesso a dados (DAO) responsável por realizar operações de CRUD e outras operações
 * relacionadas à tabela de vendas no banco de dados.
 * 
 * @author livia
 */
public class SalesDAO {
    private Connection con;

    /**
     * Construtor da classe SalesDAO. Inicializa a conexão com o banco de dados.
     */
    public SalesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * Cadastra uma nova venda no banco de dados.
     * 
     * @param obj O objeto {@link Sales} contendo os dados da venda a ser cadastrada.
     */
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
        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: "+ erro);
        }
       
    }
    
    /**
     * Retorna o ID da última venda cadastrada no banco de dados.
     * 
     * @return O ID da última venda cadastrada.
     */
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
    /**
     * Lista todas as vendas realizadas em um determinado período.
     * 
     * @param data_inicio A data de início do período.
     * @param data_fim A data de fim do período.
     * @return Uma lista de objetos {@link Sales} representando as vendas realizadas no período.
     */
    public List<Sales> listarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim) {
        
        try { 
            
            List<Sales> lista = new ArrayList<>();
        String sql = "select v.id, date_format(v.data_venda,'%d/%m/%Y') as data_formatada, c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                + "inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Sales obj = new Sales();
                Clientes c = new Clientes();
                
                obj.setId(rs.getInt("v.id"));
                obj.setData_venda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));
                
                obj.setCliente(c);

                lista.add(obj);
            }
                return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
            return null;
        }
    
}
    /**
     * Calcula o total de vendas realizadas em uma determinada data.
     * 
     * @param data_venda A data da venda a ser consultada.
     * @return O total de vendas realizadas na data especificada.
     */
    public double retornaTotalVendaPorData(LocalDate data_venda){
        try {
            double totalvenda = 0;
            String sql = "select sum(total_venda) as total from tb_vendas where data_venda=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, data_venda.toString());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                totalvenda = rs.getDouble("total");
            }
            
            return totalvenda;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
