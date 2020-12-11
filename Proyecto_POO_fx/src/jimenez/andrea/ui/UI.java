package jimenez.andrea.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class UI {

    private static PrintStream output = new PrintStream(System.out);
    private static Scanner input = new Scanner(System.in);

    public static void mostrarMenu () {
        output.println("*******  Escoja una opción  ******");

        output.println("1. Registrar Usuario");
        output.println("2. Iniciar Sesión");

        output.println("3. Registrar Artista");
        output.println("4. Registrar Compositor");

        output.println("5. Registrar Género");
        output.println("6. Registrar Álbum");
        output.println("7. Registrar Canción");
        output.println("8. Crear lista de reproducción");

        output.println("9. Salir");
    }

    public static void imprimir (String msj) {
        output.println(msj);
    }

    public static String leerTexto () {
        String texto = input.next();
        return texto;
    }

    public int leerOpcion() {
        int opcion = Integer.parseInt(input.next());
        return opcion;
    }
}
