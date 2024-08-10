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
import br.com.ControleDeEstoque.model.Employees;
import br.com.ControleDeEstoque.view.FrmLogin;
import br.com.ControleDeEstoque.view.FrmMenu;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe de acesso a dados (DAO) responsável por realizar operações de CRUD e outras operações relacionadas
 * à tabela de funcionários no banco de dados.
 * @author Lívia
 */
public class EmployeesDAO {

    //Conexão com o banco de dados
    private final Connection con;

    /**
     * Construtor da classe EmployeesDAO. Inicializa a conexão com o banco de dados.
     */
    public EmployeesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * Cadastra um novo funcionário no banco de dados.
     *
     * @param obj O objeto {@link Employees} contendo os dados do funcionário a ser cadastrado.
     */
    public void cadastrarFuncionario(Employees obj) {
        String sql = """
                     INSERT INTO tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    /**
     * Altera os dados de um funcionário existente no banco de dados.
     *
     * @param obj O objeto {@link Employees} contendo os dados atualizados do funcionário.
     */
    public void alterarFuncionario(Employees obj) {
        String sql = "UPDATE tb_funcionarios SET nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17, obj.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    /**
     * Exclui um funcionário do banco de dados.
     *
     * @param obj O objeto {@link Employees} representando o funcionário a ser excluído.
     */
    public void excluirFuncionario(Employees obj) {
        String sql = "DELETE FROM tb_funcionarios WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, obj.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    /**
     * Lista todos os funcionários cadastrados no banco de dados.
     *
     * @return Uma lista de objetos {@link Employees} representando todos os funcionários.
     */
    public List<Employees> listarFuncionarios() {
        List<Employees> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_funcionarios";
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employees obj = new Employees();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
     * Busca funcionários pelo nome no banco de dados.
     *
     * @param nome O nome do funcionário a ser buscado.
     * @return Uma lista de objetos {@link Employees} representando os funcionários encontrados.
     */
    public List<Employees> buscarFuncionariosPorNome(String nome) {
        List<Employees> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_funcionarios WHERE nome LIKE ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Employees obj = new Employees();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
     * Efetua o login de um funcionário no sistema, verificando as credenciais de email e senha.
     *
     * @param email O email do funcionário.
     * @param senha A senha do funcionário.
     */
    public void efetuaLogin(String email, String senha) {
        try {

            //Primeiro passo - SQL
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //Usuário efetuou o login
                
                //Caso o usuário seja do tipo admin
                if(rs.getString("nivel_acesso").equals("Administrador")){
                JOptionPane.showMessageDialog(null, "Seja bem-vindo ao sistema!");
                FrmMenu tela = new FrmMenu();
                tela.usuariologado = rs.getString("nome");
                tela.setVisible(true);
                }
                
                //Caso seja tipo limitado 
                else if(rs.getString("nivel_acesso").equals("Usuário")){
                JOptionPane.showMessageDialog(null, "Seja bem-vindo ao sistema!");
                FrmMenu tela = new FrmMenu();
                tela.usuariologado = rs.getString("nome");
                
                //Desabilitar os menus que não tem acesso
                tela.menu_posicaododia.setEnabled(false);
                tela.menu_controle.setVisible(false);
                tela.setVisible(true); 
                }
                
            } else {
                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                new FrmLogin().setVisible(true);
            }

        } catch (HeadlessException | SQLException e) {
        }
    }
}
