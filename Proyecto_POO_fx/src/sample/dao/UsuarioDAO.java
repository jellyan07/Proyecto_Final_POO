package sample.dao;

import sample.entidades.Genero;
import sample.entidades.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Connection cnx;

    public UsuarioDAO(Connection cnx){
        this.cnx = cnx;
    }

    public void save(Usuario material) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("insert into usuario (nombre, apellido1, apellido2, correo, user_password, nombre_usuario, edad, pais, img)");
        buildSentence.append(" values ('");
        buildSentence.append(material.getNombre());
        buildSentence.append("','");
        buildSentence.append(material.getApellido1());
        buildSentence.append("','");
        buildSentence.append(material.getApellido2());
        buildSentence.append("','");
        buildSentence.append(material.getCorreo());
        buildSentence.append("','");
        buildSentence.append(material.getPassword());
        buildSentence.append("','");
        buildSentence.append(material.getNombre_usuario());
        buildSentence.append("',");
        buildSentence.append(material.getEdad());
        buildSentence.append(",'");
        buildSentence.append(material.getPais());
        buildSentence.append("','");
        buildSentence.append(material.getImg());
        buildSentence.append("')");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public List<Usuario> findAll() throws SQLException {
        ArrayList<Usuario> listOfResults = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from usuario");
        while(result.next()){
            Usuario uno = new Usuario();
            uno.setId(result.getInt("idusuario"));
            uno.setNombre(result.getString("nombre"));
            uno.setApellido1(result.getString("apellido1"));
            uno.setApellido2(result.getString("apellido2"));
            uno.setCorreo(result.getString("correo"));
            uno.setNombre_usuario(result.getString("nombre_usuario"));
            uno.setPassword(result.getString("user_password"));
            uno.setEdad(result.getInt("edad"));
            uno.setPais(result.getString("pais"));
            uno.setImg(result.getString("img"));
            listOfResults.add(uno);
        }
        return listOfResults;
    }

    public Usuario findUsuarioByID(int id) throws SQLException {
        List<Usuario> usuarios = findAll();
        for (Usuario usuario: usuarios) {
            if(usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }


    public void editUsuario(String nombre, String apellido1, String apellido2, String correo, String nombre_usuario, int edad, String pais, String img, int id_usuario) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("update into usuario set nombre = '");
        buildSentence.append(nombre);
        buildSentence.append("', apellido1 = '");
        buildSentence.append(apellido1);
        buildSentence.append("', apellido2 = '");
        buildSentence.append(apellido2);
        buildSentence.append("', correo = '");
        buildSentence.append(correo);
        buildSentence.append("', nombre_usuario = '");
        buildSentence.append(nombre_usuario);
        buildSentence.append("', edad = ");
        buildSentence.append(edad);
        buildSentence.append(", pais = '");
        buildSentence.append(pais);
        buildSentence.append("', img = '");
        buildSentence.append(img);
        buildSentence.append(" where idusuario = ");
        buildSentence.append(id_usuario);
        buildSentence.append(";");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }
}
