/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Miguel
 */
public class TablaHashFrecuencia extends HashA<String> {

    public TablaHashFrecuencia(int n) {
        super(n);
    }

    @Override
    public void insert(int clave, String palabra) {
        int direccionHash = functionHash(clave);
        LinkedList<Register<String>> lista = this.table.get(direccionHash).list;

        for (Node<Register<String>> nodo = lista.first; nodo != null; nodo = nodo.getNext()) {
            Register<String> registro = nodo.getData();
            if (registro.getKey() == clave && registro.getValue().startsWith(palabra)) {
                String[] partes = registro.getValue().split(":");
                String palabraExistente = partes[0];
                int frecuencia = Integer.parseInt(partes[1]);
                frecuencia++;
                registro.setValue(palabraExistente + ":" + frecuencia);
                return;
            }
        }
        lista.insertFirst(new Register<>(clave, palabra + ":1"));
    }

    public void insert(String palabra) {
        int clave = palabra.hashCode();
        insert(clave, palabra);
    }

    public int frecuencia(String palabra) {
        int clave = palabra.hashCode();
        int direccionHash = functionHash(clave);
        LinkedList<Register<String>> lista = this.table.get(direccionHash).list;

        for (Node<Register<String>> nodo = lista.first; nodo != null; nodo = nodo.getNext()) {
            Register<String> registro = nodo.getData();
            if (registro.getKey() == clave && registro.getValue().startsWith(palabra)) {
                String[] partes = registro.getValue().split(":");
                return Integer.parseInt(partes[1]);
            }
        }
        return 0;
    }
}
