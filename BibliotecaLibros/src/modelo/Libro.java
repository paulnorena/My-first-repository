package modelo;

public class Libro {
    
    private String identificadorUnico;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private String categoria;
    private String estado;

    public Libro(String identificadorUnico, String titulo, String autor, String editorial, int anioPublicacion, String categoria) {
        this.identificadorUnico = identificadorUnico;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        
        if (categoria.equalsIgnoreCase("Literatura") || 
            categoria.equalsIgnoreCase("Ciencia") || 
            categoria.equalsIgnoreCase("Historia") || 
            categoria.equalsIgnoreCase("Tecnología")) {
            this.categoria = categoria;
        } else {
            this.categoria = "Literatura"; 
        }
        
        this.estado = "Disponible"; 
    }

    public void cambiarEstado(String nuevoEstado) {
        if (nuevoEstado.equalsIgnoreCase("Disponible") || 
            nuevoEstado.equalsIgnoreCase("Prestado") || 
            nuevoEstado.equalsIgnoreCase("Retirado")) {
            this.estado = nuevoEstado;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Id: " + this.identificadorUnico);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editorial: " + this.editorial);
        System.out.println("Año: " + this.anioPublicacion);
        System.out.println("Categoría: " + this.categoria);
        System.out.println("Estado: " + this.estado);
    }

    public String getIdentificadorUnico() { return identificadorUnico; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getEditorial() { return editorial; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getCategoria() { return categoria; }
    public String getEstado() { return estado; }
}