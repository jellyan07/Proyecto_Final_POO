package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.entidades.*;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;

public class AdminMenu {

    Gestor gestor = new Gestor();

    @FXML
    private TableView<Artista> artistsTable;

    @FXML
    private TableColumn<Artista, String> a_nombre_artistico;

    @FXML
    private TableColumn<Artista, String> a_nombre;

    @FXML
    private TableColumn<Artista, String> a_apellido;

    @FXML
    private TableColumn<Artista, String> a_pais;

    @FXML
    private TableColumn<Artista, String> a_nacimiento;

    @FXML
    private TableColumn<Artista, String> a_defuncion;

    @FXML
    private TableColumn<Artista, String> a_genero;

    @FXML
    private TableColumn<Artista, String> a_edad;

    @FXML
    private TableColumn<Artista, String> a_id;

    @FXML
    private Button registrarArtistaBtn;

    @FXML
    private Button borrarArtistaBtn;

    @FXML
    private Button editarArtistaBtn;

    @FXML
    private TableView<Compositor> compositoresTable;

    @FXML
    private TableColumn<Compositor, String> c_id;

    @FXML
    private TableColumn<Compositor, String> c_nombre;

    @FXML
    private TableColumn<Compositor, String> c_apellido;

    @FXML
    private TableColumn<Compositor, String> c_pais;

    @FXML
    private TableColumn<Compositor, String> c_genero;

    @FXML
    private TableColumn<Compositor, String> c_edad;

    @FXML
    private TableColumn<Compositor, String> d_id;

    @FXML
    private Button registrarCompositorBtn;

    @FXML
    private Button borrarCompositorBtn;

    @FXML
    private Button editarCompositorBtn;

    @FXML
    private TableView<Genero> generosTable;

    @FXML
    private TableColumn<Genero, String> g_nombre;

    @FXML
    private TableColumn<Genero, String> g_descripcion;

    @FXML
    private TableColumn<Genero, String> g_id;

    @FXML
    private Button registrarGeneroBtn;

    @FXML
    private Button borrarGeneroBtn;

    @FXML
    private Button editarGeneroBtn;

    @FXML
    private TableView<Album> albumesTable;

    @FXML
    private TableColumn<Album, String> ab_nombre;

    @FXML
    private TableColumn<Album, String> ab_lanzamiento;

    @FXML
    private TableColumn<Album, String> ab_id;

    @FXML
    private TableColumn<Album, String> ab_img;

    @FXML
    private Button registrarArlbumBtn;

    @FXML
    private Button borrarAlbumBtn;

    @FXML
    private Button editarAlbumBtn;

    @FXML
    private TableView<ListadeReproduccion> listasTable;

    @FXML
    private TableColumn<ListadeReproduccion, String> l_nombre;

    @FXML
    private TableColumn<ListadeReproduccion, String> l_creacion;

    @FXML
    private TableColumn<ListadeReproduccion, String> l_calificacion;

    @FXML
    private TableColumn<ListadeReproduccion, String> l_id;

    @FXML
    private TableColumn<ListadeReproduccion, String> l_creador;

    @FXML
    private TableView<Cancion> table_canciones_lista;

    @FXML
    private TableColumn<Cancion, String> t_cancion_lista_nombre;

    @FXML
    private TableColumn<Cancion, String> t_cancion_lista_artista;

    @FXML
    private TableColumn<Cancion, String> t_cancion_lista_id;

    @FXML
    private Button registrarListaBtn;

    @FXML
    private Button borrarListaBtn;

    @FXML
    private Button editarListaBtn;

    @FXML
    private Button agregarCancion;

    @FXML
    private TableView<Cancion> cancionesTable;

    @FXML
    private TableColumn<Cancion, String> cn_nombre;

    @FXML
    private TableColumn<Cancion, String> cn_artista;

    @FXML
    private TableColumn<Cancion, String> cn_creador;

    @FXML
    private TableColumn<Cancion, String> cn_album;

    @FXML
    private TableColumn<Cancion, String> cn_compositor;

    @FXML
    private TableColumn<Cancion, String> cn_genero;

