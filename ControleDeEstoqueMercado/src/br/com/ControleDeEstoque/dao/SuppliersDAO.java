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
 * relacionadas aos fornecedores no banco de dados.
 * 
 * @author livia
 */
public class SuppliersDAO {
    
    private Connection con;

    /**
     * Construtor da classe SuppliersDAO. Inicializa a conexão com o banco de dados.
     */
    public SuppliersDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * Cadastra um novo fornecedor no banco de dados.
     * 
     * @param obj O objeto {@link Suppliers} contendo os dados do fornecedor a ser cadastrado.
     */
    public void cadastrarFornecedores(Suppliers obj) {
        String sql = """
                     INSERT INTO tb_fornecedores(nome, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
}
    /**
     * Exclui um fornecedor do banco de dados.
     * 
     * @param obj O objeto {@link Suppliers} contendo o ID do fornecedor a ser excluído.
     */
    public void excluirFornecedor(Suppliers obj) {
        String sql = "DELETE FROM tb_fornecedores WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }
    
    /**
     * Atualiza os dados de um fornecedor no banco de dados.
     * 
     * @param obj O objeto {@link Suppliers} contendo os dados atualizados do fornecedor.
     */
    public void alterarFornecedor(Suppliers obj) {
        String sql = "UPDATE tb_fornecedores SET nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            stmt.setInt(13, obj.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }
    
    /**
     * Lista todos os fornecedores cadastrados no banco de dados.
     * 
     * @return Uma lista de objetos {@link Suppliers} representando todos os fornecedores.
     */
    public List<Suppliers> listarFornecedores() {
        List<Suppliers> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_fornecedores";
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Suppliers obj = new Suppliers();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
        return lista;
}
    /**
     * Lista fornecedores cujo nome contém a string fornecida.
     * 
     * @param nome O nome ou parte do nome dos fornecedores a serem listados.
     * @return Uma lista de objetos {@link Suppliers} representando os fornecedores cujo nome corresponde ao critério de busca.
     */
public List<Suppliers> listarFornecedoresPorNome(String nome) {
    List<Suppliers> lista = new ArrayList<>();
    String sql = "SELECT * FROM tb_fornecedores WHERE nome LIKE ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        // Definindo o valor do parâmetro, adicionando % para busca parcial
        stmt.setString(1, "%" + nome + "%");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Suppliers obj = new Suppliers();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
        }
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
    }
    return lista;
}
    /**
     * Consulta um fornecedor pelo nome.
     * 
     * @param nome O nome do fornecedor a ser consultado.
     * @return O objeto {@link Suppliers} correspondente ao fornecedor com o nome fornecido, ou null se não encontrado.
     */
    public Suppliers consultaFornecedoresPorNome(String nome){
        try {
    String sql = "SELECT * FROM tb_fornecedores WHERE nome=?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, nome);
    
    ResultSet rs = stmt.executeQuery();
    Suppliers obj = new Suppliers();
    
    if (rs.next()) {
        obj.setId(rs.getInt("id"));
        obj.setNome(rs.getString("nome"));
        obj.setCnpj(rs.getString("cnpj"));
        obj.setEmail(rs.getString("email"));
        obj.setTelefone(rs.getString("telefone"));
        obj.setCelular(rs.getString("celular"));
        obj.setCep(rs.getString("cep"));
        obj.setEndereco(rs.getString("endereco"));
        obj.setNumero(rs.getInt("numero"));
        obj.setComplemento(rs.getString("complemento"));
        obj.setBairro(rs.getString("bairro"));
        obj.setCidade(rs.getString("cidade"));
        obj.setUf(rs.getString("estado"));
    }
    return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            return null;
        }
    }
}
