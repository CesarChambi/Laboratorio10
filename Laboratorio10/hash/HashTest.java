/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class HashTest {
    public static void main(String[] args) {
//        System.out.println("HASH CERRADO");
//        HashC<String> hashC = new HashC<>(11);
//        hashC.insert(34, "Miguel");
//        hashC.insert(3, "Fidel");
//        hashC.insert(7, "Carlos");
//        hashC.insert(30, "Cesar");
//        hashC.insert(11, "Joaquin");
//        hashC.insert(8, "Frank");
//        hashC.insert(7, "Shannen");
//        hashC.insert(23, "Martha");
//        hashC.insert(41, "Claudia");
//        hashC.insert(16, "Mirella");
//        hashC.insert(34, "Erika");
//        System.out.println(hashC.toString());
//        System.out.println("-- Search: " + hashC.search(34));
//        
//        System.out.println("");
//        
//        System.out.println("HASH ABIERTO");
//        HashA<String> hashA = new HashA<>(7);
//        hashA.insert(34, "Miguel");
//        hashA.insert(3, "Fidel");
//        hashA.insert(7, "Carlos");
//        hashA.insert(30, "Cesar");
//        hashA.insert(11, "Joaquin");
//        hashA.insert(8, "Frank");
//        hashA.insert(7, "Shannen");
//        hashA.insert(23, "Martha");
//        hashA.insert(41, "Claudia");
//        hashA.insert(16, "Mirella");
//        hashA.insert(34, "Erika");
//        System.out.println(hashA.toString());
//        
//        System.out.println("-- Search: " + hashA.search(41));
////        
////        System.out.println("");
////        
//        
//        String ruta = "C:\\Users\\User\\OneDrive\\Documentos\\NetBeansProjects\\Lab-10\\empleado.txt";
//        
//        System.out.println("EJERCICIO 2");
//        try (BufferedReader leer = new BufferedReader(new FileReader(ruta))) {
//            String linea = leer.readLine();
//            int cantidadElementos = Integer.parseInt(linea.trim());
//            double cantidadHash = cantidadElementos * 1.4;
//            int cantidadFinal = (int) Math.round(cantidadHash);
//            
//            HashC<Empleado> hashEmpleados = new HashC<>(cantidadFinal);
//            
//            for (int i = 0; i < cantidadElementos; i++) {
//                linea = leer.readLine();
//                if(linea != null){
//                    String[] partes = linea.split(",");
//                    int key = Integer.parseInt(partes[0].trim());
//                    String nombre = partes[1].trim();
//                    String direccion = partes[2].trim();
//                    Empleado cerrado = new Empleado(nombre, direccion);
//                    hashEmpleados.insert(key, cerrado);
//                }
//            }
//            System.out.println(hashEmpleados.toString());
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("");
//        
//        System.out.println("EJERCICIO 3");
//        try (BufferedReader leer = new BufferedReader(new FileReader(ruta))) {
//            String linea = leer.readLine();
//            int cantidadElementos = Integer.parseInt(linea.trim());
//            
//            HashA<Empleado> hashEmpleados = new HashA<>(cantidadElementos);
//            
//            for (int i = 0; i < cantidadElementos; i++) {
//                linea = leer.readLine();
//                if(linea != null){
//                    String[] partes = linea.split(",");
//                    int key = Integer.parseInt(partes[0].trim());
//                    String nombre = partes[1].trim();
//                    String direccion = partes[2].trim();
//                    Empleado abierto = new Empleado(nombre, direccion);
//                    hashEmpleados.insert(key, abierto);
//                }
//            }
//            System.out.println(hashEmpleados.toString());
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        // Ejercicio 4
//        System.out.println("EJERCICIO 4");
//
//        String texto = "hola mundo hola adios mundo mundo mundo";
//        String[] palabras = texto.split(" ");
//        System.out.println("Texto: " + texto);
//        TablaHashFrecuencia tabla = new TablaHashFrecuencia(10);
//        for (String palabra : palabras) {
//            tabla.insert(palabra);
//        }
//
//        System.out.println("Frecuencia de 'hola': " + tabla.frecuencia("hola")); 
//        System.out.println("Frecuencia de 'mundo': " + tabla.frecuencia("mundo")); 
//        System.out.println("Frecuencia de 'adios': " + tabla.frecuencia("adios")); 
//
//        System.out.println("");
//
//        // Ejercicio 5
//        System.out.println("EJERCICIO 5");
//
//        int[] array = {1, 2, 3, 4, 5};
//        int sum = 7;
//        System.out.print("Array: ");
//        for (int num : array) {
//            System.out.print(num + " ");
//        }
//        System.out.println("\nSuma objetivo: " + sum);
//
//        TablaHashSuma hashTable = new TablaHashSuma(10);
//        ArrayList<int[]> pairs = hashTable.findPairs(array, sum);
//
//        System.out.println("Pares: ");
//        for (int[] pair : pairs) {
//            System.out.println(pair[0] + ", " + pair[1]);
//        }
//        
//        System.out.println("");

        // Ejercicio 6
        System.out.println("EJERCICIO 6");
        TablaHashCoordenadas tablaCoordenda = new TablaHashCoordenadas(10);
        Coordenada coodenada1 = new Coordenada(1, 2);
        Coordenada coodenada2 = new Coordenada(3, 4);
        
        tablaCoordenda.insert(coodenada1, "valor1");
        tablaCoordenda.insert(coodenada2, "valor2");
        
        System.out.println(tablaCoordenda.search(coodenada1)); 
        System.out.println(tablaCoordenda.search(coodenada2));
        
        System.out.println(tablaCoordenda.delete(coodenada1)); 
        System.out.println(tablaCoordenda.search(coodenada1)); 
    }
}
