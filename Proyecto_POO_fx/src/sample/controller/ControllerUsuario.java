package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.entidades.Admin;
import sample.entidades.Usuario;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerUsuario {

    private Gestor gestor = new Gestor();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField userInput;

    @FXML
    private TextField passInput;

    @FXML
    private Label userLabel;

    @FXML
    private Label labelPass;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    void login(ActionEvent event) throws IOException, SQLException {

        if(!userInput.getText().isEmpty() && !passInput.getText().isEmpty() && userInput != null && passInput != null) {
            try{
                String userNum = userInput.getText();
                List<Usuario> usuarios = gestor.listUsuarios();
                boolean encontrado = false;
                for (Usuario usuario:usuarios) {
                    if(usuario.getNombre_usuario().equals(userInput.getText())) {
                        encontrado = true;
                        if (usuario.getPassword().equals(passInput.getText())) {
                            //Ir al menú principal
                            System.out.println("Usuario Correcto");
                            // Usuario no existe
                            gestor.setUsuario(usuario);
                            System.out.println(gestor.getUsuario());
                            openUsuarioMenuWindow(event);
                        } else {
                            //Contraseña incorrecta
                            System.out.println("Contraseña incorrecta");
                        }
                    }
                }
                if(!encontrado) {
                    // Espacios en blanco
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/AlertBox.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setTitle("Usuario o contraseña incorrecta");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }

            } catch(NumberFormatException num) {
                num.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Espacios en Blanco
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

    @FXML
    void openRegisterWindow(ActionEvent event) throws IOException {
        try {
            Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

            Parent ruta = FXMLLoader.load(getClass().getResource("../ui/RegisterUsuario.fxml"));

            Scene nueva_escena = new Scene(ruta);
            escenaPrincipal.hide();

            escenaPrincipal.setScene(nueva_escena);
            escenaPrincipal.show();
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    void openUsuarioMenuWindow(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();

        Parent ruta = FXMLLoader.load(getClass().getResource("../ui/UsuarioMenu.fxml"));

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.hide();

        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) backBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
