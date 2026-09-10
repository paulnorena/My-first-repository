/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clienteslibros;

import Controlador.ControladorCliente;
import Modelo.Cliente;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class ClientesLibros {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        ControladorCliente controlador = new ControladorCliente();
        
        int opcion = 0;
        
        while(opcion != 3){
            System.out.println("=== BIENVENIDO USUARIO A LibrosYMas ===");
            System.out.println("Seleccione una opcion....");
            System.out.println("1. Registrar Un Cliente");
            System.out.println("2. Consultar Clientes Existentes");
            System.out.println("3. Salir");
            
            opcion = entrada.nextInt();
            
            if(opcion == 1){
                System.out.println("Ingrese el ID...");
                int id = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese el nombre...");
                String nombre = entrada.nextLine();
                System.out.println("Ingrese el telefono...");
                int telefono = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la direccion...");
                String direccion = entrada.nextLine();
                System.out.println("Tiene libro prestado? ...");
                boolean tieneLibroEnPrestamo = entrada.nextBoolean();
                
                Cliente cliente = new Cliente(id, nombre, telefono, direccion, tieneLibroEnPrestamo);
                
                boolean agregado = controlador.agregarCliente(cliente);
                
                if(agregado){
                    System.out.println("Cliente agregado exitosamente :)");
                }else{
                    System.out.println("El cliente ya existe con ese ID");
                }
            }
        }
        }
    }

