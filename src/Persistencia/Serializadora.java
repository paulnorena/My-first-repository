/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Juan
 */
public class Serializadora {
    
    public static void guardar(Object objeto, String ruta) {

        try {
            ObjectOutputStream salida = new ObjectOutputStream(
                    new FileOutputStream(ruta)
            );

            salida.writeObject(objeto);
            salida.close();

        } catch (IOException e) {
            System.out.println("Error al guardar los datos: "
                    + e.getMessage());
        }
    }

    public static Object cargar(String ruta) {

        try {
            ObjectInputStream entrada = new ObjectInputStream(
                    new FileInputStream(ruta)
            );

            Object objeto = entrada.readObject();
            entrada.close();

            return objeto;

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
