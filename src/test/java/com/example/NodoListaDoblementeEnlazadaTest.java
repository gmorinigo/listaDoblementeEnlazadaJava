package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodoListaDoblementeEnlazadaTest {
    NodoListaDoblementeEnlazada nodoLista;

    @BeforeEach
    public void setUp(){
        this.nodoLista = new NodoListaDoblementeEnlazada(null, null, 1);
    }

    @Test
    public void verificarNodoInicialTest(){
        assertFalse(nodoLista.hayNodoAnterior());
        assertFalse(nodoLista.haySiguienteNodo());
        assertEquals(nodoLista.getValorNodo(),1);
        assertEquals(nodoLista.getNodoSiguiente(),null);
        assertEquals(nodoLista.getNodoAnterior(),null);
    }

    @Test
    public void verificarCambioDeValor(){
        assertEquals(nodoLista.getValorNodo(),1);
        nodoLista.setValorNodo(8);
        assertEquals(nodoLista.getValorNodo(),8);
    }

    @Test
    public void verificarAgregadoDeNodo(){
        NodoListaDoblementeEnlazada segundoNodo = new NodoListaDoblementeEnlazada(null, null, 2);
        assertNull(nodoLista.getNodoSiguiente());
        nodoLista.setNodoSiguiente(segundoNodo);
        assertNull(segundoNodo.getNodoAnterior());
        segundoNodo.setNodoAnterior(nodoLista);
        assertNotNull(segundoNodo.getNodoAnterior());
        assertNotNull(nodoLista.getNodoSiguiente());
        assertEquals(nodoLista.getNodoSiguiente().getValorNodo(),segundoNodo.getValorNodo());
        assertEquals(nodoLista.getNodoSiguiente(),segundoNodo);
    }

    @Test
    public void verificarAgregadoDeNodos(){
        NodoListaDoblementeEnlazada segundoNodo = new NodoListaDoblementeEnlazada(nodoLista, null, 2);
        NodoListaDoblementeEnlazada tercerNodo = new NodoListaDoblementeEnlazada(segundoNodo, null, 2);
        segundoNodo.setNodoSiguiente(tercerNodo);
        assertNull(tercerNodo.getNodoSiguiente());
        assertNotNull(segundoNodo.getNodoSiguiente());
        assertEquals(segundoNodo.getNodoSiguiente().getValorNodo(),tercerNodo.getValorNodo());
        assertEquals(segundoNodo.getNodoSiguiente(),tercerNodo);
    }
}
