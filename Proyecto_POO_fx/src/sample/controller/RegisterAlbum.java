package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.entidades.Genero;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RegisterAlbum {

    private Gestor gestor = new Gestor();


    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputImg;

    @FXML
    private Button registrarBtn;

    @FXML
    private DatePicker inputLanzamiento;

    @FXML
    void registrarAlbum(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputNombre.getText() != null &&
                inputImg.getText() != null &&
                inputLanzamiento.getValue() != null) {

            String nombre = inputNombre.getText();
            String img = inputImg.getText();
            String fecha_lanzamiento = inputLanzamiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            gestor.crearAlbum(nombre, fecha_lanzamiento, img);

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
            stage.setTitle("Espacios en blanco no permitidos");
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
