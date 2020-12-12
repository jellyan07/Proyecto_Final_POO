package sample.entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @auhtor Andrea Jimenez
 * @version 1.1
 */
public class ListadeReproduccion {

    private int id;
    private int creador;
    private String nombre;
    private Date fecha_de_creacion;
    private int calificacion;

    /**
     * get del id
     * @return
     */

    public int getId() {
        return id;
    }

    /**
     * set del id
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * get del nombre
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
     * get de la fecha de creacion
     * @return
     */

    public Date getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    /**
     * set de la fecha de creación
     * @param fecha_de_creacion
     */

    public void setFecha_de_creacion(Date fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    /**
     * get de la calificacion
     * @return
     */

    public int getCalificacion() {
        return calificacion;
    }

    /**
     * set de la calificacion
     * @param calificacion
     */

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * get del id del usuario creador
     * @return
     */

    public int getCreador() {
        return creador;
    }

    /**
     * set del id del creador
     * @param creador
     */

    public void setCreador(int creador) {
        this.creador = creador;
    }

    /**
     * constructor vacío
     */

    public ListadeReproduccion() { }

    /**
     * constructor con parámetros de lista
     * @param creador
     * @param nombre
     * @param fecha_de_creacion
     * @param calificacion
     */

    public ListadeReproduccion(int creador, String nombre, Date fecha_de_creacion, int calificacion) {
        this.creador = creador;
        this.nombre = nombre;
        this.fecha_de_creacion = fecha_de_creacion;
        this.calificacion = calificacion;
    }

    /**
     * método toString de lista
     * @return
     */

    @Override
    public String toString() {
        return "ListadeReproduccion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_de_creacion='" + fecha_de_creacion + '\'' +
                ", calificacion=" + calificacion +
                ", creador=" + creador +
                '}';
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
        ListadeReproduccion that = (ListadeReproduccion) o;
        return id == that.id &&
                creador == that.creador &&
                calificacion == that.calificacion &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(fecha_de_creacion, that.fecha_de_creacion);
    }

    /**
     * método hashcode
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, creador, nombre, fecha_de_creacion, calificacion);
    }
}
