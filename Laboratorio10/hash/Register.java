/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Miguel
 */
public class Register<E> implements Comparable<Register<E>>{
    protected int key;
    protected E value;

    public Register(int key, E value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public int compareTo(Register<E> r) {
        return this.key - r.key;
    }
    
    public boolean equals(Object o){
        if(o instanceof Register){
            Register<E> r = (Register<E>)o;
            return r.key == this.key;
        }
        return false;
    }
    
    public int getKey(){
        return this.key;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.key + ": " + this.value.toString();
    }
}
