package model;

//clase final para los CDS, que hereda de MaterialAudioVisual
public class CdAudio extends MaterialAudiovisual {

    //contador propio de los CDs, que es independiente de los demás
    private static int contador = 0;

    private String artista;
    private int numeroCanciones;

    //llamara al constructor de MaterialAudioVisual con super()
    //también llama al constructor de Material
    public CdAudio(String titulo, int unidadesDisponibles, int duracion, String genero,
                   String artista, int numeroCanciones) {
        super(titulo, unidadesDisponibles, duracion, genero);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
    }

    //generará el código único del CD el momento que se crea
    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("CDA%05d", contador);
    }

    // Getters para leer artista y número de canciones
    public String getArtista() {
        return artista;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    // Setters para modificar los datos del CD
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

}