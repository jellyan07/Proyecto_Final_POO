package sample.dao;

import sample.entidades.Admin;
import sample.entidades.Artista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    Connection cnx;

    public AdminDAO(Connection cnx){
        this.cnx = cnx;
    }

    public void save(Admin material) throws SQLException {
        Statement stmt = cnx.createStatement();
        StringBuilder buildSentence = new StringBuilder("insert into admin (nombre, apellido1, apellido2, correo, adminPassword, nombre_usuario, img)");
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
        buildSentence.append("','");
        buildSentence.append(material.getImg());
        buildSentence.append("')");
        System.out.println(buildSentence.toString());
        stmt.execute(buildSentence.toString());
    }

    public Admin getAdmin() throws SQLException {
        Admin Result = new Admin();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("select * from admin");
        while(result.next()) {
            Admin uno = new Admin();
            uno.setNombre(result.getString("nombre"));
            uno.setApellido1(result.getString("apellido1"));
            uno.setApellido1(result.getString("apellido2"));
            uno.setCorreo(result.getString("correo"));
            uno.setPassword(result.getString("adminPassword"));
            uno.setNombre_usuario(result.getString("nombre_usuario"));
            uno.setImg(result.getString("img"));
            Result = uno;
        }
        return Result;
    }
}
