package jimenez.andrea.bl.entidades;

import java.util.ArrayList;

public class Compositor {

    private int ID;
    private String Nombre;
    private String Apellido;
    private String pais_de_nacimiento;
    private String edad;
    private ArrayList<Genero> generos;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getPais_de_nacimiento() {
        return pais_de_nacimiento;
    }

    public void setPais_de_nacimiento(String pais_de_nacimiento) {
        this.pais_de_nacimiento = pais_de_nacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public Compositor() {
    }

    public Compositor(int ID, String nombre, String apellido, String pais_de_nacimiento, String genero, String edad) {
        this.ID = ID;
        Nombre = nombre;
        Apellido = apellido;
        this.pais_de_nacimiento = pais_de_nacimiento;
        this.edad = edad;
    }
}
