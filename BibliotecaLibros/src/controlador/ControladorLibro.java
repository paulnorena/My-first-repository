package controlador;

import modelo.Libro;
import java.util.ArrayList;

public class ControladorLibro {
    
    private ArrayList<Libro> inventarioLibros;

    public ControladorLibro() {
        this.inventarioLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro nuevoLibro) {
        this.inventarioLibros.add(nuevoLibro);
    }

    public void listarLibros() {
        for (Libro libro : inventarioLibros) {
            libro.mostrarInformacion();
            System.out.println("-----------------------------");
        }
    }
    
    public ArrayList<Libro> getInventarioLibros() {
        return inventarioLibros;
    }
}