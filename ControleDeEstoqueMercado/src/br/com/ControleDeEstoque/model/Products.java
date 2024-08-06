/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.model;

/**
 *
 * @author livia
 */
public class Products {
    
    //Atributos
    private int id;
    private String descricao;
    private double preco;
    private int qtde_estoque;
    private Suppliers fornecedor;
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(int qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }

    public Suppliers getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Suppliers fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
