package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.entidades.Cancion;
import sample.entidades.ListadeReproduccion;
import sample.gestor.Gestor;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class UsuarioMenu {

    Gestor gestor = new Gestor();

    @FXML
    private Button tiendaBtn;

    @FXML
    private Button perfilBtn;

    @FXML
    private Button bibliotecaBtn;

    @FXML
    private TableView<ListadeReproduccion> listas;

    @FXML
    private TableColumn<ListadeReproduccion, String> lista_nombre;

    @FXML
    private TableView<Cancion> queue;

    @FXML
    private TableColumn<Cancion, String> queueCancion;

    @FXML
    private TableColumn<Cancion, String> queueArtista;

    @FXML
    private Button crearBtn;

    @FXML
    private Button editarBtn;

    @FXML
    private Button borarBtn;

    @FXML
    private Slider track;

    @FXML
    private Slider volume;

    @FXML
    private Button play;

    @FXML
    private Button previous;

    @FXML
    private Button next;

    @FXML
    private Label cancionLb;

    @FXML
    private Label artistaLb;

    @FXML
    private TextField inputLista;

    @FXML
    private Button buscarListaBtn;

    @FXML
    private TextField inputCancion;

    @FXML
    private Button buscarCancionBtn;

    @FXML
    private ImageView foto;

    @FXML
    private Button crearCancionBtn;

    @FXML
    private Button editarCancion;

    @FXML
    private Button borrarCancion;

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/MainMenu.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void borrar(ActionEvent event) {

    }

    @FXML
    void borrarCancion(ActionEvent event) {

    }

    @FXML
    void buscarCancion(ActionEvent event) throws SQLException {
        this.queue.getItems().clear();
        ObservableList<Cancion> cancionesBusqueda = FXCollections.observableArrayList();
        if (inputCancion != null) {
            for(Cancion cancion : gestor.getQueue()) {
                if(cancion.getNombre().contains(inputCancion.getText())) {
                    cancionesBusqueda.add(cancion);
                }
            }
            this.queue.setItems(cancionesBusqueda);
        } else {
            queueCancion.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            queueArtista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArtista().getNombre()));
            this.queue.setItems(getCancionesQueue());
        }
    }

    @FXML
    void buscarLista(ActionEvent event) {

    }

    @FXML
    void crearCancion(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterCancionUsuario.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void crearLista(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    public void initialize () throws SQLException {
        queueCancion.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        queueArtista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArtista().getNombre()));
        listas.setOnMouseClicked(event -> {
            ListadeReproduccion lista_seleccionada = listas.getSelectionModel().getSelectedItem();
            try {
                queue.setItems(getCancionesLista(lista_seleccionada));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });


        File file = new File(gestor.getUsuario().getImg());
        Image image = new Image(file.toURI().toString());
        foto.setImage(image);
    }

    private ObservableList<Cancion> getCancionesLista(ListadeReproduccion lista_seleccionada) throws SQLException {
        ObservableList<Cancion> canciones = FXCollections.observableArrayList();
        for (Cancion cancion: gestor.listCancionesLista(lista_seleccionada)) {
            canciones.add(cancion);
        }
        return canciones;
    }

    @FXML
    void biblioteca(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/Biblioteca.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void perfil(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/EditUsuario.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void tienda(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/Tienda.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    public ObservableList<Cancion> getCancionesQueue() throws SQLException {
        ObservableList<Cancion> canciones = FXCollections.observableArrayList();
        for (Cancion cancion: gestor.getQueue()) {
            canciones.add(cancion);
        }
        return canciones;
    }

}
