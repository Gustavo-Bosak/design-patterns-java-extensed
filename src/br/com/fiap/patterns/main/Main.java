package br.com.fiap.patterns.main;

import br.com.fiap.patterns.controler.ImpostoControler;
import br.com.fiap.patterns.model.Pis;
import br.com.fiap.patterns.view.TelaPis;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Pis model = new Pis();
        TelaPis tela = new TelaPis(model);

        ImpostoControler impostoControler = new ImpostoControler(model, tela);

        tela.addControler(impostoControler);
    }
}
