package model;

//agrupamos los materiales que se escuchan o se ven como CD y DVD
public abstract class MaterialAudiovisual extends Material {

    protected int duracion;
    protected String genero;

    //llamamos al constructor de material con super()
    public MaterialAudiovisual(String titulo, int unidadesDisponibles, int duracion, String genero) {
        super(titulo, unidadesDisponibles);
        this.duracion = duracion;
        this.genero = genero;
    }

    // Getters para leer la duración y genéro de otras clases
    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    // Setters nos ayudará a que podamos modificar la duración y genéro de cuando sea necesario
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}