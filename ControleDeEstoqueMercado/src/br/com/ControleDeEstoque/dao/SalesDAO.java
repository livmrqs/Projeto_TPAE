/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.dao;

import br.com.ControleDeEstoque.jdbc.ConnectionFactory;
import br.com.ControleDeEstoque.model.Clientes;
import br.com.ControleDeEstoque.model.Products;
import br.com.ControleDeEstoque.model.Sales;
import br.com.ControleDeEstoque.model.SalesItens;
import br.com.ControleDeEstoque.model.Suppliers;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    //Método listarVendasPorPeríodo
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
    //metodo que lista itens de uma venda por id
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
