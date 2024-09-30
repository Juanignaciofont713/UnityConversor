package UnityConversor;

import java.util.HashMap;
import java.util.Map;

// Clase abstracta para las Unidades
abstract class Unidad {
    protected String nombre;

    public Unidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto para la conversión
    public abstract double convertir(double valor, Unidad otraUnidad) throws Exception;

    public abstract String[] obtenerUnidadesCompatibles();
}