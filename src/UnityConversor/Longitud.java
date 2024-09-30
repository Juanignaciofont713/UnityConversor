package UnityConversor;

import java.util.HashMap;
import java.util.Map;

// Subclase para Longitud
class Longitud extends Unidad {
    private static Map<String, Double> conversiones = new HashMap<>();

    static {
        conversiones.put("metro", 1.0);
        conversiones.put("kilometro", 1000.0);
        conversiones.put("centimetro", 0.01);
    }

    public Longitud(String nombre) {
        super(nombre);
    }

    @Override
    public double convertir(double valor, Unidad otraUnidad) throws Exception {
        if (!(otraUnidad instanceof Longitud)) {
            throw new Exception("Error: Las unidades no son compatibles. Sugerencia: Solo puede convertir entre unidades de longitud.");
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