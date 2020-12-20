package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.entidades.Album;
import sample.entidades.Cancion;
import sample.entidades.ListadeReproduccion;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddCancionALista {

    private Gestor gestor = new Gestor();

    @FXML
    private ChoiceBox<ListadeReproduccion> inputLista;
    ListadeReproduccion lista_input = null;

    @FXML
    private Button registrarBtn;

    @FXML
    private TableView<Cancion> t_canciones_elegir;

    @FXML
    private TableColumn<Cancion, String> c_id;

    @FXML
    private TableColumn<Cancion, String> c_nombre;

    @FXML
    private TableColumn<Cancion, String> c_artista;

    public void initialize () throws SQLException {

        c_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        c_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        c_artista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArtista().getNombre()));
        this.t_canciones_elegir.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.t_canciones_elegir.setItems(getCanciones());

        //Albumes

        if(gestor.listAlbumes() == null || gestor.listAlbumes().isEmpty()) {

        } else {
            for (ListadeReproduccion lista:
                    gestor.listListas()) {
                inputLista.getItems().add(lista);
            }
        }

        inputLista.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> lista_input = newValue );

    }

    public ObservableList<Cancion> getCanciones() throws SQLException {
        ObservableList<Cancion> canciones = FXCollections.observableArrayList();
        for (Cancion cancion: gestor.listCanciones()) {
            canciones.add(cancion);
        }
        return canciones;
    }

    public List getItems (ObservableList<Cancion> selecciones) {
        List<Cancion> canciones = new ArrayList<>();
        for (Cancion cancion: selecciones) {
            canciones.add(cancion);
        }
        return canciones;
    }

    @FXML
    void agregarCancion(ActionEvent event) throws SQLException, IOException {

        if(lista_input != null &&
                t_canciones_elegir.getSelectionModel().getSelectedItems() != null) {


            List<Cancion> canciones = getItems(t_canciones_elegir.getSelectionModel().getSelectedItems());

            gestor.agregarALista(lista_input, canciones);

            // get a handle to the stage
            Stage stage = (Stage) registrarBtn.getScene().getWindow();
            // do what you have to do
            stage.close();
        } else {
            // Espacios en blanco
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/AlertBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("La lista debe tener nombre y al menos una canción");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) backBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
