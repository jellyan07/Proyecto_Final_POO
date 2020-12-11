package sample.dao;

import sample.entidades.Album;
import sample.entidades.Artista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    Connection cnx;

    public AlbumDAO(Connection cnx){
        this.cnx = cnx;
    }

    public void save(Album material) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("insert into album (nombre, fecha_lanzamiento, imagen)");
        buildSentence.append(" values ('");
        buildSentence.append(material.getNombre());
        buildSentence.append("','");
        buildSentence.append(dateFormat.format(material.getFecha_lanzamiento()));
        buildSentence.append("','");
        buildSentence.append(material.getImagen());
        buildSentence.append("')");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public List<Album> findAll() throws SQLException {
        ArrayList<Album> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from album");
        while(result.next()){
            Album uno = new Album();
            uno.setID(result.getInt("idalbum"));
            uno.setNombre(result.getString("nombre"));
            uno.setFecha_lanzamiento(result.getDate("fecha_lanzamiento"));
            uno.setImagen(result.getString("imagen"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public Album findAlbumByID(int id) throws SQLException {
        List<Album> albumes = findAll();
        for (Album album: albumes) {
            if(album.getID() == id) {
                return album;
            }
        }
        return null;
    }

    public void edit(Album album, Album album_cambiar) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("update album set nombre = '");
        buildSentence.append(album.getNombre());
        buildSentence.append("', fecha_lanzamiento = '");
        buildSentence.append(dateFormat.format(album.getFecha_lanzamiento()));
        buildSentence.append("', imagen = '");
        buildSentence.append(album.getImagen());
        buildSentence.append("' where idalbum = ");
        buildSentence.append(album_cambiar.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public void delete(Album album) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("delete from album where idalbum = ");
        buildSentence.append(album.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
