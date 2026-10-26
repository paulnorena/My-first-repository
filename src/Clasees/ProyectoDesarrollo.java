/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clasees;
import Controladores.ControladorCliente;
import Controladores.ControladorLibro;
import Controladores.ControladorPrestamo;
import Clasees.Cliente;
import Persistencia.DatosBiblioteca;
import Persistencia.GestorPersistencia;
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

       DatosBiblioteca datos = GestorPersistencia.cargar();

        ControladorCliente controladorCliente = new ControladorCliente(datos.getClientes());

        ControladorLibro controladorLibro = new ControladorLibro(datos.getLibros());

        ControladorPrestamo controladorPrestamo = new ControladorPrestamo(datos.getPrestamos(),datos.getHistorial());

        int opcion = 0;

        while (opcion != 9) {
            System.out.println("\n=== BIENVENIDO USUARIO A LibrosYMas ===");
            System.out.println("Seleccione una opcion....");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Libros");
            System.out.println("3. Registrar Prestamo");
            System.out.println("4. Registrar Devolucion");
            System.out.println("5. Registrar Reserva");
            System.out.println("6. Consultar Reservas de un Libro");
            System.out.println("7. Consultar Multas de un Cliente");
            System.out.println("8. Reporte General");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");           

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                   menuClientes(
                    entrada,
                    controladorCliente,
                    controladorLibro,
                    controladorPrestamo
    );
                    break;
                case 2:
                     menuLibros(
                    entrada,
                    controladorLibro,
                    controladorCliente,
                    controladorPrestamo
    );
                    break;
                case 3:
                    registrarPrestamo(entrada, controladorCliente, controladorLibro, controladorPrestamo);
                    break;
                case 4:
                    registrarDevolucion(entrada, controladorCliente, controladorLibro, controladorPrestamo);
                    break;
               case 5:
                    registrarReserva(
                    entrada,
                    controladorCliente,
                    controladorLibro,
                    controladorPrestamo
                    );
                    break;

               case 6:
                    consultarReservas(entrada, controladorLibro);
                    break;

               case 7:
                    consultarMultas(entrada, controladorCliente);
                    break;

               case 8:
                    reporteGeneral(controladorCliente, controladorLibro, controladorPrestamo);
                    break;

                case 9:
                      DatosBiblioteca datosFinales = new DatosBiblioteca(
                        controladorCliente.listarClientes(),
                        controladorLibro.listarLibros(),
                        controladorPrestamo.listarPrestamos(),
                        controladorPrestamo.listarHistorial()
                      );

                        GestorPersistencia.guardar(datosFinales);

                        System.out.println("Datos guardados correctamente.");
                        System.out.println("Saliendo del sistema...");
                    break;
            }
        }

        entrada.close();
    }

    // ==================== CLIENTES ====================
    private static void menuClientes(Scanner entrada, ControladorCliente controlador,ControladorLibro controladorLibro,ControladorPrestamo controladorPrestamo) {
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
                     guardarDatos(
                    controlador,
                    controladorLibro,
                    controladorPrestamo
    );

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
    private static void menuLibros(Scanner entrada, ControladorLibro controlador,ControladorCliente controladorCliente,ControladorPrestamo controladorPrestamo) {
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
                     guardarDatos(
                     controladorCliente,
                     controlador,
                     controladorPrestamo
            );

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
                   boolean actualizado = controlador.actualizar(libroActualizado);

                   if (actualizado) {

                    guardarDatos(
                    controladorCliente,
                    controlador,
                    controladorPrestamo
                    );

                    System.out.println("Libro actualizado exitosamente :)");

                    } else {
                        System.out.println("No se pudo actualizar el libro.");
                        }
                }

            } else if (opcion == 4) {
                System.out.println("Ingrese el ID del libro a eliminar: ");
                int idEliminar = entrada.nextInt();

                boolean eliminado = controlador.eliminar(idEliminar);

                if (eliminado) {

                guardarDatos(
                controladorCliente,
                controlador,
                controladorPrestamo
                );

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
            guardarDatos(
            controladorCliente,
            controladorLibro,
            controladorPrestamo
    );

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

    guardarDatos(
            controladorCliente,
            controladorLibro,
            controladorPrestamo
    );

    System.out.println("Devolucion registrada exitosamente :)");

    System.out.println("Multa de esta devolucion: $"
            + controladorPrestamo.getUltimaMulta());

        Cliente siguiente = controladorPrestamo.getSiguienteClienteReserva();

        if (siguiente != null) {
            System.out.println("Siguiente cliente en la fila de reservas: "
                + siguiente.getNombre());
        } else {
            System.out.println("No hay clientes esperando este libro.");
        }

        } else {
            System.out.println("No se encontro un prestamo activo con ese cliente y libro.");
         }
    }
    
    public static void registrarReserva(
        Scanner entrada,
        ControladorCliente controladorCliente,
        ControladorLibro controladorLibro,ControladorPrestamo controladorPrestamo) {

    System.out.print("Ingrese el ID del cliente: ");
    int idCliente = entrada.nextInt();

    System.out.print("Ingrese el ID del libro: ");
    int idLibro = entrada.nextInt();

    Cliente cliente = controladorCliente.buscarCliente(idCliente);

    if (cliente == null) {
        System.out.println("El cliente no existe.");
        return;
    }

    boolean registrada =
            controladorLibro.registrarReserva(idLibro, cliente);

    if (registrada) {

    guardarDatos(
            controladorCliente,
            controladorLibro,
            controladorPrestamo
    );

    System.out.println("Reserva registrada exitosamente.");

} else {
    System.out.println("No se pudo registrar la reserva.");
}
}
    
    public static void consultarReservas(
        Scanner entrada,
        ControladorLibro controladorLibro) {

    System.out.print("Ingrese el ID del libro: ");
    int idLibro = entrada.nextInt();

    Libro libro = controladorLibro.buscar(idLibro);

    if (libro == null) {
        System.out.println("El libro no existe.");
        return;
    }

    ArrayList<Cliente> reservas =
            controladorLibro.consultarReservas(idLibro);

    if (reservas.isEmpty()) {
        System.out.println("Este libro no tiene reservas.");
    } else {
        System.out.println("Reservas del libro: " + libro.getTitulo());

        for (int i = 0; i < reservas.size(); i++) {
            System.out.println(
                    (i + 1) + ". ID: " + reservas.get(i).getId()
                    + " - Cliente: " + reservas.get(i).getNombre()
            );
        }
    }
}
   public static void consultarMultas(
        Scanner entrada,
        ControladorCliente controladorCliente) {

    System.out.print("Ingrese el ID del cliente: ");
    int idCliente = entrada.nextInt();

    Cliente cliente = controladorCliente.buscarCliente(idCliente);

    if (cliente == null) {
        System.out.println("El cliente no existe.");
        return;
    }

    double multa = controladorCliente.consultarMultasPendientes(idCliente);

    System.out.println("Cliente: " + cliente.getNombre());
    System.out.println("Multas pendientes: $" + multa);
}
   
   
public static void reporteGeneral(
        ControladorCliente controladorCliente,
        ControladorLibro controladorLibro,
        ControladorPrestamo controladorPrestamo) {

    ArrayList<Cliente> clientes =
            controladorCliente.listarClientes();

    ArrayList<Libro> libros =
            controladorLibro.listarLibros();

    ArrayList<Prestamo> activos =
            controladorPrestamo.listarPrestamos();

    ArrayList<Prestamo> historial =
            controladorPrestamo.listarHistorial();

    System.out.println("\n===== REPORTE GENERAL =====");

    System.out.println("Total de libros: " + libros.size());
    System.out.println("Total de clientes: " + clientes.size());
    System.out.println("Prestamos activos: " + activos.size());
    System.out.println("Prestamos historicos: " + historial.size());

    // Buscar el cliente con mas prestamos.
    Cliente clienteMayor = null;
    int mayorCantidad = 0;

    for (int i = 0; i < clientes.size(); i++) {

        Cliente cliente = clientes.get(i);

        int cantidad =
                controladorPrestamo.prestamosPorCliente(cliente).size()
                + controladorPrestamo.historialPorCliente(cliente).size();

        if (cantidad > mayorCantidad) {
            mayorCantidad = cantidad;
            clienteMayor = cliente;
        }
    }

    if (clienteMayor != null && mayorCantidad > 0) {
        System.out.println("Cliente con mas prestamos: "
                + clienteMayor.getNombre()
                + " (" + mayorCantidad + " prestamos)");
    } else {
        System.out.println("Cliente con mas prestamos: Sin datos");
    }

    // Buscar el libro menos solicitado.
    Libro libroMenosSolicitado = null;
    int menorCantidad = Integer.MAX_VALUE;

    for (int i = 0; i < libros.size(); i++) {

        Libro libro = libros.get(i);
        int cantidad = 0;

        for (int j = 0; j < activos.size(); j++) {
            if (activos.get(j).getLibro().getIdLibro()
                    == libro.getIdLibro()) {
                cantidad++;
            }
        }

        for (int j = 0; j < historial.size(); j++) {
            if (historial.get(j).getLibro().getIdLibro()
                    == libro.getIdLibro()) {
                cantidad++;
            }
        }

        if (cantidad < menorCantidad) {
            menorCantidad = cantidad;
            libroMenosSolicitado = libro;
        }
    }

    if (libroMenosSolicitado != null) {
        System.out.println("Libro menos solicitado: "
                + libroMenosSolicitado.getTitulo()
                + " (" + menorCantidad + " prestamos)");
    } else {
        System.out.println("Libro menos solicitado: Sin libros registrados");
    }

    System.out.println("============================");
}


public static void guardarDatos(
        ControladorCliente controladorCliente,
        ControladorLibro controladorLibro,
        ControladorPrestamo controladorPrestamo) {

    DatosBiblioteca datos = new DatosBiblioteca(
            controladorCliente.listarClientes(),
            controladorLibro.listarLibros(),
            controladorPrestamo.listarPrestamos(),
            controladorPrestamo.listarHistorial()
    );

    GestorPersistencia.guardar(datos);
}


    
}