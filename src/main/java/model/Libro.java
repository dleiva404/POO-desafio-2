package model;

//clase final para los libros, que herada de MaterialesEscrito
public class Libro extends MaterialEscrito {

    //contador compartido por todos los libros
    private static int contador = 0;

    private String editorial;
    private String isbn;
    private int anioPublicacion;

    //llamara al constructor de MaterialesEscrito con super()
    //que llama también al constructor de Material
    public Libro(String titulo, int unidadesDisponibles, String autor, int numeroPaginas,
                 String editorial, String isbn, int anioPublicacion) {
        super(titulo, unidadesDisponibles, autor, numeroPaginas);
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    //genera el código único del libro al momento que se crea
    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("LIB%05d", contador);
    }

    // Getters para que las otras clases puedan leer los datos del libro
    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Setters para que modifique los datos que sea necesario
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