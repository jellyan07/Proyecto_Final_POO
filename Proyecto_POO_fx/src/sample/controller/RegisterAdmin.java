package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterAdmin {

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
    private TextField inputImg;

    @FXML
    private Button registrarBtn;

    @FXML
    void registrar(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputApellido1.getText() != null &&
                inputApellido2.getText() != null &&
                inputCorreo.getText() != null &&
                inputNombreUsuario.getText() != null &&
                inputPassword.getText() != null &&
                inputImg.getText() != null) {

            String nombre = inputNombre.getText();
            String apellido1 = inputApellido1.getText();
            String apellido2 = inputApellido2.getText();
            String correo = inputCorreo.getText();
            String nombre_usuario = inputNombreUsuario.getText();
            String password = inputPassword.getText();
            String img = inputImg.getText();

            gestor.crearAdmin(nombre, apellido1, apellido2, correo, password, nombre_usuario, img);


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
