package sample.dao;

import sample.entidades.Artista;
import sample.entidades.Compositor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompositorDAO {


    Connection cnx;

    public CompositorDAO(Connection cnx){
        this.cnx = cnx;
    }
    private GeneroDAO generoDAO = new GeneroDAO(cnx);

    public void save(Compositor material) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("insert into compositor (nombre,apellido,pais_nacimiento, id_genero, edad)");
        buildSentence.append(" values ('");
        buildSentence.append(material.getNombre());
        buildSentence.append("','");
        buildSentence.append(material.getApellido());
        buildSentence.append("','");
        buildSentence.append(material.getPais_de_nacimiento());
        buildSentence.append("',");
        buildSentence.append(material.getGenero().getID());
        buildSentence.append(",");
        buildSentence.append(material.getEdad());
        buildSentence.append(")");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public List<Compositor> findAll() throws SQLException {
        ArrayList<Compositor> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from compositor");
        while(result.next()){
            Compositor uno = new Compositor();
            uno.setID(result.getInt("idcompositor"));
            uno.setNombre(result.getString("nombre"));
            uno.setApellido(result.getString("apellido"));
            uno.setGenero(generoDAO.findGeneroByID(result.getInt("id_genero")));
            uno.setPais_de_nacimiento(result.getString("pais_nacimiento"));
            uno.setEdad(result.getInt("edad"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public Compositor findCompositorByID(int id) throws SQLException {
        List<Compositor> compositores = findAll();
        for (Compositor compositor: compositores) {
            if(compositor.getID() == id) {
                return compositor;
            }
        }
        return null;
    }

    public void edit(Compositor compositor, Compositor compositor_cambiar) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("update into compositor set nombre = '");
        buildSentence.append(compositor.getNombre());
        buildSentence.append("', apellido = '");
        buildSentence.append(compositor.getApellido());
        buildSentence.append("', pais_nacimiento = '");
        buildSentence.append(compositor.getPais_de_nacimiento());
        buildSentence.append("', id_genero = ");
        buildSentence.append(compositor.getGenero().getID());
        buildSentence.append(", edad = ");
        buildSentence.append(compositor.getEdad());
        buildSentence.append(" where idcompositor = ");
        buildSentence.append(compositor_cambiar.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public void delete(Compositor compositor) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("delete from compositor where idcompositor = ");
        buildSentence.append(compositor.getID());
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
