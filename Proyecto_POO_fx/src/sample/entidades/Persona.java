/**
 * @author Andrea Jimenez
 * @version 1.0
 */
/**
 * @author Andrea Jimenez
 * @version 1.1
 */
package sample.entidades;

import java.util.Objects;

public abstract class Persona {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String password;
    private String nombre_usuario;
    private String img;

    /** get de nombre
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /** set de nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** get del primer apellido
     * @return primer apellido
     */
    public String getApellido1() {
        return apellido1;
    }

    /** set del primer apellido
     * @param apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /** get segundo apellido
     * @return segundo apellido
     */
    public String getApellido2() {
        return apellido2;
    }

    /** set del segundo apellido
     * @param apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /** get del correo
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /** set de correo
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /** get de la contraseña
     * @return contraseña
     */
    public String getPassword() {
        return password;
    }

    /** set de la contraseña
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** get del nombre de usuario
     * @return nombre de usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /** set del nombre de usuario
     * @param nombre_usuario
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * get de imagen
     * @return
     */

    public String getImg() {
        return img;
    }

    /**
     * set de la imagen de perfil
     * @param img
     */

    public void setImg(String img) {
        this.img = img;
    }

    /**
     * constructor vacío de persona
     */

    public Persona() {
    }

    /**
     * constructor de persona con parámetros
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param correo
     * @param password
     * @param nombre_usuario
     * @param img
     */

    public Persona(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, String img) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.password = password;
        this.nombre_usuario = nombre_usuario;
        this.img = img;
    }

    /**
     * Método toString de Persona
     * @return
     */

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

}
