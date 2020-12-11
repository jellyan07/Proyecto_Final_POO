package sample.dao;

import sample.entidades.Album;
import sample.entidades.Artista;
import sample.entidades.Cancion;
import sample.entidades.Compositor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CancionDAO {

    Connection cnx;
    ArtistaDAO artistaDAO = new ArtistaDAO(cnx);
    AlbumDAO albumDAO = new AlbumDAO(cnx);
    GeneroDAO generoDAO = new GeneroDAO(cnx);
    CompositorDAO compositorDAO = new CompositorDAO(cnx);

    public CancionDAO(Connection cnx){
        this.cnx = cnx;
    }

    public void save(Cancion material) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("insert into cancion (nombre, artista, genero, compositor, fecha_lanzamiento, album, creador, precio, tipo)");
        buildSentence.append(" values ('");
        buildSentence.append(material.getNombre());
        buildSentence.append("',");
        buildSentence.append(material.getArtista().getID());
        buildSentence.append(",");
        buildSentence.append(material.getGenero().getID());
        buildSentence.append(",");
        buildSentence.append(material.getCompositor().getID());
        buildSentence.append(",'");
        buildSentence.append(dateFormat.format(material.getFecha_de_lanzamiento()));
        buildSentence.append("',");
        buildSentence.append(material.getAlbum().getID());
        buildSentence.append(",");
        buildSentence.append(material.getCreador());
        buildSentence.append(",");
        buildSentence.append(material.getPrecio());
        buildSentence.append(",");
        buildSentence.append(material.isTienda());
        buildSentence.append(")");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public List<Cancion> findAll() throws SQLException {
        ArrayList<Cancion> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from cancion");
        while(result.next()){
            Cancion uno = new Cancion();
            uno.setID(result.getInt("idcancion"));
            uno.setNombre(result.getString("nombre"));
            uno.setArtista(artistaDAO.findArtistaByID(result.getInt("idartista")));
            uno.setGenero(generoDAO.findGeneroByID(result.getInt("idgenero")));
            uno.setCompositor(compositorDAO.findCompositorByID(result.getInt("idcompositor")));
            uno.setFecha_de_lanzamiento(result.getDate("fecha_lanzamiento"));
            uno.setAlbum(albumDAO.findAlbumByID(result.getInt("idalbum")));
            uno.setPrecio(result.getDouble("precio"));

            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public Cancion findCancionByID(int id) throws SQLException {
        List<Cancion> canciones = findAll();
        for (Cancion cancion: canciones) {
            if(cancion.getID() == id) {
                return cancion;
            }
        }
        return null;
    }

    public void edit(Cancion cancion, Cancion cancion_cambiar) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("update into cancion set nombre = '");
        buildSentence.append(cancion.getNombre());
        buildSentence.append("', artista = ");
        buildSentence.append(cancion.getArtista().getID());
        buildSentence.append(", genero = ");
        buildSentence.append(cancion.getGenero().getID());
        buildSentence.append(", compositor = ");
        buildSentence.append(cancion.getCompositor().getID());
        buildSentence.append(", fecha_lanzamiento = '");
        buildSentence.append(dateFormat.format(cancion.getFecha_de_lanzamiento()));
        buildSentence.append("', compositor = ");
        buildSentence.append(cancion.getCompositor().getID());
        buildSentence.append(", album = ");
        buildSentence.append(cancion.getAlbum().getID());
        buildSentence.append(", creador = ");
        buildSentence.append(cancion.getCreador());
        buildSentence.append(", precio = ");
        buildSentence.append(cancion.getPrecio());
        buildSentence.append(", tipo = ");
        buildSentence.append(cancion.isTienda());

        buildSentence.append(" where idcancion = ");
        buildSentence.append(cancion_cambiar.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public void delete(Cancion cancion) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("delete from cancion where idcancion = ");
        buildSentence.append(cancion.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
