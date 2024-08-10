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
 * Representa uma venda no sistema de controle de estoque.
 * 
 * A classe {@code Sales} contém informações sobre uma venda, incluindo o cliente
 * associado, a data da venda, o total da venda e observações adicionais.
 * 
 * @author livia
 */
public class Sales {
    
    /** Identificador único da venda. */
    private int id;
    
    /** Cliente associado à venda. */
    private Clientes cliente;
    
    /** Data em que a venda foi realizada. */
    private String data_venda;
    
    /** Valor total da venda. */
    private double total_venda;
    
    /** Observações adicionais sobre a venda. */
    private String obs;
    
    /**
     * Obtém o identificador da venda.
     * 
     * @return o identificador da venda.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da venda.
     * 
     * @param id o identificador da venda.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o cliente associado à venda.
     * 
     * @return o cliente associado à venda.
     */
    public Clientes getCliente() {
        return cliente;
    }

    /**
     * Define o cliente associado à venda.
     * 
     * @param cliente o cliente associado à venda.
     */
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém a data em que a venda foi realizada.
     * 
     * @return a data da venda.
     */
    public String getData_venda() {
        return data_venda;
    }

    /**
     * Define a data em que a venda foi realizada.
     * 
     * @param data_venda a data da venda.
     */
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    /**
     * Obtém o valor total da venda.
     * 
     * @return o valor total da venda.
     */
    public double getTotal_venda() {
        return total_venda;
    }

    /**
     * Define o valor total da venda.
     * 
     * @param total_venda o valor total da venda.
     */
    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    /**
     * Obtém as observações adicionais sobre a venda.
     * 
     * @return as observações adicionais sobre a venda.
     */
    public String getObs() {
        return obs;
    }

    /**
     * Define as observações adicionais sobre a venda.
     * 
     * @param obs as observações adicionais sobre a venda.
     */
    public void setObs(String obs) {
        this.obs = obs;
    }
}

