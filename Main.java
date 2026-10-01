package smartlibrary;

import smartlibrary.catalogo.Ejemplar;
import smartlibrary.catalogo.Libro;
import smartlibrary.prestamos.Prestamo;
import smartlibrary.usuarios.Estudiante;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        Estudiante estudiante = new Estudiante(
            "123456",
            "Nicoll",
            "nicoll@email.com",
            "EST001",
            "Ingeniería de Software"
        );

        Libro libro = new Libro("978-3-16-148410-0", "Diseño de Software", "Autor Genérico");
        Ejemplar ejemplar = new Ejemplar("EJ001", "DISPONIBLE");
        libro.agregarEjemplar(ejemplar);

        // Creamos el préstamo con una fecha válida (7 días a partir de hoy)
        Prestamo prestamo = new Prestamo(
            estudiante,
            ejemplar,
            LocalDate.now().plusDays(7)
        );

        System.out.println("=== PRUEBA DE RENOVACIÓN VÁLIDA ===");
        try {
            LocalDate nuevaFechaValida = prestamo.getFechaPrevistaDevolucion().plusDays(5);
            prestamo.renovar(nuevaFechaValida);

            estudiante.notificar("Su préstamo ha sido renovado exitosamente.");

            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Nueva fecha de devolución: " + prestamo.getFechaPrevistaDevolucion());
            System.out.println("Cantidad de renovaciones: " + prestamo.getRenovaciones().size());
            System.out.println("Estado actual del ejemplar: " + ejemplar.getEstado());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== PRUEBA DE RENOVACIÓN INVÁLIDA ===");

        try {
            // Intentamos renovar con una fecha inválida (hoy mismo)
            prestamo.renovar(LocalDate.now());
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado exitosamente: " + e.getMessage());
        }
    }
}