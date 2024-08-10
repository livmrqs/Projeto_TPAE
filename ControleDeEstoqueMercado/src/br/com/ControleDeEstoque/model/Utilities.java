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

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe utilitária contendo métodos para auxiliar nas operações da aplicação.
 * 
 * A classe {@code Utilities} fornece métodos que facilitam operações comuns, como limpar campos de texto
 * em um painel. Atualmente, inclui um método para limpar todos os campos de texto em um painel específico.
 * 
 * @author livia
 */
public class Utilities {

    /**
     * Limpa todos os campos de texto em um painel especificado.
     * 
     * O método percorre todos os componentes do painel e, se o componente for uma instância de {@code JTextField},
     * o texto é removido, definindo-o como {@code null}.
     * 
     * @param container o painel ({@code JPanel}) cujo campos de texto serão limpos.
     */
    public void limpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
}


