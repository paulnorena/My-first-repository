/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clasees.Cliente;
import Clasees.Libro;
import java.util.ArrayList;

/**
 *
 * @author jeanp
 */
public class ControladorLibro 
{
    private ArrayList<Libro> libros;
    
    public ControladorLibro()
    {
        libros = new ArrayList<>();
    }
    
    public ControladorLibro(ArrayList<Libro> libros) {
    this.libros = libros;
}
    
    public Libro buscar(int id)
    {
        for(int i = 0; i < libros.size(); i++)
        {
            if(libros.get(i).getIdLibro() == id)
            {
                return libros.get(i);
            }
        }
        return null;
    }
    public ArrayList<Libro> listarLibros()
    {
        return libros;
    }
    
    public boolean guardar(Libro l)
    {
        if(buscar(l.getIdLibro()) != null)
        {
            return false;
        }
        libros.add(l);
        return true;
    }
    
    public boolean actualizar(Libro l)
    {
        Libro aux = buscar(l.getIdLibro());
        if(aux != null)
        {
            aux.setAutor(l.getAutor());
            aux.setCategoria(l.getCategoria());
            aux.setEditorial(l.getEditorial());
            aux.setEstado(l.isEstado());
            aux.setPublicacion(l.getPublicacion());
            aux.setTitulo(l.getTitulo());
            return true;
        }
        return false;
    }
    
    public boolean eliminar(int id)
    {
        Libro l = buscar(id);
        if(l != null)
        {
            libros.remove(l);
            return true;
        }
        return false;
    }
    
    
public boolean registrarReserva(int idLibro, Cliente cliente)
{
    Libro libro = buscar(idLibro);

    if(libro == null || cliente == null)
    {
        return false;
    }
    if(libro.isEstado() == false)
    {
        return false;
    }
    for(int i = 0; i < libro.getReservas().size(); i++)
    {
        if(libro.getReservas().get(i).getId() == cliente.getId())
        {
            return false;
        }
    }

    libro.getReservas().add(cliente);
    return true;
}

public ArrayList<Cliente> consultarReservas(int idLibro)
{
    Libro libro = buscar(idLibro);

    if(libro != null)
    {
        return libro.getReservas();
    }

    return new ArrayList<>();
}

    
}
