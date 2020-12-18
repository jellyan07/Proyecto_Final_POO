package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.gestor.Gestor;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

public class RegisterUsuario {

    private Gestor gestor = new Gestor();

    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputApellido1;

    @FXML
    private TextField inputApellido2;

    @FXML
    private TextField inputCorreo;

    @FXML
    private TextField inputNombreUsuario;

    @FXML
    private TextField inputPassword;

    @FXML
    private Button fileBtn;

    @FXML
    private Button registrarBtn;
    String inputImg = null;

    @FXML
    private Spinner<Integer> edadSpinner;

    @FXML
    private ChoiceBox<String> lista_paises;
    private String pais = null;

    public void initialize () throws SQLException {
        edadSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 100, 18,1));
        edadSpinner.setEditable(true);

        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            lista_paises.getItems().add(obj.getDisplayCountry());

        }

        lista_paises.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> pais = newValue );
    }

    @FXML
    void registrar(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputApellido1.getText() != null &&
                inputApellido2.getText() != null &&
                inputCorreo.getText() != null &&
                inputNombreUsuario.getText() != null &&
                inputPassword.getText() != null &&
                inputImg != null) {

            String nombre = inputNombre.getText();
            String apellido1 = inputApellido1.getText();
            String apellido2 = inputApellido2.getText();
            String correo = inputCorreo.getText();
            String nombre_usuario = inputNombreUsuario.getText();
            String password = inputPassword.getText();
            String img = inputImg;
            int edad = edadSpinner.getValue();

            gestor.crearUsuario(nombre, apellido1, apellido2, correo, password, nombre_usuario, edad, pais, img);


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

    @FXML
    void singleFileChooser(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File f = fc.showOpenDialog(null);
        if(f != null) {
            inputImg = f.getAbsolutePath();
        }
    }
}
