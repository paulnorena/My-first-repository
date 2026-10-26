/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Clasees.Cliente;
import Clasees.Libro;
import Clasees.Prestamo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class DatosBiblioteca implements Serializable{
     private ArrayList<Cliente> clientes;
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Prestamo> historial;

    public DatosBiblioteca(
            ArrayList<Cliente> clientes,
            ArrayList<Libro> libros,
            ArrayList<Prestamo> prestamos,
            ArrayList<Prestamo> historial) {

        this.clientes = clientes;
        this.libros = libros;
        this.prestamos = prestamos;
        this.historial = historial;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<Prestamo> getHistorial() {
        return historial;
    }
}
