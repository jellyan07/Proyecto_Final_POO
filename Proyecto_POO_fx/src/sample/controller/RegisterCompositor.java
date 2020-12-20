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

public class RegisterCompositor {

    private Gestor gestor = new Gestor();

    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputApellido;

    @FXML
    private TextField inputEdad;

    @FXML
    private Button registrarBtn;

    @FXML
    private ChoiceBox<Genero> lista_generos;
    private Genero genero_input = null;

    @FXML
    private ChoiceBox<String> lista_paises;
    private String pais = null;

    public void initialize () throws SQLException {
        if(gestor.listGeneros() == null || gestor.listGeneros().isEmpty()) {
           // lista_generos.getItems().add("No hay generos registrados");
           // lista_generos.setValue("No hay generos registrados");
        } else {
            for (Genero genero:
                    gestor.listGeneros()) {
                lista_generos.getItems().add(genero);
            }
        }

        lista_generos.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> genero_input = newValue );

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
                inputApellido.getText() != null &&
                inputEdad.getText() != null &&
                genero_input != null &&
                pais != null) {

            String nombre = inputNombre.getText();
            String apellido = inputApellido.getText();
            int edad = 0;
            try {
                edad = Integer.parseInt(inputEdad.getText());
            } catch (Exception e){
                // Edad no numérica
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/AlertBox.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("Edad no numérica");
                stage.setScene(new Scene(root1));
                stage.show();
                e.printStackTrace();
            }

            gestor.crearCompositor(nombre, apellido, pais, genero_input, edad);

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

    private int calcularEdad(LocalDate nacimiento, LocalDate present) {
        return Period.between(nacimiento, present).getYears();
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
        escenaPrincipal.show();;
    }

}
