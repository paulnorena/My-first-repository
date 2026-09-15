/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

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
    
}
