package bibliotecalibros;

import controlador.ControladorLibro;
import modelo.Libro;

public class BibliotecaLibros {

   
    public static void main(String[] args) {

        ControladorLibro controlador = new ControladorLibro();

        Libro[] librosNuevos = {
            new Libro("L001", "Carlos el parcero", "Gabriel García Márquez", "Sudamericana", 1967, "Literatura"),
            new Libro("C001", "Biologia", "Mauricio", "Crítica", 1988, "Ciencia"),
            new Libro("H001", "Historia de colombia", "El mono", "Debate", 2011, "Historia"),
            new Libro("T001", "Aprender Java", "Paul", "Prentice Hall", 2008, "Tecnología")
        };

        for (int i = 0; i < librosNuevos.length; i++) {
            controlador.agregarLibro(librosNuevos[i]);
        }

        librosNuevos[1].cambiarEstado("Prestado");
        librosNuevos[3].cambiarEstado("Retirado");

        controlador.listarLibros();
    }
}
