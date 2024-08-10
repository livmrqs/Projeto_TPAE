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
package br.com.ControleDeEstoque.model;

/**
 * Representa um empregado no sistema de controle de estoque.
 * 
 * A classe {@code Employees} estende a classe {@code Clientes}, adicionando
 * atributos específicos para empregados, como senha, cargo e nível de acesso.
 * 
 * @author livia
 */
public class Employees extends Clientes {
    
    /** Senha do empregado para acesso ao sistema. */
    private String senha;
    
    /** Cargo do empregado na empresa. */
    private String cargo;
    
    /** Nível de acesso do empregado no sistema. */
    private String nivel_acesso;
    
    /**
     * Obtém a senha do empregado.
     * 
     * @return a senha do empregado.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do empregado.
     * 
     * @param senha a senha do empregado.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o cargo do empregado.
     * 
     * @return o cargo do empregado.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do empregado.
     * 
     * @param cargo o cargo do empregado.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtém o nível de acesso do empregado.
     * 
     * @return o nível de acesso do empregado.
     */
    public String getNivel_acesso() {
        return nivel_acesso;
    }

    /**
     * Define o nível de acesso do empregado.
     * 
     * @param nivel_acesso o nível de acesso do empregado.
     */
    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
}
