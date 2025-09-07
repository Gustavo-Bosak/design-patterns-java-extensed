package br.com.fiap.patterns.controler;

import br.com.fiap.patterns.model.Imposto;
import br.com.fiap.patterns.view.TelaImposto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Usando design pattern em nível Comportametal -> Strategy
public class ImpostoControler implements ActionListener {
    private Imposto model;
    private TelaImposto tela;

    @Override
    public void actionPerformed(ActionEvent e) {
        model.calcularImposto(tela.getValor());
    }

    public ImpostoControler (Imposto model, TelaImposto tela) {
        this.model = model;
        this.tela = tela;
    }
}
