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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.entidades.Cancion;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegisterLista {

    private Gestor gestor = new Gestor();

    @FXML
    private TextField listaNombre;

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
    void registrarlista(ActionEvent event) throws SQLException, IOException {

        if(listaNombre.getText() != null &&
                t_canciones_elegir.getSelectionModel().getSelectedItems() != null) {

            String nombre = listaNombre.getText();
            int creador = 101;
            String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            List<Cancion> canciones = getItems(t_canciones_elegir.getSelectionModel().getSelectedItems());
            int promedio = 0;
            int cont = 0;
            for (Cancion cancion: canciones) {
                promedio = promedio + cancion.getCalificacion();
                cont++;
            }
            int calificacion = promedio/cont;

            gestor.crearLista(creador, nombre, fecha, calificacion, canciones);

            Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

            Parent ruta = FXMLLoader.load(getClass().getResource("../ui/AdminMenu.fxml"));

            Scene nueva_escena = new Scene(ruta);
            escenaPrincipal.hide();

            escenaPrincipal.setScene(nueva_escena);
            escenaPrincipal.show();
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
    void back(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/AdminMenu.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

}
