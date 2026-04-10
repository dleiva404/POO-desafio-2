package model;

public class CdAudio extends MaterialAudiovisual {

    private static int contador = 0;

    private String artista;
    private int numeroCanciones;

    public CdAudio(String titulo, int unidadesDisponibles, int duracion, String genero,
                   String artista, int numeroCanciones) {
        super(titulo, unidadesDisponibles, duracion, genero);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
    }

    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("CDA%05d", contador);
    }

    // Getters
    public String getArtista() {
        return artista;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    // Setters
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

}