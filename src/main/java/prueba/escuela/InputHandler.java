package prueba.escuela;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Se encarga de la entrada de datos por teclado.
 */
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metodo para pedir el vehiculo al usuario.
     *
     * @return int opcion
     */

    public Integer getTipoVehiculo() {
        List<String> options = Arrays.asList(
                "Coche",
                "Moto",
                "Barco",
                "Salir");
        return getUserInput("Por favor, seleccione una opción:", options);
    }

    /**
     * Si obtiene de la DB o crea uno nuevo
     * 
     * @return int
     */
    public Integer getDBorCreated() {
        List<String> options = Arrays.asList(
                "Obtener desde DB",
                "Crear desde 0",
                "Salir");
        return getUserInput("Por favor, seleccione una opción:", options);
    }
    
    /**
     * Obtiene matrícula indicada por el usuario
     * 
     * @return String matrícula
     */
    public String getFromMatricula() {
        return scanner.nextLine();
    }
    
    
    /**
     * Metodo para pedir la acción al usuario.
     *
     * @return int opcion
     */
    public Integer getAccion() {
        List<String> options = Arrays.asList(
                "Arrancar",
                "Parar",
                "Avanzar",
                "Retroceder",
                "Mostrar datos",
                "Salir");
        return getUserInput("Por favor, seleccione una acción:", options);
    }

    /**
     * Obtiene una elección correcta según el menu
     * 
     * @param message mensaje
     * @param options menu
     * @return int selección
     */
    private int getUserInput(String message, List<String> options) {

        System.out.println(message);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d : %s%n", i, options.get(i));
        }

        while (!scanner.hasNextInt()) {
            System.out.println("Eso no es una opción válida!");
            if (scanner.hasNextLine()) {
                scanner.next(); // importante!
            }
        }

        int respuesta = -1;
        do {
            System.out.println("Por favor elija una de las opciones propuestas.");
            respuesta = scanner.nextInt();
        } while (respuesta < 0 || respuesta >= options.size());

        System.out.printf("Has elegido la opción: %d - %s%n", respuesta, options.get(respuesta));
        return respuesta;
    }

    /**
     * Metodo para pedir los metros al usuario.
     *
     * @return Integer metros
     */
    public Integer getMetros() {

        System.out.println("Por favor introduzca los metros avanzados sin comas.");
        Integer respuesta; // incializamos con valor por defecto
        do {
            System.out.println("Por favor, introduzca un número positivo.");
            while (!scanner.hasNextInt()) {
                System.out.println("Eso no son metros válidos!");
                scanner.next(); // importante!
            }
            respuesta = scanner.nextInt();
        } while (respuesta < 0);
        System.out.println("Has introducido: " + respuesta + " metros.");

        return respuesta;

    }

    /**
     * Metodo para resetear el scanner.
     */
    public void reset() {
        this.scanner.reset();
        this.scanner.close();
        this.scanner = new Scanner(System.in);
    }
}