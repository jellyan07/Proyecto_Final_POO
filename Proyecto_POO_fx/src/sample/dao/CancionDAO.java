package sample.dao;

import sample.entidades.*;

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
    ArtistaDAO artistaDAO;
    AlbumDAO albumDAO;
    GeneroDAO generoDAO;
    CompositorDAO compositorDAO;

    public CancionDAO(Connection cnx){
        this.cnx = cnx;
        this.artistaDAO = new ArtistaDAO(cnx);
        this.albumDAO = new AlbumDAO(cnx);
        this.generoDAO = new GeneroDAO(cnx);
        this.compositorDAO = new CompositorDAO(cnx);
    }

    public void save(Cancion material) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("insert into cancion (nombre, artista, genero, compositor, fecha_lanzamiento, album, creador, precio, tipo, calificacion, link, img)");
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
        buildSentence.append(",");
        buildSentence.append(material.getCalificacion());
        buildSentence.append(",'");
        buildSentence.append(material.getLink());
        buildSentence.append("','");
        buildSentence.append(material.getImg());
        buildSentence.append("')");
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
            uno.setArtista(artistaDAO.findArtistaByID(result.getInt("artista")));
            uno.setGenero(generoDAO.findGeneroByID(result.getInt("genero")));
            uno.setCompositor(compositorDAO.findCompositorByID(result.getInt("compositor")));
            uno.setFecha_de_lanzamiento(result.getDate("fecha_lanzamiento"));
            uno.setAlbum(albumDAO.findAlbumByID(result.getInt("album")));
            uno.setPrecio(result.getDouble("precio"));
            uno.setTienda(result.getBoolean("tipo"));
            uno.setCalificacion(result.getInt("calificacion"));

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
        buildSentence.append(", calificacion = ");
        buildSentence.append(cancion.getCalificacion());
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

    public List<Cancion> findAllUsuario(Usuario usuario) throws SQLException {
        ArrayList<Cancion> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from tusuario_cancion where idusuario = " + usuario.getId());
        while(result.next()){
            Cancion uno = new Cancion();
            uno = findCancionByID(result.getInt("idcancion"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public void saveToUsuario(Cancion cancion) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("insert into cancion (nombre, artista, genero, compositor, fecha_lanzamiento, album, creador, precio, tipo, calificacion, link, img)");
        buildSentence.append(" values ('");
        buildSentence.append(cancion.getNombre());
        buildSentence.append("',");
        buildSentence.append(cancion.getArtista().getID());
        buildSentence.append(",");
        buildSentence.append(cancion.getGenero().getID());
        buildSentence.append(",");
        buildSentence.append(cancion.getCompositor().getID());
        buildSentence.append(",'");
        buildSentence.append(dateFormat.format(cancion.getFecha_de_lanzamiento()));
        buildSentence.append("',");
        buildSentence.append(cancion.getAlbum().getID());
        buildSentence.append(",");
        buildSentence.append(cancion.getCreador());
        buildSentence.append(",");
        buildSentence.append(cancion.getPrecio());
        buildSentence.append(",");
        buildSentence.append(cancion.isTienda());
        buildSentence.append(",");
        buildSentence.append(cancion.getCalificacion());
        buildSentence.append(",'");
        buildSentence.append(cancion.getLink());
        buildSentence.append("','");
        buildSentence.append(cancion.getImg());
        buildSentence.append("')");
        System.out.println(buildSentence.toString());
        Statement insertCmd = null;
        int key = -1;
        try {
            insertCmd = cnx.createStatement();
            insertCmd.execute(String.valueOf(buildSentence),Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = insertCmd.getGeneratedKeys();
            while (generatedKeys.next()) {
                key = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        buildSentence = new StringBuilder("insert into tusuario_cancion (idusuario, idcancion)");
        buildSentence.append(" values (");
        buildSentence.append(cancion.getCreador());
        buildSentence.append(" , ");
        buildSentence.append(key);
        buildSentence.append(")");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public ArrayList<Cancion> tiendaUsuario(int idusuario) throws SQLException {
        ArrayList<Cancion> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("select idcancion from cancion MINUS select idcancion from cancion where idcancion in ( select idcancion from tusuario_cancion where idusuario = ");
        buildSentence.append(idusuario);
        buildSentence.append(";");
        stmt.execute(buildSentence.toString());
        ResultSet result = stmt.executeQuery(buildSentence.toString());
        while(result.next()){
            Cancion uno = new Cancion();
            uno = findCancionByID(result.getInt("idcancion"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public void comprar(Cancion cancion, Usuario usuario) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("insert into tusuario_cancion (idusuario, idcancion) values (");
        buildSentence.append(usuario.getId());
        buildSentence.append(",");
        buildSentence.append(cancion.getID());
        buildSentence.append(");");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
