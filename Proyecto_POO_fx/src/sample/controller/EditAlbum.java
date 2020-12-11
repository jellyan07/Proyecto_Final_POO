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
import sample.entidades.Album;
import sample.entidades.Artista;
import sample.entidades.Genero;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class EditAlbum {

    private Gestor gestor = new Gestor();
    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputImg;

    @FXML
    private Button registrarBtn;

    @FXML
    private DatePicker inputLanzamiento;
    Album album_cambiar = null;

    public void initialize (Album album) throws SQLException {
        album_cambiar = album;
        inputNombre.setText(album.getNombre());
        inputImg.setText(album.getImagen());
        inputLanzamiento.setValue(convertToLocalDateViaInstant(album.getFecha_lanzamiento()));
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        if(dateToConvert != null) {
            LocalDate date = Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            return date;
        }
        return null;
    }

    @FXML
    void registrarAlbum(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputNombre.getText() != null &&
                inputImg.getText() != null &&
                inputLanzamiento.getValue() != null) {

            String nombre = inputNombre.getText();
            String img = inputImg.getText();
            String fecha_lanzamiento = inputLanzamiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            gestor.editarAlbm(nombre, fecha_lanzamiento, img, album_cambiar);

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
