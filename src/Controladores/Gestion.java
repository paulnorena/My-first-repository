/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clasees.Prestamo;
import java.util.ArrayList;

/**
 *
 * @author jeanp
 */
public class Gestion
{
    private ArrayList<Prestamo> listaPrestamos;

    public Gestion()
    {
        listaPrestamos = new ArrayList<>();
    }
    
    public boolean verificarPrestamo(Prestamo p)
    {
        if(p.getLibro())
        {
            
        }
        return false;
    }
    
}
