package model;

// clase final para DVD, que hereda de MaterialAudiovisual
// genera códigos
public class Dvd extends MaterialAudiovisual {
    //contador propio de Dvd, que es independiente de los demás
    private static int contador = 0;

    private String director;

    // llama al constructor de MaterialAudiovisual con super()
    public Dvd(String titulo, int unidadesDisponibles, int duracion, String genero,
               String director) {
        super(titulo, unidadesDisponibles, duracion, genero);
        this.director = director;
    }

    // genera el código único del DVD al momento de crearlo
    @Override
    protected String generarCodigo() {
        contador++;
        return String.format("DVD%05d", contador);
    }

    //Getter para leer el directos del DVD
    public String getDirector() {
        return director;
    }

    //Setter para modificar el director
    public void setDirector(String director) {
        this.director = director;
    }

}