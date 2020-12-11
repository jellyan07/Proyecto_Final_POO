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

public class EditArtist {

    private Gestor gestor = new Gestor();

    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputApellido;

    @FXML
    private TextField inputNombreArtistico;

    @FXML
    private DatePicker inputNacimiento;

    @FXML
    private DatePicker inputDefuncion;

    @FXML
    private Button registrarBtn;

    @FXML
    private ChoiceBox<Genero> lista_generos;
    private Genero genero_input = null;

    @FXML
    private ChoiceBox<String> lista_paises;
    private String pais = null;

    private Artista artista_cambiar = null;

    public void initialize (Artista artista) throws SQLException {
        artista_cambiar = artista;
        inputNombre.setText(artista.getNombre());
        inputApellido.setText(artista.getApellido());
        inputNombreArtistico.setText(artista.getNombre_artistico());
        inputNacimiento.setValue(convertToLocalDateViaInstant(artista.getFecha_de_nacimiento()));
        inputDefuncion.setValue(convertToLocalDateViaInstant(artista.getFecha_de_defuncion()));


        if(gestor.listGeneros() == null || gestor.listGeneros().isEmpty()) {

        } else {
            for (Genero genero:
                    gestor.listGeneros()) {
                lista_generos.getItems().add(genero);
            }
            lista_generos.setValue(artista.getGenero());
            genero_input = artista.getGenero();
        }

        lista_generos.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> genero_input = newValue );

        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            lista_paises.getItems().add(obj.getDisplayCountry());
            lista_paises.setValue(artista.getPais_de_nacimiento());
            pais = artista.getPais_de_nacimiento();

        }

        lista_paises.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> pais = newValue );

    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        if(dateToConvert != null) {
            LocalDate date = Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            return date;
        }
        return null;
    }

    @FXML
    void registrar(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputApellido.getText() != null &&
                inputNombreArtistico.getText() != null &&
                inputNacimiento.getValue() != null &&
                genero_input != null &&
                pais != null) {

            String nombre = inputNombre.getText();
            String apellido = inputApellido.getText();
            String nombre_artistico = inputNombreArtistico.getText();
            String fecha_nacimiento = inputNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String fecha_defuncion = null;
            if(inputDefuncion.getValue() != null) {
                fecha_defuncion = inputDefuncion.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            LocalDate present = LocalDate.now();
            int edad = calcularEdad(inputNacimiento.getValue(), present);

            gestor.editarArtista(nombre, apellido, nombre_artistico, fecha_nacimiento, fecha_defuncion, pais, genero_input, edad, artista_cambiar);

            // get a handle to the stage
            Stage stage = (Stage) registrarBtn.getScene().getWindow();
            // do what you have to do
            stage.close();
        } else {
            // Espacios en blanco
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/AlertBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            AlertBox controller = fxmlLoader.getController();
            controller.initData("Espacios en Blanco");
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    private int calcularEdad(LocalDate nacimiento, LocalDate present) {
        return Period.between(nacimiento, present).getYears();
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
