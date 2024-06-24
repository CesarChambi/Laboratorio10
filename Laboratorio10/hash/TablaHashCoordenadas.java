/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author User
 */
public class TablaHashCoordenadas extends HashA<String> {
    public TablaHashCoordenadas(int n) {
        super(n);
    }

    public void insert(Coordenada coord, String valor) {
        int clave = coord.hashCode();
        super.insert(clave, valor);
    }

    public String search(Coordenada coord) {
        int clave = coord.hashCode();
        return super.search(clave);
    }

    public boolean delete(Coordenada coord) {
        int clave = coord.hashCode();
        return super.delete(clave);
    }

}

