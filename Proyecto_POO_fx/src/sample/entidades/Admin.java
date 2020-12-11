package sample.entidades;

/**
 * @author Andrea Jimenez
 * @version 1.1
 */
public class Admin extends Persona {
    /**
     * constructor vacío de admin
     */
    public Admin() {
    }

    /**
     * constructor con parámetros de admin
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param correo
     * @param password
     * @param nombre_usuario
     * @param img
     */

    public Admin(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, String img) {
        super(nombre, apellido1, apellido2, correo, password, nombre_usuario, img);
    }

    /**
     * método toString
     * @return
     */

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() +
                "}";
    }

}
