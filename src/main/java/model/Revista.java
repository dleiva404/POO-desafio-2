package model;

public class Revista extends MaterialEscrito {

    private static int contador = 0;

    private String editorial;
    private String periodicidad;
    private String fechaPublicacion;

    public Revista(String titulo, int unidadesDisponibles, String autor, int numeroPaginas,
                   String editorial, String periodicidad, String fechaPublicacion) {
        super(titulo, unidadesDisponibles, autor, numeroPaginas);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("REV%05d", contador);
    }

    // Getters
    public String getEditorial() {
        return editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    // Setters
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}