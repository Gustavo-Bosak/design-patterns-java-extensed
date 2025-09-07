package br.com.fiap.patterns.model;

// Usando design pattern de nível Comportamental -> Property listener (versão atualizada do obsoleto observer)
import br.com.fiap.patterns.config.ConfigSingleton;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class Pis implements Imposto {
    private float aliquota = Float.parseFloat(ConfigSingleton.getInstance().getProperty("aliquota"));
    private float valorPis;
    private PropertyChangeSupport support;

    public Pis() throws IOException {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void calcularImposto(float valor) {
        float valorPisAnterior = this.valorPis;
        this.valorPis = valor * aliquota;

        if (valorPisAnterior != valorPis) {
            support.firePropertyChange("valorPis", valorPisAnterior, valorPis);
        }
    }

    public float getValorPis() {
        return valorPis;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}