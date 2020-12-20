package sample.entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author Andrea Jimenez
 * @version 1.1
 */
public class Cancion {
    private int ID;
    private String nombre;
    private Artista artista;
    private Genero genero;
    private Compositor compositor;
    private Date fecha_de_lanzamiento;
    private Album album;
    private int creador;
    private boolean tienda;
    private double precio;
    private int calificacion;
    private String img;
    private String link;

    /**
     * gert del id
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * set id
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * get el nombre
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * set el nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * get artista de la canción
     * @return
     */

    public Artista getArtista() {
        return artista;
    }

    /**
     * set el artista
     * @param artista
     */

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    /**
     * get del género de la canción
     * @return
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * get del género
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * set del compositor de la canción
     * @return
     */

    public Compositor getCompositor() {
        return compositor;
    }

    /**
     * set del compositor
     * @param compositor
     */

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    /**
     * get la fecha de lanzamiento
     * @return
     */

    public Date getFecha_de_lanzamiento() {
        return fecha_de_lanzamiento;
    }

    /**
     * set la fecha de lanzamiento
     * @param fecha_de_lanzamiento
     */

    public void setFecha_de_lanzamiento(Date fecha_de_lanzamiento) {
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
    }

    /**
     * get el precio de la canción si tiene alguno
     * @return
     */

    public double getPrecio() {
        return precio;
    }

    /**
     * set el precio de la canción
     * @param precio
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * get el álbum
     * @return
     */

    public Album getAlbum() {
        return album;
    }

    /**
     * set el álbum
     * @param album
     */

    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * get del creador de la cancion
     * @return
     */
    public int getCreador() {
        return creador;
    }

    /**
     * set del creador
     * @param creador
     */

    public void setCreador(int creador) {
        this.creador = creador;
    }

    /**
     * get si es para vender en la tienda
     * true = se vende
     * false = no se vende
     * @return
     */

    public boolean isTienda() {
        return tienda;
    }
    /**
     * set si es para vender en la tienda
     * true = se vende
     * false = no se vende
     * @param tienda
     */

    public void setTienda(boolean tienda) {
        this.tienda = tienda;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /**
     * constructor vacío de canción
     */

    public Cancion() {
    }

    /**
     * constructor de canción con parámetros
     * @param nombre
     * @param artista
     * @param genero
     * @param compositor
     * @param fecha_de_lanzamiento
     * @param album
     * @param precio
     */

    public Cancion(String nombre, Artista artista, Genero genero, Compositor compositor, Date fecha_de_lanzamiento, Album album, double precio, int creador, boolean tienda, int calificacion, String img, String link) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.compositor = compositor;
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
        this.album = album;
        this.precio = precio;
        this.creador = creador;
        this.tienda = tienda;
        this.calificacion = calificacion;
        this.img = img;
        this.link = link;
    }

    public Cancion(String nombre, Artista artista, Genero genero, Compositor compositor, Date fecha_de_lanzamiento, Album album, double precio, int creador, boolean tienda, int calificacion) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.compositor = compositor;
        this.fecha_de_lanzamiento = fecha_de_lanzamiento;
        this.album = album;
        this.precio = precio;
        this.creador = creador;
        this.tienda = tienda;
        this.calificacion = calificacion;
    }

    /**
     * método toString de canción
     * @return
     */

    @Override
    public String toString() {
        return getNombre();
    }

    /**
     * método equals de canción
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return ID == cancion.ID &&
                Double.compare(cancion.precio, precio) == 0 &&
                Objects.equals(nombre, cancion.nombre) &&
                Objects.equals(artista, cancion.artista) &&
                Objects.equals(genero, cancion.genero) &&
                Objects.equals(compositor, cancion.compositor) &&
                Objects.equals(fecha_de_lanzamiento, cancion.fecha_de_lanzamiento) &&
                Objects.equals(album, cancion.album);
    }

    /**
     * método de hashcode
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(ID, nombre, artista, genero, compositor, fecha_de_lanzamiento, album, precio);
    }
}
