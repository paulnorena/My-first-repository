/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clasees;
import Controladores.ControladorCliente;
import Controladores.ControladorLibro;
import Controladores.ControladorPrestamo;
import Clasees.Cliente;
import java.util.Scanner;
/**
 *
 * @author jeanp
 */

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoDesarrollo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorLibro controladorLibro = new ControladorLibro();
        ControladorPrestamo controladorPrestamo = new ControladorPrestamo();

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n=== BIENVENIDO USUARIO A LibrosYMas ===");
            System.out.println("Seleccione una opcion....");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Libros");
            System.out.println("3. Registrar Prestamo");
            System.out.println("4. Registrar Devolucion");
            System.out.println("5. Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    menuClientes(entrada, controladorCliente);
                    break;
                case 2:
                    menuLibros(entrada, controladorLibro);
                    break;
                case 3:
                    registrarPrestamo(entrada, controladorCliente, controladorLibro, controladorPrestamo);
                    break;
                case 4:
                    registrarDevolucion(entrada, controladorCliente, controladorLibro, controladorPrestamo);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        entrada.close();
    }

    // ==================== CLIENTES ====================
    private static void menuClientes(Scanner entrada, ControladorCliente controlador) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- GESTION DE CLIENTES ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("0. Volver al menu principal");

            opcion = entrada.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el ID...");
                int id = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese el nombre...");
                String nombre = entrada.nextLine();
                System.out.println("Ingrese el telefono...");
                long telefono = entrada.nextLong();
                entrada.nextLine();
                System.out.println("Ingrese la direccion...");
                String direccion = entrada.nextLine();

                Cliente cliente = new Cliente(id, nombre, telefono, direccion, false);

                boolean agregado = controlador.agregarCliente(cliente);

                if (agregado) {
                    System.out.println("Cliente agregado exitosamente :)");
                } else {
                    System.out.println("El cliente ya existe con ese ID");
                }

            } else if (opcion == 2) {
                System.out.println("Ingrese el ID del cliente: ");
                int idBuscar = entrada.nextInt();

                Cliente clienteEncontrado = controlador.buscarCliente(idBuscar);

                if (clienteEncontrado != null) {
                    System.out.println("ID: " + clienteEncontrado.getId());
                    System.out.println("Nombre: " + clienteEncontrado.getNombre());
                    System.out.println("Telefono: " + clienteEncontrado.getTelefono());
                    System.out.println("Direccion: " + clienteEncontrado.getDireccion());
                    System.out.println("Tiene libro en prestamo: " + (clienteEncontrado.isTieneLibroEnPrestamo() ? "Si" : "No"));
                } else {
                    System.out.println("Cliente no encontrado.");
                }

            } else if (opcion != 0) {
                System.out.println("Opcion invalida.");
            }
        }
    }

    // ==================== LIBROS ====================
    private static void menuLibros(Scanner entrada, ControladorLibro controlador) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- GESTION DE LIBROS ---");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Consultar Libro");
            System.out.println("3. Actualizar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Listar Libros");
            System.out.println("0. Volver al menu principal");

            opcion = entrada.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el ID...");
                int id = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese el titulo...");
                String titulo = entrada.nextLine();
                System.out.println("Ingrese el autor...");
                String autor = entrada.nextLine();
                System.out.println("Ingrese la editorial...");
                String editorial = entrada.nextLine();
                System.out.println("Ingrese el anio de publicacion...");
                int publicacion = entrada.nextInt();

                Libro libro = new Libro(id, titulo, autor, editorial, publicacion, false);

                boolean agregado = controlador.guardar(libro);

                if (agregado) {
                    System.out.println("Libro agregado exitosamente :)");
                } else {
                    System.out.println("El libro ya existe con ese ID");
                }

            } else if (opcion == 2) {
                System.out.println("Ingrese el ID del libro: ");
                int idBuscar = entrada.nextInt();

                Libro libroEncontrado = controlador.buscar(idBuscar);

                if (libroEncontrado != null) {
                    mostrarLibro(libroEncontrado);
                } else {
                    System.out.println("Libro no encontrado.");
                }

            } else if (opcion == 3) {
                System.out.println("Ingrese el ID del libro a actualizar: ");
                int idActualizar = entrada.nextInt();
                entrada.nextLine();

                Libro existente = controlador.buscar(idActualizar);

                if (existente == null) {
                    System.out.println("Libro no encontrado.");
                } else {
                    System.out.println("Ingrese el nuevo titulo...");
                    String titulo = entrada.nextLine();
                    System.out.println("Ingrese el nuevo autor...");
                    String autor = entrada.nextLine();
                    System.out.println("Ingrese la nueva editorial...");
                    String editorial = entrada.nextLine();
                    System.out.println("Ingrese el nuevo anio de publicacion...");
                    int publicacion = entrada.nextInt();

                    Libro libroActualizado = new Libro(idActualizar, titulo, autor, editorial, publicacion, existente.isEstado());
                    controlador.actualizar(libroActualizado);
                    System.out.println("Libro actualizado exitosamente :)");
                }

            } else if (opcion == 4) {
                System.out.println("Ingrese el ID del libro a eliminar: ");
                int idEliminar = entrada.nextInt();

                boolean eliminado = controlador.eliminar(idEliminar);

                if (eliminado) {
                    System.out.println("Libro eliminado exitosamente :)");
                } else {
                    System.out.println("Libro no encontrado.");
                }

            } else if (opcion == 5) {
                ArrayList<Libro> libros = controlador.listarLibros();

                if (libros.isEmpty()) {
                    System.out.println("No hay libros registrados.");
                } else {
                    System.out.println("\n--- LISTA DE LIBROS ---");
                    for (Libro libro : libros) {
                        mostrarLibro(libro);
                        System.out.println("------------------------");
                    }
                }

            } else if (opcion != 0) {
                System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarLibro(Libro libro) {
        System.out.println("ID: " + libro.getIdLibro());
        System.out.println("Titulo: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Editorial: " + libro.getEditorial());
        System.out.println("Publicacion: " + libro.getPublicacion());
        System.out.println("En prestamo: " + (libro.isEstado() ? "Si" : "No"));
    }

    // ==================== PRESTAMOS ====================
    private static void registrarPrestamo(Scanner entrada, ControladorCliente controladorCliente,
            ControladorLibro controladorLibro, ControladorPrestamo controladorPrestamo) {

        System.out.println("\n--- REGISTRAR PRESTAMO ---");
        System.out.println("Ingrese el ID del cliente...");
        int idCliente = entrada.nextInt();
        System.out.println("Ingrese el ID del libro...");
        int idLibro = entrada.nextInt();

        Cliente cliente = controladorCliente.buscarCliente(idCliente);
        Libro libro = controladorLibro.buscar(idLibro);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        Prestamo prestamo = new Prestamo(cliente, libro);
        boolean registrado = controladorPrestamo.registrarPrestamo(prestamo);

        if (registrado) {
            System.out.println("Prestamo registrado exitosamente :)");
        } else {
            System.out.println("No se pudo registrar el prestamo (el cliente ya tiene un libro prestado o el libro no esta disponible).");
        }
    }

    // ==================== DEVOLUCIONES ====================
    private static void registrarDevolucion(Scanner entrada, ControladorCliente controladorCliente,
            ControladorLibro controladorLibro, ControladorPrestamo controladorPrestamo) {

        System.out.println("\n--- REGISTRAR DEVOLUCION ---");
        System.out.println("Ingrese el ID del cliente...");
        int idCliente = entrada.nextInt();
        System.out.println("Ingrese el ID del libro...");
        int idLibro = entrada.nextInt();

        Cliente cliente = controladorCliente.buscarCliente(idCliente);
        Libro libro = controladorLibro.buscar(idLibro);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        boolean devuelto = controladorPrestamo.devolverLibro(libro, cliente);

        if (devuelto) {
            System.out.println("Devolucion registrada exitosamente :)");
        } else {
            System.out.println("No se encontro un prestamo activo con ese cliente y libro.");
        }
    }
}