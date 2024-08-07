/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.model;

/**
 *
 * @author livia
 */
public class SalesItens {
    //Atributos
    private int id;
    private Sales venda;
    private Products produtos;
    private int qtd;
    private double subtotal;
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sales getVenda() {
        return venda;
    }

    public void setVenda(Sales venda) {
        this.venda = venda;
    }

    public Products getProdutos() {
        return produtos;
    }

    public void setProdutos(Products produtos) {
        this.produtos = produtos;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}
