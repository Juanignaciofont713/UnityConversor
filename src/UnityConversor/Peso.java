package UnityConversor;

import java.util.HashMap;
import java.util.Map;

// Subclase para Peso
class Peso extends Unidad {
    private static Map<String, Double> conversiones = new HashMap<>();

    static {
        conversiones.put("gramo", 1.0);
        conversiones.put("kilogramo", 1000.0);
        conversiones.put("tonelada", 1000000.0);
    }

    public Peso(String nombre) {
        super(nombre);
    }

    @Override
    public double convertir(double valor, Unidad otraUnidad) throws Exception {
        if (!(otraUnidad instanceof Peso)) {
            throw new Exception("Error: Las unidades no son compatibles. Sugerencia: Solo puede convertir entre unidades de peso.");
        }
        double factorActual = conversiones.get(this.nombre);
        double factorDestino = conversiones.get(otraUnidad.getNombre());
        return valor * (factorActual / factorDestino);
    }

    @Override
    public String[] obtenerUnidadesCompatibles() {
        return conversiones.keySet().toArray(new String[0]);
    }
}