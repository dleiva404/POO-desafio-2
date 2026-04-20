package model;

//clase final para las revistas, que hereda de MaterialEscrito
public class Revista extends MaterialEscrito {

    // contador independiente del Libro
    private static int contador = 0;

    private String editorial;
    private String periodicidad;
    private String fechaPublicacion;

    // llamará al constructor de MaterialEscrito con super()
    public Revista(String titulo, int unidadesDisponibles, String autor, int numeroPaginas,
            String editorial, String periodicidad, String fechaPublicacion) {
        super(titulo, unidadesDisponibles, autor, numeroPaginas);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    // genera el código único de la revista
    // el contador de la revista no debe mezclarse con el del libro
    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("REV%05d", contador);
    }

    @Override
    public String mostrarDatos() {
        return "ID        : " + getIdInterno() + "\n" +
                "Título    : " + getTitulo() + "\n" +
                "Autor     : " + getAutor() + "\n" +
                "Páginas   : " + getNumeroPaginas() + "\n" +
                "Editorial : " + getEditorial() + "\n" +
                "Periodicidad : " + getPeriodicidad() + "\n" +
                "Fecha de Publicación : " + getFechaPublicacion() + "\n" +
                "Unidades  : " + getUnidadesDisponibles();
    }

    // Getters para leer los datos de la revista
    public String getEditorial() {
        return editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    // Setters para modificar los datos
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    // para sincronizar el contador con la BD al arrancar la app
    public static void setContador(int valor) {
        contador = valor;
    }

    public static int getContador() {
        return contador;
    }
}