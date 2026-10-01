package smartlibrary.prestamos;

import smartlibrary.catalogo.Ejemplar;
import smartlibrary.usuarios.Estudiante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El préstamo debe estar asociado a un estudiante.");
        }
        if (ejemplar == null) {
            throw new IllegalArgumentException("El préstamo debe estar asociado a un ejemplar.");
        }
        if (fechaPrevistaDevolucion == null || !fechaPrevistaDevolucion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha prevista de devolución debe ser posterior a la fecha actual.");
        }

        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
        
        // Sincronización automática del estado del ejemplar
        this.ejemplar.setEstado("PRESTADO");
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public List<Renovacion> getRenovaciones() {
        return renovaciones;
    }

    public void renovar(LocalDate nuevaFecha) {
        if (nuevaFecha == null || !nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                "La nueva fecha debe ser posterior a la fecha prevista actual."
            );
        }

        LocalDate fechaAnterior = fechaPrevistaDevolucion;

        Renovacion renovacion = new Renovacion(
            LocalDate.now(),
            fechaAnterior,
            nuevaFecha
        );

        renovaciones.add(renovacion);
        fechaPrevistaDevolucion = nuevaFecha;
    }
}