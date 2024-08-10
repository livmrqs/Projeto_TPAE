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
 * Representa um produto no sistema de controle de estoque.
 * 
 * A classe {@code Products} contém informações sobre um produto, incluindo
 * sua descrição, preço, quantidade em estoque e o fornecedor associado.
 * 
 * @author livia
 */
public class Products {
    
    /** Identificador único do produto. */
    private int id;
    
    /** Descrição do produto. */
    private String descricao;
    
    /** Preço do produto. */
    private double preco;
    
    /** Quantidade de unidades do produto em estoque. */
    private int qtd_estoque;
    
    /** Fornecedor do produto. */
    private Suppliers fornecedor;
    
    /**
     * Obtém o identificador do produto.
     * 
     * @return o identificador do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do produto.
     * 
     * @param id o identificador do produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a descrição do produto.
     * 
     * @return a descrição do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     * 
     * @param descricao a descrição do produto.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o preço do produto.
     * 
     * @return o preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     * 
     * @param preco o preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém a quantidade de unidades do produto em estoque.
     * 
     * @return a quantidade de unidades em estoque.
     */
    public int getQtd_estoque() {
        return qtd_estoque;
    }

    /**
     * Define a quantidade de unidades do produto em estoque.
     * 
     * @param qtd_estoque a quantidade de unidades em estoque.
     */
    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    /**
     * Obtém o fornecedor do produto.
     * 
     * @return o fornecedor do produto.
     */
    public Suppliers getFornecedor() {
        return fornecedor;
    }

    /**
     * Define o fornecedor do produto.
     * 
     * @param fornecedor o fornecedor do produto.
     */
    public void setFornecedor(Suppliers fornecedor) {
        this.fornecedor = fornecedor;
    }
}
