package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDoblementeEnlazadaTest {

    ListaDoblementeEnlazada listaDoblementeEnlazada;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        this.listaDoblementeEnlazada = new ListaDoblementeEnlazada();
    }

    @Test
    public void verificarListaInicialTest(){
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),0);
    }

    @Test
    public void agregarNodoALaListaTest(){
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),0);
        listaDoblementeEnlazada.agregarNodo(1);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),1);
        assertEquals(listaDoblementeEnlazada.obtenerPrimerNodo().getValorNodo(),1);
        assertEquals(listaDoblementeEnlazada.obtenerUltimoNodo().getValorNodo(),1);
    }

    @Test
    public void agregarMasDeUnNodoALaListaTest(){
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),0);
        listaDoblementeEnlazada.agregarNodo(1);
        listaDoblementeEnlazada.agregarNodo(8);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),2);
        assertEquals(listaDoblementeEnlazada.obtenerPrimerNodo().getValorNodo(),1);
        assertEquals(listaDoblementeEnlazada.obtenerPrimerNodo().getNodoSiguiente().getValorNodo(),8);
        assertEquals(listaDoblementeEnlazada.obtenerUltimoNodo().getValorNodo(),8);
    }

    @Test
    public void eliminarPrimerNodoTest(){
        listaDoblementeEnlazada.agregarNodo(1);
        listaDoblementeEnlazada.agregarNodo(8);
        listaDoblementeEnlazada.agregarNodo(50);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),3);
        listaDoblementeEnlazada.eliminarNodo(1);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),2);
        // El segundo nodo de valor 8 pasa a ser el primero
        assertEquals(listaDoblementeEnlazada.obtenerPrimerNodo().getValorNodo(),8);
    }

    @Test
    public void eliminarUltimoNodoTest(){
        listaDoblementeEnlazada.agregarNodo(1);
        listaDoblementeEnlazada.agregarNodo(8);
        listaDoblementeEnlazada.agregarNodo(50);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),3);
        listaDoblementeEnlazada.eliminarNodo(3);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),2);
        // El segundo nodo de valor 8 pasa a ser el ultimo
        assertEquals(listaDoblementeEnlazada.obtenerUltimoNodo().getValorNodo(),8);
    }

    @Test
    public void actualizarNodoTest(){
        listaDoblementeEnlazada.agregarNodo(5);
        listaDoblementeEnlazada.agregarNodo(10);
        listaDoblementeEnlazada.actualizarNodo(2,99);
        assertEquals(listaDoblementeEnlazada.obtenerPrimerNodo().getValorNodo(),5);
        assertEquals(listaDoblementeEnlazada.obtenerUltimoNodo().getValorNodo(),99);
        assertEquals(listaDoblementeEnlazada.getCantidadNodos(),2);
    }

    @Test
    public void obtenerNodoITest(){
        listaDoblementeEnlazada.agregarNodo(5);
        listaDoblementeEnlazada.agregarNodo(10);
        NodoListaDoblementeEnlazada nodo = listaDoblementeEnlazada.obenerNodoI(2);
        assertEquals(nodo.getValorNodo(),10);
        assertEquals(listaDoblementeEnlazada.obtenerUltimoNodo(),nodo);
    }

    @Test
    public void posicionInvalidaTest(){
        listaDoblementeEnlazada.agregarNodo(5);
        System.setOut(new PrintStream(outputStreamCaptor));
        String outputEsperado = "###############################\r\n" +
                                "# Posicion Ingresada inválida #\r\n" +
                                "###############################";

        NodoListaDoblementeEnlazada nodo = listaDoblementeEnlazada.obenerNodoI(2);
        String outputString = outputStreamCaptor.toString().trim();
        assertEquals(outputEsperado, outputString);
    }

    @Test
    public void mostrarListaVaciaTest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        listaDoblementeEnlazada.mostrarLista();
        String outputEsperado = "---> Lista Vacia";

        String outputString = outputStreamCaptor.toString().trim();
        assertEquals(outputEsperado, outputString);
    }

    @Test
    public void mostrarListaConVariosElementosTest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        listaDoblementeEnlazada.agregarNodo(5);
        listaDoblementeEnlazada.agregarNodo(10);
        listaDoblementeEnlazada.mostrarLista();
        String outputEsperado = "- Nodo 1 <5> || - Nodo 2 <10> ||";

        String outputString = outputStreamCaptor.toString().trim();
        assertEquals(outputEsperado, outputString);
    }

    @Test
    public void mostrarListaInvertidaTest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        listaDoblementeEnlazada.agregarNodo(5);
        listaDoblementeEnlazada.agregarNodo(10);
        listaDoblementeEnlazada.mostrarListaInvertida();
        String outputEsperado = "- Nodo 2 <10> || - Nodo 1 <5> ||";

        String outputString = outputStreamCaptor.toString().trim();
        assertEquals(outputEsperado, outputString);
    }

    @Test
    public void mostrarListaConVariosElementosDesdePosITest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        listaDoblementeEnlazada.agregarNodo(5);
        listaDoblementeEnlazada.agregarNodo(10);
        listaDoblementeEnlazada.agregarNodo(20);
        listaDoblementeEnlazada.mostrarListaDesdePosI(2);
        String outputEsperado = "- Nodo 2 <10> || - Nodo 3 <20> ||";

        String outputString = outputStreamCaptor.toString().trim();
        assertEquals(outputEsperado, outputString);
    }
}
