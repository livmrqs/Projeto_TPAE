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
 * Representa um item de venda no sistema de controle de estoque.
 * 
 * A classe {@code SalesItens} contém informações sobre um item específico de uma venda,
 * incluindo a venda associada, o produto, a quantidade e o subtotal do item.
 * 
 * @author livia
 */
public class SalesItens {
    
    /** Identificador único do item de venda. */
    private int id;
    
    /** Venda à qual o item pertence. */
    private Sales venda;
    
    /** Produto associado ao item de venda. */
    private Products produtos;
    
    /** Quantidade do produto no item de venda. */
    private int qtd;
    
    /** Subtotal do item de venda (quantidade multiplicada pelo preço do produto). */
    private double subtotal;
    
    /**
     * Obtém o identificador do item de venda.
     * 
     * @return o identificador do item de venda.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do item de venda.
     * 
     * @param id o identificador do item de venda.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a venda à qual o item pertence.
     * 
     * @return a venda associada ao item.
     */
    public Sales getVenda() {
        return venda;
    }

    /**
     * Define a venda à qual o item pertence.
     * 
     * @param venda a venda associada ao item.
     */
    public void setVenda(Sales venda) {
        this.venda = venda;
    }

    /**
     * Obtém o produto associado ao item de venda.
     * 
     * @return o produto associado ao item.
     */
    public Products getProdutos() {
        return produtos;
    }

    /**
     * Define o produto associado ao item de venda.
     * 
     * @param produtos o produto associado ao item.
     */
    public void setProdutos(Products produtos) {
        this.produtos = produtos;
    }

    /**
     * Obtém a quantidade do produto no item de venda.
     * 
     * @return a quantidade do produto.
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * Define a quantidade do produto no item de venda.
     * 
     * @param qtd a quantidade do produto.
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * Obtém o subtotal do item de venda.
     * 
     * O subtotal é calculado como a quantidade do produto multiplicada pelo preço do produto.
     * 
     * @return o subtotal do item de venda.
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Define o subtotal do item de venda.
     * 
     * @param subtotal o subtotal do item de venda.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
