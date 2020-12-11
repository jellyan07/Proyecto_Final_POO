package jimenez.andrea.bl.entidades;

import java.util.ArrayList;
import java.util.Objects;

public class ListadeReproduccion {

    private String id;
    private String nombre;
    private String fecha_de_creacion;
    private int calificacion;
    private ArrayList<Cancion> canciones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(String fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ListadeReproduccion() {
        this.canciones = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ListadeReproduccion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_de_creacion='" + fecha_de_creacion + '\'' +
                ", calificacion=" + calificacion +
                ", canciones=" + canciones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListadeReproduccion that = (ListadeReproduccion) o;
        return calificacion == that.calificacion &&
                Objects.equals(id, that.id) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(fecha_de_creacion, that.fecha_de_creacion) &&
                Objects.equals(canciones, that.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fecha_de_creacion, calificacion, canciones);
    }
}
