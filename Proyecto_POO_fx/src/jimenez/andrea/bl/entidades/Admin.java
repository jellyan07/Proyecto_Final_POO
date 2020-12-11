package jimenez.andrea.bl.entidades;

public class Admin extends Persona {

    public Admin() {
    }

    public Admin(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, String img) {
        super(nombre, apellido1, apellido2, correo, password, nombre_usuario, img);
    }

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() +
                "}";
    }


}
