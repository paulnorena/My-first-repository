/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clasees;

import Controladores.ControladorCliente;
import Controladores.ControladorLibro;
import java.time.LocalDate;

/**
 *
 * @author jeanp
 */
public class Prestamo 
{
    private LocalDate fechaPrestamo;
    private Cliente cliente; 
    private Libro libro;

    public Prestamo(Cliente cliente, Libro libro)
    {
        fechaPrestamo = LocalDate.now();
        this.cliente = cliente;
        this.libro = libro;
    }

    public boolean validarPrestamo()
    {
        if(cliente.isTieneLibroEnPrestamo() == false && libro.isEstado() == false)
        {
            cliente.setTieneLibroEnPrestamo(true);
            libro.setEstado(true);
            return true;
        }
        return false;
    }

    public LocalDate getFechaPrestamo()
    {
        return fechaPrestamo;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public Libro getLibro()
    {
        return libro;
    }
}
