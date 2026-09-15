/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clasees;

/**
 *
 * @author jeanp
 */
public class Libro 
{
    private int idLibro;
    private String titulo;
    private String autor;
    private String editorial;
    private int publicacion;
    private String[] categoria = {"Literatura", "Ciencia", "Historia", "Tecnologia"};
    private boolean estado;

    public Libro(int idLibro, String titulo, String autor, String editorial, int publicacion, boolean estado) 
    {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.publicacion = publicacion;
        this.estado = estado;
    }

    public int getIdLibro() 
    {
        return idLibro;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) 
    {
        this.autor = autor;
    }

    public String getEditorial() 
    {
        return editorial;
    }

    public void setEditorial(String editorial) 
    {
        this.editorial = editorial;
    }

    public int getPublicacion() 
    {
        return publicacion;
    }

    public void setPublicacion(int publicacion) 
    {
        this.publicacion = publicacion;
    }

    public String[] getCategoria() 
    {
        return categoria;
    }

    public void setCategoria(String categoria[]) 
    {
        this.categoria = categoria;
    }

    public boolean isEstado() 
    {
        return estado;
    }

    public void setEstado(boolean estado) 
    {
        this.estado = estado;
    }
    
    
    
}
