package sample.dao;

import sample.entidades.Artista;
import sample.entidades.Cancion;
import sample.entidades.Genero;
import sample.entidades.ListadeReproduccion;

import java.net.CacheRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDAO {

    Connection cnx;
    CancionDAO cancionDAO;

    public ListaReproduccionDAO(Connection cnx){
        this.cnx = cnx;
        this.cancionDAO = new CancionDAO(cnx);
    }

    public void save(ListadeReproduccion material,List<Cancion> canciones) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("insert into lista (nombre,fecha_creacion,calificacion, id_creador)");
        buildSentence.append(" values ('");
        buildSentence.append(material.getNombre());
        buildSentence.append("','");
        buildSentence.append(dateFormat.format(material.getFecha_de_creacion()));
        buildSentence.append("',");
        buildSentence.append(material.getCalificacion());
        buildSentence.append(",");
        buildSentence.append(material.getCreador());
        buildSentence.append(")");
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
        for (Cancion cancion:
                canciones) {
            saveCancionToLista(cancion, key);
        }
    }

    public List<ListadeReproduccion> findAll() throws SQLException {
        ArrayList<ListadeReproduccion> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from lista");
        while(result.next()){
            ListadeReproduccion uno = new ListadeReproduccion();
            uno.setId(result.getInt("idlista"));
            uno.setNombre(result.getString("nombre"));
            uno.setFecha_de_creacion(result.getDate("fecha_creacion"));
            uno.setCalificacion(result.getInt("calificacion"));
            uno.setCreador(result.getInt("id_creador"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public void saveCancionToLista (Cancion cancion, int id_lista) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("insert into tlista_cancion (idlista,idcancion)");
        buildSentence.append(" values (");
        buildSentence.append(id_lista);
        buildSentence.append(",");
        buildSentence.append(cancion.getID());
        buildSentence.append(")");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public ListadeReproduccion findListaByID(int id) throws SQLException {
        List<ListadeReproduccion> listas = findAll();
        for (ListadeReproduccion lista: listas) {
            if(lista.getId() == id) {
                return lista;
            }
        }
        return null;
    }

    public List<Cancion> findSongsfromList(ListadeReproduccion lista) throws SQLException {
        ArrayList<Cancion> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from tlista_cancion where idlista = " + lista.getId());
        while(result.next()){
            Cancion uno = new Cancion();
            uno = cancionDAO.findCancionByID(result.getInt("idcancion"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public void edit(ListadeReproduccion lista, ListadeReproduccion lista_cambiar) throws SQLException {
        Statement stmt = cnx.createStatement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder buildSentence = new StringBuilder("update lista set nombre = '");
        buildSentence.append(lista.getNombre());
        buildSentence.append(", where idlista = ");
        buildSentence.append(lista_cambiar.getId());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public void delete(ListadeReproduccion lista) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("delete from lista where idlista = ");
        buildSentence.append(lista.getId());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
