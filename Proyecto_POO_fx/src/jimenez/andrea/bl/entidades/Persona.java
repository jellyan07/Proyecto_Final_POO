/**
 * @author Andrea Jimenez
 * @version 1.0
 */

package jimenez.andrea.bl.entidades;

import java.util.Objects;

public abstract class Persona {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String password;
    private String nombre_usuario;
    private String img;

    /**
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return primer apellido
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return segundo apellido
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return nombre de usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, String img) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.password = password;
        this.nombre_usuario = nombre_usuario;
    }

    @Override
    public String toString() {
        return "admin{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", imagen de perfil: " + img +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona admin = (Persona) o;
        return Objects.equals(nombre, admin.nombre) &&
                Objects.equals(apellido1, admin.apellido1) &&
                Objects.equals(apellido2, admin.apellido2) &&
                Objects.equals(correo, admin.correo) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(nombre_usuario, admin.nombre_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido1, apellido2, correo, password, nombre_usuario);
    }
}
