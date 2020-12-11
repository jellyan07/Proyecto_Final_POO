package sample.entidades;

import java.util.Objects;

/**
 * @author Andrea Jimenez
 * @version 1.1
 */
public class Compositor {

    private int ID;
    private String Nombre;
    private String Apellido;
    private String pais_de_nacimiento;
    private int edad;
    private Genero genero;

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
     * get del nombre
     * @return
     */

    public String getNombre() {
        return Nombre;
    }

    /**
     * set del nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * get del primer apellido
     * @return
     */

    public String getApellido() {
        return Apellido;
    }

    /**
     * set del primer apellido
     * @param apellido
     */

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    /**
     * get del pais de nacimiento
     * @return
     */

    public String getPais_de_nacimiento() {
        return pais_de_nacimiento;
    }

    /**
     * set del pais de nacimiento
     * @param pais_de_nacimiento
     */

    public void setPais_de_nacimiento(String pais_de_nacimiento) {
        this.pais_de_nacimiento = pais_de_nacimiento;
    }

    /**
     * get de la edad
     * @return
     */

    public int getEdad() {
        return edad;
    }

    /**
     * set de la edad
     * @param edad
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * get de genero
     * @return
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * set de genero
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * constructor vacío de compositor
     */

    public Compositor() {
    }

    /**
     * constructor con parámetros de compositor
     * @param nombre
     * @param apellido
     * @param pais_de_nacimiento
     * @param genero
     * @param edad
     */

    public Compositor(String nombre, String apellido, String pais_de_nacimiento, Genero genero, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        this.pais_de_nacimiento = pais_de_nacimiento;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * método toString
     * @return
     */

    @Override
    public String toString() {
        return "Compositor{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", pais_de_nacimiento='" + pais_de_nacimiento + '\'' +
                ", edad=" + edad +
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
        Compositor that = (Compositor) o;
        return ID == that.ID &&
                edad == that.edad &&
                Objects.equals(Nombre, that.Nombre) &&
                Objects.equals(Apellido, that.Apellido) &&
                Objects.equals(pais_de_nacimiento, that.pais_de_nacimiento);
    }

    /**
     * método hashcode
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(ID, Nombre, Apellido, pais_de_nacimiento, edad);
    }
}
