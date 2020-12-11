package sample.dao;

import sample.entidades.Artista;
import sample.entidades.Genero;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    Connection cnx;
    GeneroDAO generoDAO;

    public ArtistaDAO(Connection cnx){
        this.cnx = cnx;
        this.generoDAO = new GeneroDAO(cnx);
    }

    public void save(Artista material) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("insert into artista (idartista,nombre,apellido,nombre_artistico,pais_nacimiento,fecha_nacimiento,fecha_defuncion,genero,edad)");
        buildSentence.append(" values (");
        buildSentence.append(material.getID());
        buildSentence.append(",'");
        buildSentence.append(material.getNombre());
        buildSentence.append("','");
        buildSentence.append(material.getApellido());
        buildSentence.append("','");
        buildSentence.append(material.getNombre_artistico());
        buildSentence.append("','");
        buildSentence.append(material.getPais_de_nacimiento());
        buildSentence.append("','");
        buildSentence.append(dateFormat.format(material.getFecha_de_nacimiento()));
        if(material.getFecha_de_defuncion() != null) {
            buildSentence.append("','");
            buildSentence.append(dateFormat.format(material.getFecha_de_defuncion()));
            buildSentence.append("',");
        } else {
            buildSentence.append("',");
            buildSentence.append(material.getFecha_de_defuncion());
            buildSentence.append(",");
        }
        buildSentence.append(material.getGenero().getID());
        buildSentence.append(",");
        buildSentence.append(material.getEdad());
        buildSentence.append(")");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public List<Artista> findAll() throws SQLException {
        ArrayList<Artista> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from artista");
        while(result.next()){
            Artista uno = new Artista();
            uno.setID(result.getInt("idartista"));
            uno.setNombre(result.getString("nombre"));
            uno.setApellido(result.getString("apellido"));
            uno.setNombre_artistico(result.getString("nombre_artistico"));
            uno.setPais_de_nacimiento(result.getString("pais_nacimiento"));
            uno.setFecha_de_nacimiento(result.getDate("fecha_nacimiento"));
            if(result.getDate("fecha_defuncion") != null) {
                uno.setFecha_de_defuncion(result.getDate("fecha_defuncion"));
            }
            uno.setGenero(generoDAO.findGeneroByID(result.getInt("genero")));
            uno.setEdad(result.getInt("edad"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public Artista findArtistaByID(int id) throws SQLException {
        List<Artista> artistas = findAll();
        for (Artista artista: artistas) {
            if(artista.getID() == id) {
                return artista;
            }
        }
        return null;
    }

    public void edit(Artista artista, Artista artista_cambiar) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("update artista set nombre = '");
        buildSentence.append(artista.getNombre());
        buildSentence.append("', apellido = '");
        buildSentence.append(artista.getApellido());
        buildSentence.append("', nombre_artistico = '");
        buildSentence.append(artista.getNombre_artistico());
        buildSentence.append("', pais_nacimiento = '");
        buildSentence.append(artista.getPais_de_nacimiento());
        buildSentence.append("', fecha_nacimiento = '");
        buildSentence.append(dateFormat.format(artista.getFecha_de_nacimiento()));
        if(artista.getFecha_de_defuncion() != null) {
            buildSentence.append("', fecha_defuncion = '");
            buildSentence.append(dateFormat.format(artista.getFecha_de_defuncion()));
            buildSentence.append("', genero = ");
        } else {
            buildSentence.append("', fecha_defuncion = ");
            buildSentence.append(artista.getFecha_de_defuncion());
            buildSentence.append(", genero = ");
        }
        buildSentence.append(artista.getGenero().getID());
        buildSentence.append(", edad = ");
        buildSentence.append(artista.getEdad());
        buildSentence.append(" where idartista = ");
        buildSentence.append(artista_cambiar.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public void delete(Artista artista) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("delete from artista where idartista = ");
        buildSentence.append(artista.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
