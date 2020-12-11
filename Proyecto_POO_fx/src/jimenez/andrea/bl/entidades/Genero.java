package jimenez.andrea.bl.entidades;

import java.util.Objects;

public class Genero {
    private int ID;
    private String nombre;
    private String descripcion;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Genero() {
    }

    public Genero(int ID, String nombre, String descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "ID='" + ID + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(ID, genero.ID) &&
                Objects.equals(nombre, genero.nombre) &&
                Objects.equals(descripcion, genero.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nombre, descripcion);
    }
}
