package model;

public class Libro extends MaterialEscrito {

    private static int contador = 0;

    private String editorial;
    private String isbn;
    private int anioPublicacion;

    public Libro(String titulo, int unidadesDisponibles, String autor, int numeroPaginas,
                 String editorial, String isbn, int anioPublicacion) {
        super(titulo, unidadesDisponibles, autor, numeroPaginas);
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("LIB%05d", contador);
    }

    // Getters
    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Setters
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

}