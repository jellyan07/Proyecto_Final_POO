package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Tienda {

    @FXML
    private TableView<?> cancionesTable;

    @FXML
    private TableColumn<?, ?> cn_nombre;

    @FXML
    private TableColumn<?, ?> cn_artista;

    @FXML
    private TableColumn<?, ?> cn_album;

    @FXML
    private TableColumn<?, ?> cn_compositor;

    @FXML
    private TableColumn<?, ?> cn_genero;

    @FXML
    private TableColumn<?, ?> cn_lanzamiento;

    @FXML
    private TableColumn<?, ?> cn_precio;

    @FXML
    private TableColumn<?, ?> cn_id;

    @FXML
    private TableColumn<?, ?> cn_creador;

    @FXML
    private Button comprarBtn;

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void comprar(ActionEvent event) {

    }

}