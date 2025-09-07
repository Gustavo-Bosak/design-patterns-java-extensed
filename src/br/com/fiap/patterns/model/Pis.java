package br.com.fiap.patterns.model;

// Usando design pattern de nível Comportamental -> Property listener (versão atualizada do obsoleto observer)
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pis implements Imposto {
    private float aliquota = 0.06f;
    private float valorPis;
    private PropertyChangeSupport support;

    public Pis() {
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