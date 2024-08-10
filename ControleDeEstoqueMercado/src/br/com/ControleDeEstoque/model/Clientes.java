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
 * Representa um cliente no sistema de controle de estoque.
 * 
 * A classe {@code Clientes} encapsula as informações relacionadas a um cliente,
 * incluindo dados pessoais e de contato. Fornece métodos para acessar e modificar
 * esses dados através de getters e setters.
 * 
 * @author livia
 */
public class Clientes {
    
    /** Identificador único do cliente. */
    private int id;
    
    /** Nome completo do cliente. */
    private String nome;
    
    /** Registro Geral (RG) do cliente. */
    private String rg;
    
    /** Cadastro de Pessoas Físicas (CPF) do cliente. */
    private String cpf;
    
    /** Endereço de e-mail do cliente. */
    private String email;
    
    /** Número de telefone do cliente. */
    private String telefone;
    
    /** Número de celular do cliente. */
    private String celular;
    
    /** Código de Endereçamento Postal (CEP) do cliente. */
    private String cep;
    
    /** Endereço residencial do cliente. */
    private String endereco;
    
    /** Número do endereço residencial do cliente. */
    private int numero;
    
    /** Complemento do endereço residencial do cliente. */
    private String complemento;
    
    /** Bairro do cliente. */
    private String bairro;
    
    /** Cidade do cliente. */
    private String cidade;
    
    /** Unidade Federativa (UF) do cliente. */
    private String uf;
    
    /**
     * Obtém o identificador único do cliente.
     * 
     * @return o identificador único do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do cliente.
     * 
     * @param id o identificador único do cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome completo do cliente.
     * 
     * @return o nome completo do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome completo do cliente.
     * 
     * @param nome o nome completo do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o Registro Geral (RG) do cliente.
     * 
     * @return o RG do cliente.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Define o Registro Geral (RG) do cliente.
     * 
     * @param rg o RG do cliente.
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Obtém o Cadastro de Pessoas Físicas (CPF) do cliente.
     * 
     * @return o CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o Cadastro de Pessoas Físicas (CPF) do cliente.
     * 
     * @param cpf o CPF do cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o endereço de e-mail do cliente.
     * 
     * @return o e-mail do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do cliente.
     * 
     * @param email o e-mail do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o número de telefone do cliente.
     * 
     * @return o telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o número de telefone do cliente.
     * 
     * @param telefone o telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o número de celular do cliente.
     * 
     * @return o celular do cliente.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Define o número de celular do cliente.
     * 
     * @param celular o celular do cliente.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtém o Código de Endereçamento Postal (CEP) do cliente.
     * 
     * @return o CEP do cliente.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o Código de Endereçamento Postal (CEP) do cliente.
     * 
     * @param cep o CEP do cliente.
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Obtém o endereço residencial do cliente.
     * 
     * @return o endereço residencial do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço residencial do cliente.
     * 
     * @param endereco o endereço residencial do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o número do endereço residencial do cliente.
     * 
     * @return o número do endereço residencial do cliente.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número do endereço residencial do cliente.
     * 
     * @param numero o número do endereço residencial do cliente.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtém o complemento do endereço residencial do cliente.
     * 
     * @return o complemento do endereço residencial do cliente.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço residencial do cliente.
     * 
     * @param complemento o complemento do endereço residencial do cliente.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Obtém o bairro do cliente.
     * 
     * @return o bairro do cliente.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do cliente.
     * 
     * @param bairro o bairro do cliente.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém a cidade do cliente.
     * 
     * @return a cidade do cliente.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade do cliente.
     * 
     * @param cidade a cidade do cliente.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém a Unidade Federativa (UF) do cliente.
     * 
     * @return a UF do cliente.
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define a Unidade Federativa (UF) do cliente.
     * 
     * @param uf a UF do cliente.
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}