package model;

//agrupamos los materiales los materiales que se leen: libros y revistas
//hereda todo del material y agregara el autor y las páginas
public abstract class MaterialEscrito extends Material {

    protected String autor;
    protected int numeroPaginas;

    // llamamos al constructor de material con super() y va a agregar sus propios datos
    public MaterialEscrito(String titulo, int unidadesDisponibles, String autor, int numeroPaginas) {
        super(titulo, unidadesDisponibles);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    // Getters
    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    // Setters
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}