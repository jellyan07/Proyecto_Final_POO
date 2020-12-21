package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

public class EditUsuario {

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

        inputNombre.setText(gestor.getUsuario().getNombre());
        inputApellido1.setText(gestor.getUsuario().getApellido1());
        inputApellido2.setText(gestor.getUsuario().getApellido2());
        inputCorreo.setText(gestor.getUsuario().getCorreo());
        inputNombreUsuario.setText(gestor.getUsuario().getNombre_usuario());
        inputImg = gestor.getUsuario().getImg();

        edadSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 100, gestor.getUsuario().getEdad(),1));
        edadSpinner.setEditable(true);

        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            lista_paises.getItems().add(obj.getDisplayCountry());

        }
        lista_paises.setValue(gestor.getUsuario().getPais());
        lista_paises.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> pais = newValue );
    }

    @FXML
    void registrar(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputApellido1.getText() != null &&
                inputApellido2.getText() != null &&
                inputCorreo.getText() != null &&
                inputNombreUsuario.getText() != null &&
                inputImg != null) {

            String nombre = inputNombre.getText();
            String apellido1 = inputApellido1.getText();
            String apellido2 = inputApellido2.getText();
            String correo = inputCorreo.getText();
            String nombre_usuario = inputNombreUsuario.getText();
            String img = inputImg;
            int edad = edadSpinner.getValue();

            gestor.editarUsuario(nombre, apellido1, apellido2, correo, nombre_usuario, edad, pais, img);


            Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

            Parent ruta = FXMLLoader.load(getClass().getResource("../ui/sampleUsuario.fxml"));

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

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/sampleUsuario.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    void singleFileChooser(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File f = fc.showOpenDialog(null);
        if(f != null) {
            inputImg = f.toURI().toString();
        }
    }
}
