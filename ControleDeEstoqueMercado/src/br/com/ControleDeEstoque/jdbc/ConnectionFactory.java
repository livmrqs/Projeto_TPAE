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

import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * 
 * Esta classe fornece um método para obter uma conexão com o banco de dados
 * MySQL utilizado pelo sistema de controle de estoque.
 * 
 * @author livia
 */
public class ConnectionFactory {
   
    /**
     * Obtém uma conexão com o banco de dados.
     * 
     * Este método cria uma nova conexão com o banco de dados MySQL localizado
     * no endereço "jdbc:mysql://127.0.0.1/bdestoque" utilizando as credenciais 
     * fornecidas ("usuarioteste" e "123").
     * 
     * @return Uma instância de {@link Connection} conectada ao banco de dados.
     * @throws RuntimeException Se ocorrer um erro ao tentar estabelecer a conexão com o banco de dados.
     */
    
   public Connection getConnection(){
       try {
           
           return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdestoque", "usuarioteste", "123");
           
       } catch (Exception erro) {
           throw new RuntimeException(erro);
       }
       
   }
}
