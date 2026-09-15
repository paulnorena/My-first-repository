/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author jeanp
 */
import Clasees.Cliente;
import Clasees.Libro;
import Clasees.Prestamo;
import java.util.ArrayList;

public class ControladorPrestamo 
{
    private ArrayList<Prestamo> prestamos;

    public ControladorPrestamo()
    {
        prestamos = new ArrayList<>();
    }

    public boolean registrarPrestamo(Prestamo p)
    {
        if(p.validarPrestamo())
        {
            prestamos.add(p);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro, Cliente cliente)
    {
        for(int i = 0; i < prestamos.size(); i++)
        {
            Prestamo p = prestamos.get(i);
            if(p.getLibro().getIdLibro() == libro.getIdLibro() && p.getCliente() == cliente)
            {
                libro.setEstado(false);
                cliente.setTieneLibroEnPrestamo(false);
                prestamos.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Prestamo> listarPrestamos()
    {
        return prestamos;
    }

    public ArrayList<Prestamo> prestamosPorCliente(Cliente cliente)
    {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for(int i = 0; i < prestamos.size(); i++)
        {
            if(prestamos.get(i).getCliente() == cliente)
            {
                resultado.add(prestamos.get(i));
            }
        }
        return resultado;
    }
}
