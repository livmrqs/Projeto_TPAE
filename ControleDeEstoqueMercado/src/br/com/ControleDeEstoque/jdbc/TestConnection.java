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
package br.com.ControleDeEstoque.jdbc;

import javax.swing.JOptionPane;

/**
 * Classe de teste para verificar a conexão com o banco de dados.
 * 
 * Esta classe é utilizada para testar a capacidade de estabelecer uma conexão
 * com o banco de dados utilizando a classe {@link ConnectionFactory}. Ao ser
 * executada, ela tenta abrir uma conexão e exibe uma mensagem de sucesso ou erro
 * utilizando caixas de diálogo {@link JOptionPane}.
 * 
 * @author livia
 */
public class TestConnection {
    /**
     * Método principal que executa o teste de conexão com o banco de dados.
     * 
     * Este método cria uma instância da {@link ConnectionFactory} e tenta
     * obter uma conexão com o banco de dados. Se a conexão for bem-sucedida,
     * uma caixa de diálogo é exibida informando o sucesso. Caso ocorra um erro
     * ao tentar estabelecer a conexão, uma caixa de diálogo é exibida com a
     * mensagem de erro.
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     */
     public static void main(String[] args) {
         
         try {
             new ConnectionFactory().getConnection();
             JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
             
         } catch (Exception erro) {
             JOptionPane.showMessageDialog(null, "Ops, aconteceu o erro:" + erro);
         }
     }
}
