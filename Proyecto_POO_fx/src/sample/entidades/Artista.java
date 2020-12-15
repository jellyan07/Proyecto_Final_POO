package sample.entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author Andrea Jimenez
 * @version 1.1
 */

public class Artista {

    private int ID;
    private String Nombre;
    private String Apellido;
    private String nombre_artistico;
    private Date fecha_de_nacimiento;
    private Date fecha_de_defuncion;
    private String pais_de_nacimiento;
    private Genero genero;
    private int edad;

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
        return Nombre;
    }

    /**
     * set el nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * get el primer apellido
     * @return
     */

    public String getApellido() {
        return Apellido;
    }

    /**
     * set el primer apellido
     * @param apellido
     */

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    /**
     * get el nombre artístico
     * @return
     */

    public String getNombre_artistico() {
        return nombre_artistico;
    }

    /**
     * set el nombre artístico
     * @param nombre_artístico
     */

    public void setNombre_artistico(String nombre_artístico) {
        this.nombre_artistico = nombre_artístico;
    }

    /**
     * get la fecha de nacimiento
     * @return
     */

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    /**
     * set la fecha de nacimiento
     * @param fecha_de_nacimiento
     */

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    /**
     * get la fecha de defunción si hay
     * @return
     */

    public Date getFecha_de_defuncion() {
        return fecha_de_defuncion;
    }

    /**
     * set la fecha defunción si aplica
     * @param fecha_de_defuncion
     */

    public void setFecha_de_defuncion(Date fecha_de_defuncion) {
        this.fecha_de_defuncion = fecha_de_defuncion;
    }

    /**
     * get del país de nacimiento
     * @return
     */

    public String getPais_de_nacimiento() {
        return pais_de_nacimiento;
    }

    /**
     * set País de nacimiento
     * @param pais_de_nacimiento
     */

    public void setPais_de_nacimiento(String pais_de_nacimiento) {
        this.pais_de_nacimiento = pais_de_nacimiento;
    }

    /**
     * get del género
     * @return
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * set género
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * get la edad
     * @return
     */

    public int getEdad() {
        return edad;
    }

    /**
     * set edad
     * @param edad
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * constructor vacío de artista
     */

    public Artista() {
    }

    /**
     * constructor con parámetros de artista
     * @param nombre
     * @param apellido
     * @param fecha_de_nacimiento
     * @param pais_de_nacimiento
     * @param genero
     * @param edad
     */

    public Artista(String nombre, String apellido, String nombre_artistico, Date fecha_de_nacimiento, Date fecha_de_defuncion, String pais_de_nacimiento, Genero genero, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        this.nombre_artistico = nombre_artistico;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.fecha_de_defuncion = fecha_de_defuncion;
        this.pais_de_nacimiento = pais_de_nacimiento;
        this.genero = genero;
        this.edad = edad;
    }

    /**
     * método toString de artista
     * @return
     */

    @Override
    public String toString() {
        return getNombre_artistico();
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
        Artista artista = (Artista) o;
        return ID == artista.ID &&
                edad == artista.edad &&
                Objects.equals(Nombre, artista.Nombre) &&
                Objects.equals(Apellido, artista.Apellido) &&
                Objects.equals(nombre_artistico, artista.nombre_artistico) &&
                Objects.equals(fecha_de_nacimiento, artista.fecha_de_nacimiento) &&
                Objects.equals(fecha_de_defuncion, artista.fecha_de_defuncion) &&
                Objects.equals(pais_de_nacimiento, artista.pais_de_nacimiento) &&
                Objects.equals(genero, artista.genero);
    }

    /**
     * método hashcode
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(ID, Nombre, Apellido, nombre_artistico, fecha_de_nacimiento, fecha_de_defuncion, pais_de_nacimiento, genero, edad);
    }
}
