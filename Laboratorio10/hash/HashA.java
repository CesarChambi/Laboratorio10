/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class HashA<E extends Comparable<E>>{
    protected class Element{
        Register<E> reg;
        LinkedList<Register<E>> list;
        public Element(Register<E> reg){
            this.reg = reg;
            this.list = new LinkedList<Register<E>>();
        }
    }
    
    protected ArrayList<Element> table;
    protected int m;
    
    public HashA(int n){
        this.m = convertirPrimo(n);
        this.table = new ArrayList<Element>(m);
        for (int i = 0; i < m; i++){
            this.table.add(new Element(null));
        }
    }
    
    private int convertirPrimo(int numero){
        int primo = numero + 1;
        while (!esPrimo(primo)) {
            primo++;
        }
        return primo;
    }
    
    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    protected int functionHash(int key){
        return key % m;
    }
    
    public void insert(int key, E value){
        Register<E> nuevo = new Register<E>(key, value);
        int dressHash = functionHash(key);
        this.table.get(dressHash).list.insertFirst(nuevo);
    }

    public E search(int key) {
        int hashIndex = functionHash(key);
        LinkedList<Register<E>> list = table.get(hashIndex).list;

        for (Node<Register<E>> node = list.first; node != null; node = node.getNext()) {
            if (node.getData().getKey() == key) {
                return node.getData().value;
            }
        }
        return null;
    }
    
    public boolean delete(int key) {
        int hashIndex = functionHash(key);
        LinkedList<Register<E>> list = table.get(hashIndex).list;

        Node<Register<E>> previous = null;
        Node<Register<E>> current = list.first;

        while (current != null) {
            if (current.getData().getKey() == key) {
                if (previous == null) {
                    list.first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }




    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("D.Hash\tLista\n");
        for (int i = 0; i < m; i++) {
            Element element = table.get(i);
            str.append(functionHash(i)).append("\t");

            if (element.list.isEmptyList()) {
                str.append("null\t\t");
            }

            Node<Register<E>> aux = element.list.first;
            while (aux != null) {
                str.append(aux.getData().toString());
                aux = aux.getNext();
                if (aux != null) {
                    str.append(" --> ");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }
}
