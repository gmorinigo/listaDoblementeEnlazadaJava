package com.example;

public class ListaDoblementeEnlazada {
    NodoListaDoblementeEnlazada primerNodo;
    NodoListaDoblementeEnlazada ultimoNodo;
    int cantidadNodos;

    public ListaDoblementeEnlazada() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.cantidadNodos = 0;
    }

    /*
     Se muestra la lista actual. Si no hay elementos se envía un mensaje indicando que la lista está vacia
     */
    public void mostrarLista() {
        if (this.cantidadNodos == 0) mostrarListaVacia();
        else {
            NodoListaDoblementeEnlazada nodoActual = primerNodo;
            int posicionNodo = 1;
            System.out.print("- Nodo " + posicionNodo + " <" + nodoActual.getValorNodo() + "> || ");
            // Mientras hay un nodo siguiente, se lo muestra en la salida
            while (nodoActual.haySiguienteNodo()){
                posicionNodo++;
                nodoActual = nodoActual.getNodoSiguiente();
                System.out.print("- Nodo " + posicionNodo + " <" + nodoActual.getValorNodo() + "> || ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    /*
    Se muestra la lista actual en forma invertida. Si no hay elementos se envía un mensaje indicando que la lista está vacia
    */
    public void mostrarListaInvertida() {
        if (this.cantidadNodos == 0) mostrarListaVacia();
        else {
            NodoListaDoblementeEnlazada nodoActual = ultimoNodo;
            int posicionNodo = cantidadNodos;
            System.out.print("- Nodo " + posicionNodo + " <" + nodoActual.getValorNodo() + "> || ");
            // Mientras hay un nodo anterior, se lo muestra en la salida
            while (nodoActual.hayNodoAnterior()){
                posicionNodo--;
                nodoActual = nodoActual.getNodoAnterior();
                System.out.print("- Nodo " + posicionNodo + " <" + nodoActual.getValorNodo() + "> || ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public void mostrarListaVacia(){
        System.out.println(" ");
        System.out.println("---> Lista Vacia");
        System.out.println(" ");
    }

    /*
    Se agrega un nuevo nodo a la lista. Si la lista estaba vacía, el nuevo nodo es el primero y último
    Si la lista no estaba vacia se agrega el nuevo y el que estaba último pasa a tener referencia de siguiente al nuevo nodo
    */
    public void agregarNodo (int valorNodo){
        NodoListaDoblementeEnlazada nodoNuevo;
        if (this.cantidadNodos == 0) {
            nodoNuevo = new NodoListaDoblementeEnlazada(null, null, valorNodo);
            this.primerNodo=nodoNuevo;
            this.ultimoNodo=nodoNuevo;
        }
        else{
            nodoNuevo = new NodoListaDoblementeEnlazada(this.ultimoNodo, null, valorNodo);
            this.ultimoNodo.setNodoSiguiente(nodoNuevo);
            this.ultimoNodo = nodoNuevo;
        }
        this.cantidadNodos++;
    }

    /*
    Se elimina el nodo indicado en la posición
    Si la posición no existe, se envía un mensaje de error
    Si la posición exite, se recorre la lista hasta encontrar la posición y se cambian las referencias de los nodos anterior y siguiente
    */
    public void eliminarNodo(int posicion) {
        if (posicion > this.cantidadNodos) mostrarErrorPosicionIngresadaInvalida();
        else {
            int posNodoActual = 1;
            NodoListaDoblementeEnlazada nodoActual = primerNodo;
            while (posNodoActual != posicion){
                posNodoActual++;
                nodoActual = nodoActual.getNodoSiguiente();
            }
            if (posicion == 1)
                this.primerNodo = nodoActual.getNodoSiguiente();
            if (posicion == this.cantidadNodos)
                this.ultimoNodo = nodoActual.getNodoAnterior();
            if (nodoActual.hayNodoAnterior())
                nodoActual.getNodoAnterior().setNodoSiguiente(nodoActual.getNodoSiguiente());
            if (nodoActual.haySiguienteNodo())
                nodoActual.getNodoSiguiente().setNodoAnterior(nodoActual.getNodoAnterior());
            cantidadNodos--;
        }
    }

    private static void mostrarErrorPosicionIngresadaInvalida() {
        System.out.println(" ");
        System.out.println("###############################");
        System.out.println("# Posicion Ingresada inválida #");
        System.out.println("###############################");
        System.out.println(" ");
    }

    public void actualizarNodo(int posicion, int valorNodo) {
        if (posicion > this.cantidadNodos) mostrarErrorPosicionIngresadaInvalida();
        else {
            int posNodoActual = 1;
            NodoListaDoblementeEnlazada nodoActual = primerNodo;
            while (posNodoActual != posicion){
                posNodoActual++;
                nodoActual = nodoActual.getNodoSiguiente();
            }
            nodoActual.setValorNodo(valorNodo);
        }
    }

    public NodoListaDoblementeEnlazada obenerNodoI(int posicion) {
        NodoListaDoblementeEnlazada nodo = null;
        if (posicion > this.cantidadNodos) mostrarErrorPosicionIngresadaInvalida();
        else {
            int posNodoActual = 1;
            NodoListaDoblementeEnlazada nodoActual = primerNodo;
            while (posNodoActual != posicion){
                posNodoActual++;
                nodoActual = nodoActual.getNodoSiguiente();
            }
            nodo = nodoActual;
        }
        return nodo;
    }

    public NodoListaDoblementeEnlazada obtenerPrimerNodo() {
        return primerNodo;
    }

    public NodoListaDoblementeEnlazada obtenerUltimoNodo() {
        return ultimoNodo;
    }

    public int getCantidadNodos() {return cantidadNodos;}

    public void mostrarListaDesdePosI(int posicion) {
        NodoListaDoblementeEnlazada nodoActual = this.obenerNodoI(posicion);
        System.out.print("- Nodo " + posicion + " <" + nodoActual.getValorNodo() + "> || ");
        while (nodoActual.haySiguienteNodo()){
            posicion++;
            nodoActual = nodoActual.getNodoSiguiente();
            System.out.print("- Nodo " + posicion + " <" + nodoActual.getValorNodo() + "> || ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }
}
