/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Clasees.Cliente;
import Clasees.Libro;
import Clasees.Prestamo;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class GestorPersistencia {
    private static final String RUTA = "biblioteca.dat";

    public static DatosBiblioteca cargar() {

        Object objeto = Serializadora.cargar(RUTA);

        if (objeto instanceof DatosBiblioteca) {
            return (DatosBiblioteca) objeto;
        }

        
        return new DatosBiblioteca(
                new ArrayList<Cliente>(),
                new ArrayList<Libro>(),
                new ArrayList<Prestamo>(),
                new ArrayList<Prestamo>()
        );
    }

    public static void guardar(DatosBiblioteca datos) {
        Serializadora.guardar(datos, RUTA);
    }
}
