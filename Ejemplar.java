package smartlibrary.catalogo;

public class Ejemplar {
    private String codigo;
    private String estado; // Ej: "DISPONIBLE", "PRESTADO"

    public Ejemplar(String codigo, String estado) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del ejemplar no puede estar vacío.");
        }
        this.codigo = codigo;
        this.estado = (estado == null || estado.trim().isEmpty()) ? "DISPONIBLE" : estado.trim().toUpperCase();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del ejemplar no puede estar vacío.");
        }
        this.estado = estado.trim().toUpperCase();
    }
}