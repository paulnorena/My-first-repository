/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clasees;

import Controladores.ControladorCliente;
import Controladores.ControladorLibro;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jeanp
 */
public class Prestamo implements Serializable
{
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private Cliente cliente; 
    private Libro libro;

    public Prestamo(Cliente cliente, Libro libro)
    {
        fechaPrestamo = LocalDate.now();
        fechaVencimiento = fechaPrestamo.plusDays(7);
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
    
    public LocalDate getFechaVencimiento(){
        return fechaVencimiento;
    }

    public long calcularDiasRetraso(LocalDate fechaDevolucion){
        if(fechaDevolucion.isAfter(fechaVencimiento)){
            return ChronoUnit.DAYS.between(fechaVencimiento, fechaDevolucion);
        }
        return 0;
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
