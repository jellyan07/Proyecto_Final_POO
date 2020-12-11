package jimenez.andrea.bl.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Cancion {
    private int ID;
    private String nombre;
    private Artista artista;
    private Genero genero;
    private Compositor compositor;
    private LocalDate fecha_de_lanzamiento;
    private Album album;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public LocalDate getFecha_de_lanzamiento() {
        return fecha_de_lanzamiento;
    }

    public void setFecha_de_lanzamiento(LocalDate fecha_de_lanzamiento) {
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Cancion(String id, Artista artista, Genero genero, Compositor compositor, String fecha_de_lanzamiento, Album album) {
    }

    public Cancion(int ID, String nombre, Artista artista, Genero genero, Compositor compositor, LocalDate fecha_de_lanzamiento, Album album) {
        this.ID = ID;
        this.artista = artista;
        this.genero = genero;
        this.compositor = compositor;
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id='" + ID + '\'' +
                ", Nombre= " + nombre +
                ", artista=" + artista +
                ", genero=" + genero +
                ", compositor=" + compositor +
                ", fecha_de_lanzamiento='" + fecha_de_lanzamiento + '\'' +
                ", album=" + album +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(ID, cancion.ID) &&
                Objects.equals(artista, cancion.artista) &&
                Objects.equals(genero, cancion.genero) &&
                Objects.equals(compositor, cancion.compositor) &&
                Objects.equals(fecha_de_lanzamiento, cancion.fecha_de_lanzamiento) &&
                Objects.equals(album, cancion.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, artista, genero, compositor, fecha_de_lanzamiento, album);
    }
}
