package model;

//clase base de todos los materiales de la mediateca
//es abstracta porque nunca vamos a poder crear un material genérico
//siempre sera un Libro-Revista-CD-DVD
public abstract class Material {
    // atributos que tienen todos los materiales
    private String idInterno; // Codigo único que tendrá el material
    private String titulo;
    private int unidadesDisponibles;

    // Constructor recibe todas las subclases cuando llama a super()
    public Material(String titulo, int unidadesDisponibles) {
        this.titulo = titulo;
        this.unidadesDisponibles = unidadesDisponibles;
        this.idInterno = generarCodigo(); // se va a generar cuando se crea el objeto
    }

    // cada subclase va a implementar este método por ejemplo libro pondrá LIB
    protected abstract String generarCodigo();

    // cada clase sabe mostrar sus propios datos
    public abstract String mostrarDatos();

    // Getters para que otras clases puedan leer los datos
    public String getIdInterno() {
        return idInterno;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    // Setters para que se carguen los datos desde la BD
    public void setIdInterno(String idInterno) {
        this.idInterno = idInterno;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    @Override
    public String toString() {
        return "[" + getIdInterno() + "] " + titulo;

    }
}
