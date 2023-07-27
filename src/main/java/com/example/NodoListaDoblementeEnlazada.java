package com.example;

public class NodoListaDoblementeEnlazada {
    NodoListaDoblementeEnlazada nodoAnterior;
    NodoListaDoblementeEnlazada nodoSiguiente;
    int valorNodo;

    public NodoListaDoblementeEnlazada(NodoListaDoblementeEnlazada nodoAnterior, NodoListaDoblementeEnlazada nodoSiguiente, int valorNodo) {
        this.nodoAnterior = nodoAnterior;
        this.nodoSiguiente = nodoSiguiente;
        this.valorNodo = valorNodo;
    }

    public boolean haySiguienteNodo (){
        return nodoSiguiente != null;
    }

    public boolean hayNodoAnterior() {
        return nodoAnterior != null;
    }

    public NodoListaDoblementeEnlazada getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(NodoListaDoblementeEnlazada nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public NodoListaDoblementeEnlazada getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(NodoListaDoblementeEnlazada nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    public int getValorNodo() {
        return valorNodo;
    }

    public void setValorNodo(int valorNodo) {
        this.valorNodo = valorNodo;
    }

}
