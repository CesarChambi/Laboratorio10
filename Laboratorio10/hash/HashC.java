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
public class HashC<E extends Comparable<E>>{
    protected class Element{
        int mark;
        Register<E> reg;
        
        public Element(int mark, Register<E> reg){
            this.mark = mark;
            this.reg = reg;
        }
    }
    protected ArrayList<Element> table;
    protected int m;
    
    public HashC(int n){
        this.m = convertirPrimo(n);
        this.table = new ArrayList<Element>(m);
        for(int i = 0; i < m; i++){
            this.table.add(new Element(0, null));
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
    
    private int functionHash(int key){
        return key % m;
    }
    
    private int linearProbing(int dressHash, int key){
        int posInit = dressHash;
        do{
            if (table.get(dressHash).reg == null){
                return dressHash;
            }
            dressHash = (dressHash + 1) % m;
        }while (dressHash != posInit);
        return -1;
    }
    
    public void insert(int key, E reg){
//        int clave = functionHash(key);
//        int clave = cuadrado(key);
        int clave = pliegue(key);
        int posicion = linearProbing(clave, key);
        if(posicion == -1){
            System.out.println("No se logro insertar");
            return;
        }
        this.table.set(posicion, new Element(1, new Register<>(key, reg)));
    }
    
    public E search(int key){
        int clave = functionHash(key);
        int posInit = clave;
        do{
            if (table.get(clave).reg != null){
                if(table.get(clave).reg.getKey() == key){
                    return table.get(clave).reg.getValue();
                }
            }
            clave = (clave + 1) % m;
        }while (clave != posInit || (table.get(clave).reg == null && table.get(clave).mark == 0));
        return null;
    }

    @Override
    public String toString() {
        String s = "D.real\tD.Hash\tRegister\n";
        int i = 0;
        for(Element item : table){
            s += (i++) + " -->\t";
            if(item.mark == 1){
                s += functionHash(item.reg.getKey()) + "\t" + item.reg + "\n";
            }else{
                s += "empty\n";
            }
        }
        return s;
    }
    
    public int cuadrado(int key){ 
        int potencia = key * key;
        String comprobar = String.valueOf(potencia);
        String tamano = String.valueOf(m);
        for(int i = comprobar.length(); i < tamano.length() * String.valueOf(m).length(); i++){
            comprobar = "0" + comprobar;
        }
        int posicion = (comprobar.length() / tamano.length()) - (String.valueOf(m).length() / tamano.length());
        String valor = comprobar.substring(posicion, posicion + String.valueOf(m).length());
        int clave = Integer.parseInt(valor);
        return clave % m;
    }
        
    public int pliegue(int key){
        int suma = 0;
        String clave = String.valueOf(key);
        int tamano = clave.length();
        String numero = String.valueOf(m);
        int cantidad = Integer.parseInt(numero);
        for(int i = 0; i < clave.length(); i += tamano){
            int fin = Math.min(i + tamano, clave.length());
            String parte = clave.substring(i, fin);
            try {
                suma += Integer.parseInt(parte);
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir parte de la clave a entero: '" + parte + "'");
                e.printStackTrace();
            }
        }
        return suma % m;
    }

    private int cuadratica(int dressHash, int key){
        int posInit = dressHash;
        int colision = 0;
        do{
            if (table.get(dressHash).reg == null){
                return dressHash;
            }
            colision++;
            dressHash = (dressHash + (colision*colision)) % m;
//            dressHash = Math.pow(dressHash, colision) % m;
        }while (dressHash != posInit);
        return -1;
    }
}
