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
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorPrestamo
{
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Prestamo> historial;

    private static final double MULTA_POR_DIA = 1000;
    
    private double ultimaMulta;
    private Cliente siguienteClienteReserva;

    public ControladorPrestamo()
    {
        prestamos = new ArrayList<>();
        historial = new ArrayList<>();
        ultimaMulta = 0;
        siguienteClienteReserva = null;
    }
    
    public ControladorPrestamo(
        ArrayList<Prestamo> prestamos,
        ArrayList<Prestamo> historial) {

    this.prestamos = prestamos;
    this.historial = historial;
}

    public boolean registrarPrestamo(Prestamo p)
    {
        Libro libro = p.getLibro();
        Cliente cliente = p.getCliente();

        
        if(!libro.getReservas().isEmpty())
        {
            Cliente primero = libro.getReservas().get(0);

            if(primero.getId() != cliente.getId())
            {
                return false;
            }
        }

        if(p.validarPrestamo())
        {
            prestamos.add(p);

            
            if(!libro.getReservas().isEmpty())
            {
                if(libro.getReservas().get(0).getId() == cliente.getId())
                {
                    libro.getReservas().remove(0);
                }
            }

            return true;
        }

        return false;
    }

    public boolean devolverLibro(Libro libro, Cliente cliente)
    {
        for(int i = 0; i < prestamos.size(); i++)
        {
            Prestamo p = prestamos.get(i);

            if(p.getLibro().getIdLibro() == libro.getIdLibro()
                    && p.getCliente().getId() == cliente.getId())
            {
                
                long diasRetraso = p.calcularDiasRetraso(LocalDate.now());

                
                ultimaMulta = diasRetraso * MULTA_POR_DIA;

                cliente.setMultasPendientes(
                    cliente.getMultasPendientes() + ultimaMulta
                );

                
                libro.setEstado(false);
                cliente.setTieneLibroEnPrestamo(false);

                
                historial.add(p);
                prestamos.remove(i);

                
                if(!libro.getReservas().isEmpty())
                {
                    siguienteClienteReserva = libro.getReservas().get(0);
                }
                else
                {
                    siguienteClienteReserva = null;
                }

                return true;
            }
        }

        return false;
    }

    public double getUltimaMulta()
    {
        return ultimaMulta;
    }

    public Cliente getSiguienteClienteReserva()
    {
        return siguienteClienteReserva;
    }

    public ArrayList<Prestamo> listarPrestamos()
    {
        return prestamos;
    }

    public ArrayList<Prestamo> listarHistorial()
    {
        return historial;
    }

    public ArrayList<Prestamo> prestamosPorCliente(Cliente cliente)
    {
        ArrayList<Prestamo> resultado = new ArrayList<>();

        for(int i = 0; i < prestamos.size(); i++)
        {
            if(prestamos.get(i).getCliente().getId() == cliente.getId())
            {
                resultado.add(prestamos.get(i));
            }
        }

        return resultado;
    }

    public ArrayList<Prestamo> historialPorCliente(Cliente cliente)
    {
        ArrayList<Prestamo> resultado = new ArrayList<>();

        for(int i = 0; i < historial.size(); i++)
        {
            if(historial.get(i).getCliente().getId() == cliente.getId())
            {
                resultado.add(historial.get(i));
            }
        }

        return resultado;
    }
}