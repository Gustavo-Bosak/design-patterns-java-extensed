package br.com.fiap.patterns.view;

import br.com.fiap.patterns.model.Pis;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// Usando design pattern em nível Estrutural -> Composite
public class TelaPis implements TelaImposto, PropertyChangeListener {
    private TextField txtValor;
    private Button botaoCalcular;
    private Pis pis;

    public TelaPis (Pis pis) {
        this.pis = pis;
        this.pis.addPropertyChangeListener(this);

        Frame frame = new Frame("CALCULO DE IMPOSTO PIS");
        frame.add("North", new Label("Valor para calcular: "));

        txtValor = new TextField();
        frame.add("Center", txtValor);

        Panel panel = new Panel();
        botaoCalcular = new Button();
        botaoCalcular.addActionListener(e -> calcularImposto());
        panel.add(botaoCalcular);
        frame.add("South", panel);
        frame.addWindowListener(new CloseListener());
        frame.setSize(200, 150);
        frame.setLocation(100,100);
        frame.setVisible(true);
    }

    @Override
    public float getValor() {
        return Float.parseFloat(txtValor.getText());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("valorPis".equals(evt.getPropertyName())) {
            txtValor.setText("Valor do Imposto PIS: " + evt.getNewValue());
        }
    }

    private void calcularImposto() {
        float valor = getValor();
        pis.calcularImposto(valor);
    }

    public static class CloseListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }

    }
}
