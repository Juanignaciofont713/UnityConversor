package UnityConversor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Clase principal para el Conversor
public class ConversorDeUnidades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingreso del valor
        System.out.print("Ingrese el valor a convertir: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        // Ingreso de la unidad de origen
        System.out.print("Ingrese la unidad de origen (metro, kilometro, centimetro, gramo, kilogramo, tonelada, litro, mililitro, metro cubico): ");
        String unidadOrigen = scanner.nextLine().toLowerCase();

        // Ingreso de la unidad de destino
        System.out.print("Ingrese la unidad de destino: ");
        String unidadDestino = scanner.nextLine().toLowerCase();

        Unidad unidadOrigenObj = crearUnidad(unidadOrigen);
        Unidad unidadDestinoObj = crearUnidad(unidadDestino);

        if (unidadOrigenObj == null || unidadDestinoObj == null) {
            System.out.println("Una o ambas unidades ingresadas no son válidas.");
        } else {
            try {
                double resultado = unidadOrigenObj.convertir(valor, unidadDestinoObj);
                System.out.println(valor + " " + unidadOrigen + " es igual a " + resultado + " " + unidadDestino);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    // Método para crear objetos de unidad según el tipo de medida
    public static Unidad crearUnidad(String nombre) {
        if (nombre.equals("metro") || nombre.equals("kilometro") || nombre.equals("centimetro")) {
            return new Longitud(nombre);
        } else if (nombre.equals("gramo") || nombre.equals("kilogramo") || nombre.equals("tonelada")) {
            return new Peso(nombre);
        } else if (nombre.equals("litro") || nombre.equals("mililitro") || nombre.equals("metro cubico")) {
            return new Volumen(nombre);
        } else {
            return null; // Unidad no válida
        }
    }
}