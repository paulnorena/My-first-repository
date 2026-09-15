/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clasees;

import java.time.LocalDate;

/**
 *
 * @author jeanp
 */
public class Prestamo 
{
    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private Cliente cliente; 
    private Libro libro;

    public Prestamo(int idPrestamo, LocalDate fechaPrestamo, Cliente cliente, Libro libro)
    {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.cliente = cliente;
        this.libro = libro;
    }

    public int getIdPrestamo() 
    {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) 
    {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaPrestamo() 
    {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) 
    {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Libro getLibro()
    {
        return libro;
    }

    public void setLibro(Libro libro)
    {
        this.libro = libro;
    }
}
