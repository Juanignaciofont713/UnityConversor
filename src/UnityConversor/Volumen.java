package UnityConversor;

import java.util.HashMap;
import java.util.Map;

// Subclase para Volumen
class Volumen extends Unidad {
    private static Map<String, Double> conversiones = new HashMap<>();

    static {
        conversiones.put("litro", 1.0);
        conversiones.put("mililitro", 0.001);
        conversiones.put("metro cubico", 1000.0);
    }

    public Volumen(String nombre) {
        super(nombre);
    }

    @Override
    public double convertir(double valor, Unidad otraUnidad) throws Exception {
        if (!(otraUnidad instanceof Volumen)) {
            throw new Exception("Error: Las unidades no son compatibles. Sugerencia: Solo puede convertir entre unidades de volumen.");
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