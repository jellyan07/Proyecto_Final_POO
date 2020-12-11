package sample.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Andrea Jimenez
 * @version 1.1
 */
public class Album {

    private int ID;
    private String nombre;
    private Date fecha_lanzamiento;
    private String imagen;

    /**
     * get el id
     * @return
     */

    public int getID() {
        return ID;
    }

    /**
     * set el id
     * @param ID
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * get el nombre
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * set el nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * get la fecha de lanzamiento
     * @return
     */

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    /**
     * set la fecha de lanzamiento
     * @param fecha_lanzamiento
     */

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    /**
     * get la imagen del álbum
     * @return
     */

    public String getImagen() {
        return imagen;
    }

    /**
     * set la imagen del álbum
     * @param imagen
     */

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * constructor vacío de álbum
     */

    public Album() {

    }

    /**
     * constructor con parámetros de álbum
     * @param nombre
     * @param fecha_lanzamiento
     * @param imagen
     */

    public Album(String nombre, Date fecha_lanzamiento, String imagen) {
        this.nombre = nombre;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.imagen = imagen;
    }

    /**
     * método toString de álbum
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
        Album album = (Album) o;
        return Objects.equals(ID, album.ID) &&
                Objects.equals(nombre, album.nombre) &&
                Objects.equals(fecha_lanzamiento, album.fecha_lanzamiento) &&
                Objects.equals(imagen, album.imagen);
    }

    /**
     * método de hashcode
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(ID, nombre, fecha_lanzamiento, imagen);
    }
}
