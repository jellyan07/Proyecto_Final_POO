package jimenez.andrea.logica;

import jimenez.andrea.bl.entidades.*;
import jimenez.andrea.dao.ArtistaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Gestor {

    private Connection conection;

    public Gestor(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.conection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , "root", "root");
            this.artistas = new ArtistaDAO(this.conection);
        } catch (Exception e) {
            System.out.println("Cant connect to db");
            e.printStackTrace();
        }
    }

    private ArtistaDAO artistas;

    public void crearArtista(int ID, String nombre, String apellido, String nombre_artístico, LocalDate fecha_de_nacimiento, LocalDate fecha_de_defuncion, String pais_de_nacimiento, String genero, int edad) throws SQLException {
        Artista artista = new Artista(ID, nombre, apellido, nombre_artístico, fecha_de_nacimiento, fecha_de_defuncion, pais_de_nacimiento, genero, edad);
        artistas.save(artista);
    }

    public List<Artista> findAllMaterial() throws SQLException {
        return artistas.findAll();
    }

}
