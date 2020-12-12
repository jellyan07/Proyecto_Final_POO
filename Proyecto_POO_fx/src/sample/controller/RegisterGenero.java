package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class RegisterGenero {

    private Gestor gestor = new Gestor();


    @FXML
    private TextField inputNombre;

    @FXML
    private Button registrarBtn;

    @FXML
    private TextField inputDescripcion;

    @FXML
    private DatePicker inputLanzamiento;

    @FXML
    void registrarAlbum(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputDescripcion.getText() != null) {

            String nombre = inputNombre.getText();
            String descripcion = inputDescripcion.getText();

            gestor.crearGenero(nombre, descripcion);

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
            stage.setTitle("Espacios en blanco no permitidos");
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
