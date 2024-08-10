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
 * Representa um fornecedor no sistema de controle de estoque.
 * 
 * A classe {@code Suppliers} herda de {@code Clientes} e adiciona um atributo específico para fornecedores,
 * que é o CNPJ. Além disso, sobrescreve o método {@code toString()} para retornar o nome do fornecedor.
 * 
 * @author livia
 */
public class Suppliers extends Clientes {
    
    /** CNPJ do fornecedor. */
    private String cnpj;
   
    /**
     * Obtém o CNPJ do fornecedor.
     * 
     * @return o CNPJ do fornecedor.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ do fornecedor.
     * 
     * @param cnpj o CNPJ do fornecedor.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    /**
     * Retorna uma representação em string do fornecedor.
     * 
     * O método sobrescrito {@code toString()} retorna o nome do fornecedor.
     * 
     * @return o nome do fornecedor.
     */
    @Override
    public String toString(){
        return this.getNome();
    }
}
