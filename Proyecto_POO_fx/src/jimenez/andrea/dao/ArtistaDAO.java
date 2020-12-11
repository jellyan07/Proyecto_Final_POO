package jimenez.andrea.dao;

import jimenez.andrea.bl.entidades.Artista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    Connection cnx;

    public ArtistaDAO(Connection cnx){
        this.cnx = cnx;
    }

    public void save(Artista material) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("insert into artista (idartista,nombre,apellido,nombre_artistico,pais_nacimiento,fecha_nacimiento,fecha_defuncion,genero,edad)");
        buildSentence.append(" values (");
        buildSentence.append(material.getID());
        buildSentence.append(",'");
        buildSentence.append(material.getNombre());
        buildSentence.append("','");
        buildSentence.append(material.getApellido());
        buildSentence.append("','");
        buildSentence.append(material.getNombre_artístico());
        buildSentence.append("','");
        buildSentence.append(material.getPais_de_nacimiento());
        buildSentence.append("','");
        buildSentence.append(material.getFecha_de_nacimiento());
        buildSentence.append("',");
        buildSentence.append(material.getFecha_de_defuncion());
        buildSentence.append(",'");
        buildSentence.append(material.getGenero());
        buildSentence.append("',");
        buildSentence.append(material.getEdad());
        buildSentence.append(")");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public List<Artista> findAll() throws SQLException {
        ArrayList<Artista> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from artistas");
        while(result.next()){
            Artista uno = new Artista();
            uno.setID(result.getInt("ID"));
            uno.setNombre(result.getString("Nombre"));
            uno.setApellido(result.getString("Apellido"));
            uno.setNombre_artístico(result.getString("Nombre artístico"));
            uno.setPais_de_nacimiento(result.getString("País de Nacimiento"));
            uno.setFecha_de_nacimiento(result.getDate("Fecha de nacimiento").toLocalDate());
            uno.setFecha_de_defuncion(result.getDate("Fecha de defunción").toLocalDate());
            uno.setGenero(result.getString("Género"));
            uno.setEdad(result.getInt("Edad"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }
}
