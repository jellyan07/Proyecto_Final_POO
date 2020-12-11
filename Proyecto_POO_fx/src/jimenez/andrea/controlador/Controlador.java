package jimenez.andrea.controlador;

import com.sun.xml.internal.bind.v2.model.core.ID;
import jimenez.andrea.bl.entidades.*;
import jimenez.andrea.logica.Gestor;
import jimenez.andrea.ui.UI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Controlador {
    boolean repetido = false;
    private UI interfaz = new UI();
    private Gestor gestor = new Gestor();

    public void ejecutarPrograma() throws SQLException {
        int opcion = 0;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 9);
    }

    private void procesarOpcion (int opcion) throws SQLException {
        switch (opcion) {

            case 1:
                registrarUsuario();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                crearArtista();
                break;
            case 4:
                crearCompositor();
                break;
                /*
            case 5:
                crearGenero();
                break;
            case 6:
                crearAlbum();
                break;
                 */
            case 7:
                crearCancion();
                break;
            /* case 8:
                crearLista();
                break; */
        }
    }

    private void iniciarSesion() {
        interfaz.imprimir(" *** Inicio de Sesion ***");
        interfaz.imprimir(" - Nombre de Usuario: ");
        String nombre_usuario = interfaz.leerTexto();
        interfaz.imprimir(" - Contrasena: ");
        String password = interfaz.leerTexto();
        
    }

    private void registrarUsuario() {
        interfaz.imprimir("- Ingrese su nuevo id: ");
        int id = interfaz.leerOpcion();

        Optional<Usuario> usuario = gestor.encontrarUsuarioPorID(id);

        if(usuario.isPresent()) {
            interfaz.imprimir("- Nombre: ");
            String nombre = interfaz.leerTexto();
            interfaz.imprimir("- Primer Apellido: ");
            String apellido1 = interfaz.leerTexto();
            interfaz.imprimir("- Segundo Apellido: ");
            String apellido2 = interfaz.leerTexto();
            interfaz.imprimir("- Correo Electrónico: ");
            String correo = interfaz.leerTexto();
            interfaz.imprimir("- Contraseña: ");
            String password = interfaz.leerTexto();
            interfaz.imprimir("- Su nombre de usuario de ahora en adelante: ");
            String nombre_usuario = interfaz.leerTexto();
            interfaz.imprimir("- Ingrese el país de procedencia: ");
            String pais = interfaz.leerTexto();
            interfaz.imprimir("- Ingrese su fecha de nacimiento: ");
            String fecha = interfaz.leerTexto();
            LocalDate present = LocalDate.now();
            LocalDate nacimiento = obtenerFecha(fecha);
            int edad = calcularEdad(nacimiento, present);

            interfaz.imprimir("- Introduzca su avatar o imagen de perfil: ");
            String img = interfaz.leerTexto();

            gestor.crearUsuario(nombre, apellido1, apellido2, correo,
                    password, nombre_usuario, id, edad, pais, img);
        } else {
            interfaz.imprimir("Este artista ya existe");
        }
    }

    private int calcularEdad(LocalDate nacimiento, LocalDate present) {
        return Period.between(nacimiento, present).getYears();
}

    private LocalDate obtenerFecha() {
        interfaz.imprimir("Escriba la fecha dd/MM/yyyy");
        String fecha = interfaz.leerTexto();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDato = LocalDate.parse(fecha, fmt);
        return fechaDato;
    }

    private void crearArtista () throws SQLException {
        repetido = false;
        int ID;
        interfaz.imprimir("Ingrese el ID que tendrá el nuevo artista");
        ID = interfaz.leerOpcion();

        //Optional<Artista> artista = gestor.encontrarArtistaPorID(ID);
        //if (artista.isPresent()) {

            interfaz.imprimir("Ingrese el nombre del artista");
            String nombre = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el nombre el apellido del artista");
            String apellido = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el nombre el nombre artístico del artista");
            String nombre_artístico = interfaz.leerTexto();

            interfaz.imprimir("Ingrese la fecha de nacimiento del artista");
            LocalDate present = LocalDate.now();
            LocalDate nacimiento = obtenerFecha();
            int edad = calcularEdad(nacimiento, present);
            interfaz.imprimir("¿El artista sigue vivo?");
            interfaz.imprimir("1. Sí");
            interfaz.imprimir("2. No");

            int opcion = interfaz.leerOpcion();
            LocalDate fallecimiento = null;
            switch (opcion) {
                case 1:

                    break;
                case 2:
                    interfaz.imprimir("Ingrese la fecha de fallecimiento del artista");
                    fallecimiento = obtenerFecha();
                    break;
                default:
                    interfaz.imprimir("Opción Inválida");
                    break;
            }

            interfaz.imprimir("Ingrese el país de procedencia del artista");
            String pais_de_nacimiento = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el género musical del artista");
            String genero = interfaz.leerTexto();

          gestor.crearArtista(ID, nombre, apellido, nombre_artístico,
                    nacimiento, fallecimiento, pais_de_nacimiento, genero, edad);
        //} else {
            interfaz.imprimir("Este artista ya esta registrado");
        //}
    }

    private void crearCompositor () {
        repetido = false;
        int ID;
        interfaz.imprimir("Ingrese el ID que tendrá el nuevo artista");
        ID = interfaz.leerOpcion();
        //Optional<Compositor> compositor = gestor.encontrarCompositorPorID(ID);
        //if(compositor.isPresent()) {
            interfaz.imprimir("Ingrese el nombre del compositor");
            String nombre = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el nombre el apellido del compositor");
            String apellido = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el país de procedencia del compositor");
            String pais_de_nacimiento = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el género musical del compositor");
            String genero = interfaz.leerTexto();
            interfaz.imprimir("Ingrese la edad del compositor");
            String edad = interfaz.leerTexto();
           // gestor.crearCompositor(ID, nombre, apellido, pais_de_nacimiento, genero, edad);
       // } else {
            interfaz.imprimir("Este compositor ya existe");
       //}

    }

    private void crearCancion () {
        interfaz.imprimir("Ingrese el ID que tendrá la nueva canción");
        int id = interfaz.leerOpcion();
        //Optional<Cancion> cancion = gestor.encontrarCancionPorID(id);
        String nombre = null;
        Artista artista_cancion = null;
        Genero genero_cancion = null;
        Compositor comp_cancion = null;
        LocalDate fecha_de_lanzamiento = null;
        Album album_cancion = null;

       if (cancion .isPresent()) {
            interfaz.imprimir("Esta cancion ya existe");
              } else {
            interfaz.imprimir("Ingrese el nombre de la nueva cancion");
            nombre = interfaz.leerTexto();
            interfaz.imprimir("Ingrese el ID del artista de la canción");
            id = interfaz.leerOpcion();
            Optional<Artista> artista = gestor.encontrarArtistaPorID(id);

            if(artista.isPresent()){
                artista_cancion = artista.get();
                interfaz.imprimir("Ingrese el id del genero de la nueva cancion");
                id = interfaz.leerOpcion();
               Optional<Genero> genero = gestor.encontrarGeneroPorID(id);

                if(genero.isPresent()) {
                    genero_cancion = genero.get();
                    interfaz.imprimir("Ingrese el id del compositor de la nueva cancion");
                    id = interfaz.leerOpcion();
                    Optional<Compositor> compositor = gestor.encontrarCompositorPorID(id);

                    if(compositor.isPresent()) {
                        comp_cancion = compositor.get();
                        interfaz.imprimir("Ingrese la fecha de lanzamiento de la nueva cancion");
                        String fecha = interfaz.leerTexto();
                        LocalDate present = LocalDate.now();
                        fecha_de_lanzamiento = obtenerFecha(fecha);
                        interfaz.imprimir("Ingrese el id album al que petenece");
                        id = interfaz.leerOpcion();
                       Optional<Album> album = gestor.encontrarAlbumPorID(id);

                       if(album.isPresent()) {
                           gestor.crearCancion(id, nombre, artista_cancion,genero_cancion,comp_cancion,fecha_de_lanzamiento,album_cancion);
                        } else {
                            interfaz.imprimir("El album no existe");
                        }
                    } else {
                        interfaz.imprimir("El compositor no existe");
                    }

                } else {
                    interfaz.imprimir("El genero no existe");
                }

           } else {
                 interfaz.imprimir("El artista no existe");
            }
       }
    }

    private void crearLista () {

    }
}
