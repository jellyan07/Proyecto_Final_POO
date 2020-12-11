package jimenez.andrea.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Album {

    private int ID;
    private String nombre;
    private LocalDate fecha_lanzamiento;
    private String imagen;
    private ArrayList<Cancion> canciones;

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

    public LocalDate getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Album() {
        this.canciones = new ArrayList<>();
    }

    public Album(int ID, String nombre, LocalDate fecha_lanzamiento, String imagen) {
        this.ID = ID;
        this.nombre = nombre;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Album{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_lanzamiento='" + fecha_lanzamiento + '\'' +
                ", imagen='" + imagen + '\'' +
                ", canciones=" + canciones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(ID, album.ID) &&
                Objects.equals(nombre, album.nombre) &&
                Objects.equals(fecha_lanzamiento, album.fecha_lanzamiento) &&
                Objects.equals(imagen, album.imagen) &&
                Objects.equals(canciones, album.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nombre, fecha_lanzamiento, imagen, canciones);
    }
}
