/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ControleDeEstoque.dao;

import br.com.ControleDeEstoque.jdbc.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author livia
 */
public class SalesDAO {
    private Connection con;

    public SalesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
}
