package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AlertBox {

    @FXML
    private Button okBtn;

    @FXML
    private Text warning_text;

    @FXML
    void closeWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) okBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void initData (String msj) throws SQLException {
        warning_text.setText(msj);
    }

}
