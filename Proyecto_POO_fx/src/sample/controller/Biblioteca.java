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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.entidades.Cancion;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Biblioteca {
    Gestor gestor = new Gestor();

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
    private Button comprarBtn;

    @FXML
    private Button backBtn;

    public void initialize () throws SQLException {
        cn_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cn_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cn_artista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArtista().getNombre()));
        cn_compositor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCompositor().getNombre()));
        cn_genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().getNombre()));
        cn_album.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAlbum().getNombre()));
        cn_lanzamiento.setCellValueFactory(new PropertyValueFactory<>("fecha_de_lanzamiento"));
        cn_precio.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cn_creador.setCellValueFactory(cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCreador())));
        this.cancionesTable.setItems(getCanciones());
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/UsuarioMenu.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void comprar(ActionEvent event) throws SQLException {
        List<Cancion> canciones = cancionesTable.getSelectionModel().getSelectedItems();
        System.out.println(canciones.toString());
        for (Cancion cancion: canciones) {
            gestor.getQueue().add(cancion);
        }

    }

    public ObservableList<Cancion> getCanciones() throws SQLException {
        ObservableList<Cancion> canciones = FXCollections.observableArrayList();
        for (Cancion cancion: gestor.listCancionesUsuario(gestor.getUsuario())) {
            canciones.add(cancion);
        }
        return canciones;
    }

}
