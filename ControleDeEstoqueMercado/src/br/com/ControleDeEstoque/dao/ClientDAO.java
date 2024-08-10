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
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe responsável pelo gerenciamento de operações relacionadas à tabela
 * "tb_clientes" no banco de dados. Esta classe fornece métodos para cadastrar,
 * alterar, excluir, listar e buscar clientes.
 *
 * @author livia
 */
public class ClientDAO {

    private Connection con;

    /**
     * Construtor da classe ClientDAO. Estabelece a conexão com o banco de dados
     * usando a classe ConnectionFactory.
     */
    public ClientDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * Método para cadastrar um novo cliente na tabela "tb_clientes".
     *
     * @param obj Objeto da classe Clientes contendo as informações do cliente a
     * ser cadastrado.
     */
    public void cadastrarCliente(Clientes obj) {
        String sql = """
                     INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Definindo os parâmetros da query SQL com os valores do objeto Clientes.
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            // Executando a query.
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    /**
     * Método para alterar as informações de um cliente existente na tabela
     * "tb_clientes".
     *
     * @param obj Objeto da classe Clientes contendo as informações atualizadas
     * do cliente.
     */
    public void alterarCliente(Clientes obj) {
        String sql = "UPDATE tb_clientes SET nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Definindo os parâmetros da query SQL com os valores atualizados do objeto Clientes.
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());

            // Executando a query.
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    /**
     * Método para excluir um cliente da tabela "tb_clientes".
     *
     * @param obj Objeto da classe Clientes contendo o ID do cliente a ser
     * excluído.
     */
    public void excluirCliente(Clientes obj) {
        String sql = "DELETE FROM tb_clientes WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Definindo o ID do cliente a ser excluído.
            stmt.setInt(1, obj.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    /**
     * Método para listar todos os clientes da tabela "tb_clientes".
     *
     * @return Lista de objetos Clientes contendo as informações de todos os
     * clientes cadastrados.
     */
    public List<Clientes> listarClientes() {
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_clientes";
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            // Percorrendo os resultados da query e populando a lista de clientes.
            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
     * Método para buscar clientes pelo nome na tabela "tb_clientes".
     *
     * @param nome Nome do cliente a ser buscado.
     * @return Lista de objetos Clientes contendo as informações dos clientes
     * encontrados.
     */
    public List<Clientes> buscarClientesPorNome(String nome) {
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Definindo o parâmetro de busca (nome) na query SQL.
            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                // Percorrendo os resultados da query e populando a lista de clientes.
                while (rs.next()) {
                    Clientes obj = new Clientes();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
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
     * Método para consultar um cliente pelo nome na tabela "tb_clientes".
     *
     * @param nome Nome do cliente a ser consultado.
     * @return Objeto Clientes contendo as informações do cliente encontrado, ou
     * null se não encontrado.
     */
    public Clientes consultaPorNome(String nome) {
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }

    /**
     * Método para consultar um cliente pelo CPF na tabela "tb_clientes".
     *
     * @param cpf CPF do cliente a ser consultado.
     * @return Objeto Clientes contendo as informações do cliente encontrado, ou
     * null se não encontrado.
     */
    public Clientes consultaPorCPF(String cpf) {
        try {
            String sql = "select * from tb_clientes where cpf=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
}
