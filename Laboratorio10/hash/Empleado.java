/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Miguel
 */
public class Empleado implements Comparable<Empleado>{
    private String nombre;
    private String direccion;

    public Empleado(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int compareTo(Empleado o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "Empleado{" + " Nombre: " + nombre + ", Direccion: " + direccion + '}';
    }
    
    
}
