/**
 *
 * @author Andrea Jimenez
 * @version 1.0
 *
 */
/**
 * @author Andrea jimenez
 * @version 1.1
 */
package sample.entidades;

import java.util.Objects;

public class Usuario extends Persona {
    private int id;
    private int edad;
    private String pais;

    /**
     * get del id
     * @return id
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
     * get de edad
     * @return edad
     */

    public int getEdad() {
        return edad;
    }

    /**
     * set de edad
     * @param edad
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * get del país
     * @return
     */

    public String getPais() {
        return pais;
    }

    /**
     * set del país
     * @param pais
     */

    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * contructor vacío
     */

    public Usuario() {
    }

    /**
     * constructor de usuario con parámetros
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param correo
     * @param password
     * @param nombre_usuario
     * @param edad
     * @param pais
     * @param img
     */

    public Usuario(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, int edad, String pais, String img) {
        super(nombre, apellido1, apellido2, correo, password, nombre_usuario, img);
        this.edad = edad;
        this.pais = pais;
    }

    /**
     * Método to string
     * @return toString de Usuario
     */

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + id + '\'' +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                super.toString();

    }

    /**
     * Equals de Usuario
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                edad == usuario.edad &&
                Objects.equals(pais, usuario.pais);
    }

    /**
     * Hashcode method
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, edad, pais);
    }
}



