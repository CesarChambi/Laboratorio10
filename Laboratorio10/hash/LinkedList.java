/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Miguel
 */
public class LinkedList<T> {
    protected Node<T> first;
    protected Node<T> aux;

    public LinkedList() {
        this.first = null;
        this.aux = null;
    }

    public boolean isEmptyList() {
        return first == null;
    }

    public int length() {
        int cont = 0;
        aux = first;
        while (aux != null) {
            aux = aux.getNext();
            cont++;
        }
        return cont;
    }

    public void destroyList() {
        while (first != null) {
            aux = first;
            first = first.getNext();
            aux.setNext(null);
        }
    }

    public int search(T x) {
        int val = 0;
        aux = first;
        while (aux != null) {
            if (aux.getData().equals(x)) {
                return val;
            }
            aux = aux.getNext();
            val++;
        }
        return -1;
    }

    public void insertFirst(T x) {
        Node<T> nodito = new Node<T>(x);
        nodito.setNext(first);
        first = nodito;
    }

    public void insertLast(T x) {
        if (first == null) {
            Node<T> nodito = new Node<T>(x);
            first = nodito;
        } else {
            aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            Node<T> nodito = new Node<T>(x);
            aux.setNext(nodito);
        }
    }

    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }
    
    public void removeNode(T x) {
        if (first != null && first.getData().equals(x)) {
            first = first.getNext();
            return;
        }

        aux = first;
        while (aux != null && aux.getNext() != null) {
            if (aux.getNext().getData().equals(x)) {
                aux.setNext(aux.getNext().getNext());
            }
            aux = aux.getNext();
        }
    }

    public void deleteDuplicates() {
        aux = first;
        while (aux != null && aux.getNext() != null) {
            if (aux.getData().equals(aux.getNext().getData())) {
                aux.setNext(aux.getNext().getNext());
            } else {
                aux = aux.getNext();
            }
        }
    }

    public void deleteNth(int x) {
        aux = first;
        int pos = 0;
        if (x == 0) {
            first = first.getNext();
        } else {
            while (aux != null && aux.getNext() != null) {
                if (pos == x - 1) {
                    aux.setNext(aux.getNext().getNext());
                }
                aux = aux.getNext();
                pos++;
            }
        }
    }

    public void insertNth(T x, int pos) {
        if (pos == 0) {
            insertFirst(x);
        } else {
            int cont = 0;
            aux = first;
            while (aux != null && cont < pos - 1) {
                aux = aux.getNext();
                cont++;
            }
            if (aux == null) {
                System.out.println("Fuera de rango");
            } else {
                Node<T> nodito = new Node<>(x);
                nodito.setNext(aux.getNext());
                aux.setNext(nodito);
            }
        }
    }

    public void eliminarAlternados() {
        aux = first.getNext();
        if (aux == null) {
            return;
        }

        while (aux != null && aux.getNext() != null) {
            aux.setNext(aux.getNext().getNext());
            aux = aux.getNext();
        }
    }

    public void eliminarAlternados2() {
        aux = first;
        Node<T> anterior = null;

        while (aux != null && aux.getNext() != null) {
            Node<T> nodoAEliminar = aux.getNext();
            aux.setNext(nodoAEliminar.getNext());

            anterior = aux;
            aux = aux.getNext();
        }

        if (aux != null && aux.getNext() == null && anterior != null) {
            anterior.setNext(null);
        }
    }

    public void print() {
        aux = first;
        while (aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" + "first=" + first + ", aux=" + aux + '}';
    }
}
