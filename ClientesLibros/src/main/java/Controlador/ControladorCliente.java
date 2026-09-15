/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class ControladorCliente {
    
        private ArrayList<Cliente> listaClientes;
    
    public ControladorCliente(){
        listaClientes = new ArrayList<>();
    }
    
    // ====== CRUD =======
    
    // CREATE
    
    public boolean agregarCliente (Cliente cliente){
        if(buscarCliente(cliente.getId()) != null ){
            return false;
        }else{
            listaClientes.add(cliente);
            return true;
        }
    }
    
    // READ 
    
    public Cliente buscarCliente(int id){
        for(int i = 0; i < listaClientes.size(); i +=1){
            if(listaClientes.get(i).getId() == id){
                return listaClientes.get(i);
            }
        }return null;
    }
    
    // UPDATE 
    
    public boolean actualizarCliente(Cliente cliente){
        Cliente prueba = buscarCliente(cliente.getId());
        if(prueba != null){
            prueba.setNombre(cliente.getNombre());
            prueba.setDireccion(cliente.getDireccion());
            prueba.setTelefono(cliente.getTelefono());
            prueba.setTieneLibroEnPrestamo(cliente.isTieneLibroEnPrestamo());
            return true;
        }else{
            return false;
        }
    }
    
     // DELETE 

    public boolean eliminarCliente(int id){
        for(int i = 0; i < listaClientes.size(); i +=1){
            if(listaClientes.get(i).getId() == id){
                return true;
            }
        }return false;
    }
    
    
    
    
}

   
