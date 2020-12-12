package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.entidades.*;
import sample.gestor.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EditCancion {

    Gestor gestor = new Gestor();

    @FXML
    private TextField inputNombre;

    @FXML
    private Button registrarBtn;

    @FXML
    private ChoiceBox<Genero> lista_generos;

    @FXML
    private ChoiceBox<Album> lista_albumes;

    @FXML
    private DatePicker inputLanzamiento;

    @FXML
    private ChoiceBox<Artista> lista_artistas;

    @FXML
    private ChoiceBox<Compositor> lista_compositores;

    @FXML
    private TextField inputPrecio;

    @FXML
    private Spinner<Integer> inputCalificacion;

    @FXML
    private CheckBox checkBox;

    Genero genero_input = null;
    Album album_input = null;
    Artista artista_input = null;
    Compositor compositor_input = null;

    public void initialize (Cancion cancion) throws SQLException {

        inputPrecio.disableProperty().bind(checkBox.selectedProperty().not());
        inputCalificacion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1,1));
        inputCalificacion.setEditable(true);
        inputCalificacion.getValueFactory().setValue(cancion.getCalificacion());

        // Generos

        if(gestor.listGeneros() == null || gestor.listGeneros().isEmpty()) {

        } else {
            for (Genero genero:
                    gestor.listGeneros()) {
                lista_generos.getItems().add(genero);
                lista_generos.setValue(cancion.getGenero());
                genero_input = cancion.getGenero();
            }
        }

        lista_generos.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> genero_input = newValue );

        //Albumes

        if(gestor.listAlbumes() == null || gestor.listAlbumes().isEmpty()) {

        } else {
            for (Album album:
                    gestor.listAlbumes()) {
                lista_albumes.getItems().add(album);
                lista_albumes.setValue(cancion.getAlbum());
                album_input = cancion.getAlbum();
            }
        }

        lista_albumes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> album_input = newValue );

        //Artistas

        if(gestor.listArtistas() == null || gestor.listArtistas().isEmpty()) {

        } else {
            for (Artista artista:
                    gestor.listArtistas()) {
                lista_artistas.getItems().add(artista);
                lista_artistas.setValue(cancion.getArtista());
                album_input = cancion.getAlbum();
            }
        }

        lista_artistas.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> artista_input = newValue );

        // Compositores

        if(gestor.listCompositores() == null || gestor.listCompositores().isEmpty()) {

        } else {
            for (Compositor compositor:
                    gestor.listCompositores()) {
                lista_compositores.getItems().add(compositor);
                lista_compositores.setValue(cancion.getCompositor());
                compositor_input = cancion.getCompositor();
            }
        }

        lista_compositores.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> compositor_input = newValue );

        checkBox.setSelected(cancion.isTienda());
        inputPrecio.setText(String.valueOf(cancion.getPrecio()));
    }

    @FXML
    void registrar(ActionEvent event) throws SQLException, IOException {

        if(inputNombre.getText() != null &&
                inputLanzamiento.getValue() != null &&
                album_input != null &&
                artista_input != null &&
                genero_input != null &&
                compositor_input != null) {

            String nombre = inputNombre.getText();
            String lanzamiento = inputLanzamiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            double precio = 0;
            if(checkBox.isSelected() && inputPrecio.getText() != null) {
                precio = Double.parseDouble(inputPrecio.getText());
            }
            int creador = gestor.getUsuario().getId();
            int calificacion = inputCalificacion.getValue();

            gestor.crearCancion(nombre, artista_input, genero_input, compositor_input, lanzamiento, album_input, precio, creador, checkBox.isSelected(), calificacion);

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
