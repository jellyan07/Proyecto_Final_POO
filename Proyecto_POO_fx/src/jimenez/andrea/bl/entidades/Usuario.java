/**
 *
 * @author Andrea Jimenez
 * @version 1.0
 *
 */

package jimenez.andrea.bl.entidades;

import java.util.Objects;

public class Usuario extends Persona{
    private int id;
    private int edad;
    private String pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, int id, int edad, String pais, String img) {
        super(nombre, apellido1, apellido2, correo, password, nombre_usuario, img);
        this.id = id;
        this.edad = edad;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + id + '\'' +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                super.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return edad == usuario.edad &&
                Objects.equals(id, usuario.id) &&
                Objects.equals(pais, usuario.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, edad, pais);
    }
}