    @FXML
    private TableColumn<Cancion, String> cn_lanzamiento;

    @FXML
    private TableColumn<Cancion, String> cn_precio;

    @FXML
    private TableColumn<Cancion, String> cn_id;

    @FXML
    void agregarCancion(ActionEvent event) {

    }

    @FXML
    private Button registrarCancionBtn;

    @FXML
    private Button borrarCancionBtn;

    @FXML
    private Button editarCancionBtn;


    @FXML
    void borrarAlbum(ActionEvent event) {
        Album album_seleccionado = albumesTable.getSelectionModel().getSelectedItem();
        System.out.println(album_seleccionado.toString());
        try {
            gestor.deleteAlbum(album_seleccionado);
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void borrarArtista(ActionEvent event) {
        Artista artista_seleccionado = artistsTable.getSelectionModel().getSelectedItem();
        System.out.println(artista_seleccionado.toString());
        try {
            gestor.deleteArtist(artista_seleccionado);
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void borrarCompositor(ActionEvent event) {
        Compositor compositor_seleccionado = compositoresTable.getSelectionModel().getSelectedItem();
        System.out.println(compositor_seleccionado.toString());
        try {
            gestor.deleteCompositor(compositor_seleccionado);
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void borrarCancion(ActionEvent event) throws IOException {
        Cancion cancion_seleccionada = cancionesTable.getSelectionModel().getSelectedItem();
        System.out.println(cancion_seleccionada.toString());
        try {
            gestor.deleteCancion(cancion_seleccionada);
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void borrarGenero(ActionEvent event) {
        Genero genero_seleccionado = generosTable.getSelectionModel().getSelectedItem();
        System.out.println(genero_seleccionado.toString());
        try {
            gestor.deleteGenero(genero_seleccionado);
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void borrarLista(ActionEvent event) {
        ListadeReproduccion lista_seleccionada = listasTable.getSelectionModel().getSelectedItem();
        System.out.println(lista_seleccionada.toString());
        try {
            gestor.deleteLista(lista_seleccionada);
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void editarAlbum(ActionEvent event) {
        Album album_seleccionado = albumesTable.getSelectionModel().getSelectedItem();
        System.out.println(album_seleccionado.toString());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/EditAlbum.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            EditAlbum controller = fxmlLoader.getController();
            controller.initialize(album_seleccionado);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void editarArtista(ActionEvent event) throws SQLException {
        Artista artista_seleccionado = artistsTable.getSelectionModel().getSelectedItem();
        System.out.println(artista_seleccionado.toString());
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/EditArtist.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        EditArtist controller = fxmlLoader.getController();
        controller.initialize(artista_seleccionado);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void editarCompositor(ActionEvent event) throws SQLException {
        Compositor compositor_seleccionado = compositoresTable.getSelectionModel().getSelectedItem();
        System.out.println(compositor_seleccionado.toString());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/EditCompositor.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            EditCompositor controller = fxmlLoader.getController();
            controller.initialize(compositor_seleccionado);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void editarGenero(ActionEvent event) throws SQLException {
        Genero genero_seleccionado = generosTable.getSelectionModel().getSelectedItem();
        System.out.println(genero_seleccionado.toString());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/EditGenero.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            EditGenero controller = fxmlLoader.getController();
            controller.initialize(genero_seleccionado);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void editarCancion(ActionEvent event) throws SQLException {
        Cancion cancion_seleccionado = cancionesTable.getSelectionModel().getSelectedItem();
        System.out.println(cancion_seleccionado.toString());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/EditCancion.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            EditCancion controller = fxmlLoader.getController();
            controller.initialize(cancion_seleccionado);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void editarLista(ActionEvent event) {

    }

    @FXML
    void registrarAlbum(ActionEvent event) throws IOException, SQLException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterAlbum.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void registrarCompositor(ActionEvent event) throws IOException, SQLException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterCompositor.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void registrarGenero(ActionEvent event) throws IOException, SQLException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterGenero.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void registrarLista(ActionEvent event) throws SQLException, IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterLista.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void registrarCancion(ActionEvent event) throws IOException, SQLException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterCancion.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void registrarArtista(ActionEvent event) throws IOException, SQLException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterArtist.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    public void initialize () throws SQLException {
        a_nombre_artistico.setCellValueFactory(new PropertyValueFactory<>("nombre_artistico"));
        a_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        a_apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        a_pais.setCellValueFactory(new PropertyValueFactory<>("pais_de_nacimiento"));
        a_nacimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_de_nacimiento"));
        a_defuncion.setCellValueFactory(new PropertyValueFactory<>("fecha_de_defuncion"));
        a_genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().getNombre()));
        a_edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        a_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.artistsTable.setItems(getArtistas());

        c_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        c_nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        c_apellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        c_edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        c_genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().getNombre()));
        c_pais.setCellValueFactory(new PropertyValueFactory<>("pais_de_nacimiento"));
        this.compositoresTable.setItems(getCompositores());

        g_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        g_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        g_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.generosTable.setItems(getGeneros());

        ab_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        ab_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ab_lanzamiento.setCellValueFactory(new PropertyValueFactory<>("fecha_lanzamiento"));
        ab_img.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        this.albumesTable.setItems(getAlbumes());

        l_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        l_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        l_creacion.setCellValueFactory(new PropertyValueFactory<>("fecha_de_creacion"));
        l_calificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        l_creador.setCellValueFactory(new PropertyValueFactory<>("creador"));
        this.listasTable.setItems(getlistas());

        // (cellData -> new SimpleStringProperty(cellData.getValue()))

        cn_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cn_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cn_artista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArtista().getNombre()));
        cn_compositor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCompositor().getNombre()));
        cn_genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().getNombre()));
        cn_album.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAlbum().getNombre()));
        cn_lanzamiento.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cn_precio.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cn_creador.setCellValueFactory(cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCreador())));
        this.cancionesTable.setItems(getCanciones());

        t_cancion_lista_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        t_cancion_lista_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        t_cancion_lista_artista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArtista().getNombre()));

        listasTable.setOnMouseClicked(event -> {
            ListadeReproduccion lista_seleccionada = listasTable.getSelectionModel().getSelectedItem();
            try {
                table_canciones_lista.setItems(getCancionesLista(lista_seleccionada));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private ObservableList<Cancion> getCancionesLista(ListadeReproduccion lista_seleccionada) throws SQLException {
        ObservableList<Cancion> canciones = FXCollections.observableArrayList();
        for (Cancion cancion: gestor.listCancionesLista(lista_seleccionada)) {
            canciones.add(cancion);
        }
        return canciones;
    }

    public ObservableList<Artista> getArtistas() throws SQLException {
    ObservableList<Artista> artistas = FXCollections.observableArrayList();
        for (Artista artista: gestor.listArtistas()) {
            artistas.add(artista);
        }
        return artistas;
    }

    public ObservableList<Compositor> getCompositores() throws SQLException {
        ObservableList<Compositor> compositores = FXCollections.observableArrayList();
        for (Compositor compositor: gestor.listCompositores()) {
            compositores.add(compositor);
        }
        return compositores;
    }

    public ObservableList<Album> getAlbumes() throws SQLException {
        ObservableList<Album> albumes = FXCollections.observableArrayList();
        for (Album album: gestor.listAlbumes()) {
            albumes.add(album);
        }
        return albumes;
    }

    public ObservableList<Genero> getGeneros() throws SQLException {
        ObservableList<Genero> generos = FXCollections.observableArrayList();
        for (Genero genero: gestor.listGeneros()) {
            generos.add(genero);
        }
        return generos;
    }

    public ObservableList<ListadeReproduccion> getlistas() throws SQLException {
        ObservableList<ListadeReproduccion> listas = FXCollections.observableArrayList();
        for (ListadeReproduccion lista: gestor.listListas()) {
            listas.add(lista);
        }
        return listas;
    }

    public ObservableList<Cancion> getCanciones() throws SQLException {
        ObservableList<Cancion> canciones = FXCollections.observableArrayList();
        for (Cancion cancion: gestor.listCanciones()) {
            canciones.add(cancion);
        }
        return canciones;
    }

}
