package sample.gestor;

import javafx.scene.control.TextField;
import sample.dao.*;
import sample.entidades.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Gestor {

    private Connection conection;
    Configuracion conf;

    private static Usuario usuario;
    private ArtistaDAO artistas;
    private UsuarioDAO usuarios;
    private CompositorDAO compositores;
    private GeneroDAO generos;
    private AlbumDAO albumes;
    private ListaReproduccionDAO listas;
    private CancionDAO canciones;
    private AdminDAO admins;

    public Gestor() {
        this.conf = new Configuracion();
        try {
            Optional<String> driver = conf.getDriver();
            Optional<String> cnxStr = conf.getDBUrl();
            Optional<String> usr = conf.getUserName();
            Optional<String> pwd = conf.getPassword();
            if (driver.isPresent() && cnxStr.isPresent() && usr.isPresent() && pwd.isPresent()) {
                Class.forName(driver.get()).newInstance();
                this.conection = DriverManager.getConnection(cnxStr.get(),
                        usr.get(), pwd.get());
                this.usuarios = new UsuarioDAO(this.conection);
                this.generos = new GeneroDAO(this.conection);
                this.compositores = new CompositorDAO(this.conection);
                this.albumes = new AlbumDAO(this.conection);
                this.listas = new ListaReproduccionDAO(this.conection);
                this.artistas = new ArtistaDAO(this.conection);
                this.canciones = new CancionDAO(this.conection);
                this.admins = new AdminDAO(this.conection);
            }


        } catch (Exception e) {
            System.out.println("Cant connect to db");
            e.printStackTrace();
        }
    }

    public void setUsuario (Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario () {
       return usuario;
    }

    // ADMIN

    public void crearAdmin(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, String img) throws SQLException {
        Admin admin = new Admin(nombre, apellido1, apellido2, correo, password, nombre_usuario, img);
        admins.save(admin);
    }

    public Admin getAdmin() throws SQLException {
        return admins.getAdmin();
    }

    // USUARIOS

    public void crearUsuario(String nombre, String apellido1, String apellido2, String correo, String password, String nombre_usuario, int edad, String pais, String img) throws SQLException {
        Usuario usuario = new Usuario(nombre, apellido1, apellido2, correo, password, nombre_usuario, edad, pais, img);
        usuarios.save(usuario);
    }

    public List<Usuario> listUsuarios() throws SQLException {
        return usuarios.findAll();
    }

    public Usuario encontrarUsuarioPorID(int id) throws SQLException {
        Usuario usuario = usuarios.findUsuarioByID(id);
        return usuario;
    }

    //ARTISTAS

    public void crearArtista(String nombre, String apellido, String nombre_artístico, String fecha_de_nacimiento, String fecha_de_defuncion, String pais_de_nacimiento, Genero genero, int edad) throws SQLException {
        Date nacimiento = null;
        Date defuncion = null;
        try {
            nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_de_nacimiento);
            defuncion = fecha_de_defuncion != null ? new SimpleDateFormat("yyyy-MM-dd").parse(fecha_de_defuncion): null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Artista artista = new Artista(nombre, apellido, nombre_artístico, nacimiento, defuncion, pais_de_nacimiento, genero, edad);
        artistas.save(artista);
    }

    public void editarArtista(String nombre, String apellido, String nombre_artistico, String fecha_nacimiento, String fecha_defuncion, String pais, Genero genero, int edad, Artista artista_cambiar) throws SQLException {
        Date nacimiento = null;
        Date defuncion = null;
        try {
            nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_nacimiento);
            defuncion = fecha_defuncion != null ? new SimpleDateFormat("yyyy-MM-dd").parse(fecha_defuncion): null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Artista artista = new Artista(nombre, apellido, nombre_artistico, nacimiento, defuncion, pais, genero, edad);
        artistas.edit(artista, artista_cambiar);
    }

    public void deleteArtist(Artista artista) throws SQLException {
        artistas.delete(artista);
    }

    public List<Artista> listArtistas() throws SQLException {
        return artistas.findAll();
    }

    public Artista encontrarArtistaPorID(int id) throws SQLException {
        Artista artista = artistas.findArtistaByID(id);
        return artista;
    }

    //COMPOSITORES

    public void crearCompositor(String nombre, String apellido, String pais_de_nacimiento, Genero genero, int edad) throws SQLException {
        Compositor compositor = new Compositor(nombre, apellido, pais_de_nacimiento, genero, edad);
        compositores.save(compositor);
    }

    public List<Compositor> listCompositores() throws SQLException {
        return compositores.findAll();
    }

    public Compositor encontrarCompositorPorID(int id) throws SQLException {
        Compositor compositor = compositores.findCompositorByID(id);
        return compositor;
    }

    public void editarCompositor(String nombre, String apellido, String pais, Genero genero, int edad, Compositor compositor_cambiar) throws SQLException {
        Compositor compositor = new Compositor(nombre, apellido, pais, genero, edad);
        compositores.edit(compositor, compositor_cambiar);
    }

    public void deleteCompositor(Compositor compositor_seleccionado) throws SQLException {
        compositores.delete(compositor_seleccionado);
    }

    //GENEROS

    public void crearGenero(String nombre, String descripcion) throws SQLException {
        Genero genero = new Genero(nombre, descripcion);
        generos.save(genero);
    }

    public List<Genero> listGeneros() throws SQLException {
        return generos.findAll();
    }

    public Genero encontrarGeneroPorID(int id) throws SQLException {
        Genero genero = generos.findGeneroByID(id);
        return genero;
    }

    public void deleteGenero(Genero genero_seleccionado) throws SQLException {
        generos.delete(genero_seleccionado);
    }

    //CANCIONES

    public void crearCancion(String nombre, Artista artista, Genero genero, Compositor compositor, String fecha_de_lanzamiento, Album album, double precio, int creador, boolean tienda, int calificacion, String img, String link) throws SQLException {
        Date lanzamiento = null;
        try {
            lanzamiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_de_lanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Cancion cancion = new Cancion(nombre, artista, genero, compositor, lanzamiento, album, precio, creador, tienda, calificacion, img, link);
        canciones.save(cancion);
    }

    public void editarCancion(String nombre, Artista artista, Genero genero, Compositor compositor, String fecha_de_lanzamiento, Album album, double precio, int creador, boolean tienda, int calificacion, Cancion cancion_cambiar) throws SQLException {
        Date lanzamiento = null;
        try {
            lanzamiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_de_lanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Cancion cancion = new Cancion(nombre, artista, genero, compositor, lanzamiento, album, precio, creador, tienda, calificacion);
        canciones.edit(cancion, cancion_cambiar);
    }

    public List<Cancion> listCanciones() throws SQLException {
        return canciones.findAll();
    }

    public List<Cancion> listCancionesUsuario(Usuario usuario) throws SQLException {
        return canciones.findAllUsuario(usuario);
    }

    public Cancion encontrarCancionPorID(int id) throws SQLException {
        Cancion cancion = canciones.findCancionByID(id);
        return cancion;
    }

    public void deleteCancion(Cancion cancion_seleccionada) throws SQLException {
        canciones.delete(cancion_seleccionada);
    }

    //ALBUMES

    public void crearAlbum(String nombre, String fecha_lanzamiento, String imagen) throws SQLException {
        Date lanzamiento = null;
        try {
            lanzamiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_lanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Album album = new Album(nombre, lanzamiento, imagen);
        albumes.save(album);
    }

    public void editarAlbm(String nombre, String fecha_lanzamiento, String img, Album album_cambiar) throws SQLException {
        Date lanzamiento = null;
        try {
            lanzamiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_lanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Album album = new Album(nombre, lanzamiento, img);
        albumes.edit(album, album_cambiar);
    }

    public void deleteAlbum(Album album) throws SQLException {
        albumes.delete(album);
    }

    public List<Album> listAlbumes() throws SQLException {
        return albumes.findAll();
    }

    public Album encontrarAlbumPorID(int id) throws SQLException {
        Album album = albumes.findAlbumByID(id);
        return album;
    }

    //LISTAS

    public void crearLista(int creador, String nombre, String fecha_de_creacion, int calificacion, List<Cancion> canciones) throws SQLException {
        Date creacion = null;
        try {
            creacion = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_de_creacion);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ListadeReproduccion lista = new ListadeReproduccion(creador, nombre, creacion, calificacion);
        listas.save(lista, canciones);
    }

    public List<ListadeReproduccion> listListas() throws SQLException {
        return listas.findAll();
    }

    public List<Cancion> listCancionesLista(ListadeReproduccion lista_seleccionada) throws SQLException {
        return listas.findSongsfromList(lista_seleccionada);
    }

    public ListadeReproduccion encontrarListaPorID(int id) throws SQLException {
        ListadeReproduccion lista = listas.findListaByID(id);
        return lista;
    }

    public void deleteLista(ListadeReproduccion lista_seleccionada) throws SQLException {
        listas.delete(lista_seleccionada);
    }

    public void agregarALista(ListadeReproduccion lista_input, List<Cancion> canciones) throws SQLException {
        for (Cancion cancion:canciones) {
            listas.saveCancionToLista(cancion, lista_input.getId());
        }
    }
}
