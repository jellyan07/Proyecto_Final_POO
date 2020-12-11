package sample.entidades;
/**
 * @author Andrea Jimenez
 * @version 1.1
 */

import java.util.Objects;

public class Genero {
    private int ID;
    private String nombre;
    private String descripcion;

    /**
     * get del id
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * set del id
     * @param ID
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * get nombre
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * set del nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * get de la descripcion
     * @return
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * set descripcion
     * @param descripcion
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * constructor vacío
     */

    public Genero() {
    }

    /**
     * constructor de género con parámetros
     * @param nombre
     * @param descripcion
     */

    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * método toString
     * @return
     */

    @Override
    public String toString() {
        return getNombre();
    }

    /**
     * método equals
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(ID, genero.ID) &&
                Objects.equals(nombre, genero.nombre) &&
                Objects.equals(descripcion, genero.descripcion);
    }

    /**
     * método hashcode
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(ID, nombre, descripcion);
    }
}
