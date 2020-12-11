package jimenez.andrea.bl.entidades;
import java.time.LocalDate;
public class Artista {

    private int ID;
    private String Nombre;
    private String Apellido;
    private String nombre_artístico;
    private LocalDate fecha_de_nacimiento;
    private LocalDate fecha_de_defuncion;
    private String pais_de_nacimiento;
    private String genero;
    private int edad;

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

    public String getNombre_artístico() {
        return nombre_artístico;
    }

    public void setNombre_artístico(String nombre_artístico) {
        this.nombre_artístico = nombre_artístico;
    }

    public LocalDate getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(LocalDate fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public LocalDate getFecha_de_defuncion() {
        return fecha_de_defuncion;
    }

    public void setFecha_de_defuncion(LocalDate fecha_de_defuncion) {
        this.fecha_de_defuncion = fecha_de_defuncion;
    }

    public String getPais_de_nacimiento() {
        return pais_de_nacimiento;
    }

    public void setPais_de_nacimiento(String pais_de_nacimiento) {
        this.pais_de_nacimiento = pais_de_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Artista() {
    }

    public Artista(int ID, String nombre, String apellido, String nombre_artístico, LocalDate fecha_de_nacimiento, LocalDate fecha_de_defunción, String pais_de_nacimiento, String genero, int edad) {
        this.ID = ID;
        Nombre = nombre;
        Apellido = apellido;
        this.nombre_artístico = nombre_artístico;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.fecha_de_defuncion = fecha_de_defunción;
        this.pais_de_nacimiento = pais_de_nacimiento;
        this.genero = genero;
        this.edad = edad;
    }
}
