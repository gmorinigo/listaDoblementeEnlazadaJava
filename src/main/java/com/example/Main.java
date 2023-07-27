package com.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    /*
     Programa para utilizar la lista doblemente enlazada
     */
    public static void main(String[] args) {
        ListaDoblementeEnlazada listaDoblementeEnlazada = new ListaDoblementeEnlazada();
        String opcionIngresada = "";
        Scanner scanner = new Scanner(System.in);
        // Solo sale del programa en caso de ingresar una letra S
        while (!opcionIngresada.toUpperCase(Locale.ROOT).equals("S")){
            // Se muestra el menú y se guarda la opción ingresada
            opcionIngresada = mostrarMenu();
            // Se evalua la opción ingresada
            switch (opcionIngresada.toUpperCase(Locale.ROOT)){
                case "1":
                    listaDoblementeEnlazada.mostrarLista(); break;
                case "2":
                    agregarNodo(listaDoblementeEnlazada, scanner); break;
                case "3":
                    eliminarNodo(listaDoblementeEnlazada, scanner); break;
                case "4":
                    actualizarNodo(listaDoblementeEnlazada, scanner); break;
                case "5":
                    consultaNodoPuntual(listaDoblementeEnlazada, scanner); break;
                case "6":
                    listaDoblementeEnlazada.mostrarListaInvertida(); break;
                case "7":
                    mostrarListaDesdePosicionI(listaDoblementeEnlazada, scanner); break;
                case "S":
                    break;
                default:
                    mostrarErrorOpcionIngresadaInvalida();
            }
        }
    }

    /*
     Se agrega un nodo con el valor ingresado
     */
    private static void agregarNodo(ListaDoblementeEnlazada listaDoblementeEnlazada, Scanner scanner) {
        int valorNodo;
        System.out.println("Ingrese el valor del nodo a crear");
        valorNodo = scanner.nextInt();
        listaDoblementeEnlazada.agregarNodo(valorNodo);
        listaDoblementeEnlazada.mostrarLista();
    }

    /*
     Se elimina el nodo de la posicion ingresada
     */
    private static void eliminarNodo(ListaDoblementeEnlazada listaDoblementeEnlazada, Scanner scanner) {
        int posicion;
        System.out.println("Ingrese la posicion del nodo a eliminar");
        posicion = scanner.nextInt();
        listaDoblementeEnlazada.eliminarNodo(posicion);
        listaDoblementeEnlazada.mostrarLista();
    }

    /*
     Se actualiza el valor del nodo de la posicion, con el valor ingresado
     */
    private static void actualizarNodo(ListaDoblementeEnlazada listaDoblementeEnlazada, Scanner scanner) {
        int valorNodo;
        int posicion;
        System.out.println("Ingrese la posicion del nodo a modificar");
        posicion = scanner.nextInt();
        System.out.println("Ingrese el nuevo valor del nodo");
        valorNodo = scanner.nextInt();
        listaDoblementeEnlazada.actualizarNodo(posicion, valorNodo);
        listaDoblementeEnlazada.mostrarLista();
    }

    /*
     Se consulta el nodo de la posición ingresada
     */
    private static void consultaNodoPuntual(ListaDoblementeEnlazada listaDoblementeEnlazada, Scanner scanner) {
        int posicion;
        System.out.println("Ingrese la posicion del nodo a consultar");
        posicion = scanner.nextInt();
        NodoListaDoblementeEnlazada nodo = listaDoblementeEnlazada.obenerNodoI(posicion);
        if (nodo != null) System.out.println("- Nodo " + posicion + " <" + nodo.getValorNodo() + "> || ");
        System.out.println(" ");
    }

    /*
     Se muestra la lista desde la posición ingresada
     */
    private static void mostrarListaDesdePosicionI(ListaDoblementeEnlazada listaDoblementeEnlazada, Scanner scanner) {
        System.out.println("Ingrese la posicion del nodo a consultar");
        int posicion = scanner.nextInt();
        listaDoblementeEnlazada.mostrarListaDesdePosI(posicion);
    }

    /*
     Se muestra el menú de opciones
     */
    public static String mostrarMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese la opcion deseada");
        System.out.println("1 - Ver Lista");
        System.out.println("2 - Agregar Nodo");
        System.out.println("3 - Eliminar Nodo");
        System.out.println("4 - Modificar Nodo");
        System.out.println("5 - Consulta Nodo Puntual");
        System.out.println("6 - Consulta Lista Invertida");
        System.out.println("7 - Consulta Lista Desde Posición Puntual");
        System.out.println("S - Salir");
        System.out.println("Por favor ingrese la opcion deseada");
        String opcionIngresada = scanner.next();
        return opcionIngresada;
    }

    private static void mostrarErrorOpcionIngresadaInvalida() {
        System.out.println(" ");
        System.out.println("#############################");
        System.out.println("# Opcion Ingresada inválida #");
        System.out.println("#############################");
        System.out.println(" ");
    }
}
