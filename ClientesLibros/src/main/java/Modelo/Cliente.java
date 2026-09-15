/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Juan
 */
public class Cliente {
    private int id;
    private String nombre;
    private long telefono;
    private String direccion;
    private boolean tieneLibroEnPrestamo;

    public Cliente(int id, String nombre, long telefono, String direccion, boolean tieneLibroEnPrestamo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tieneLibroEnPrestamo = tieneLibroEnPrestamo;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) { No lo necesitamos debido a que el ID nunca se modifica
//        this.id = id;
//    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isTieneLibroEnPrestamo() {
        return tieneLibroEnPrestamo;
    }

    public void setTieneLibroEnPrestamo(boolean tieneLibroEnPrestamo) {
        this.tieneLibroEnPrestamo = tieneLibroEnPrestamo;
    }

    
    
}
