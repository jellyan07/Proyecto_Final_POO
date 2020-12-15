package sample.gestor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class Configuracion {
    private Properties props;
    private boolean cargadas = false;

    public Configuracion() {
        this.props = new Properties();
        try {
            this.props.load(new BufferedReader(new FileReader("app.properties")));
            cargadas = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Optional<String> getDriver() {
        if (cargadas) {
            return Optional.of((String) this.props.get("driver"));
        } else {
            return Optional.empty();
        }
    }

    public Optional<String> getUserName() {
        if (cargadas) {
            return Optional.of((String) this.props.get("usr"));
        } else {
            return Optional.empty();
        }
    }

    public Optional<String> getPassword() {
        if (cargadas) {
            return Optional.of((String) this.props.get("pwd"));
        } else {
            return Optional.empty();
        }
    }
    public Optional<String> getDBUrl() {
        if (cargadas) {
            return Optional.of((String) this.props.get("cnxStr"));
        } else {
            return Optional.empty();
        }
    }
}
