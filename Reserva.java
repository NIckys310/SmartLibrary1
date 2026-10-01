package smartlibrary.reserva;

import smartlibrary.catalogo.Libro;
import smartlibrary.usuarios.Usuario;

import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaReserva;
    private String estado; // "ACTIVA", "CANCELADA", "COMPLETADA"

    public Reserva(Usuario usuario, Libro libro, LocalDate fechaReserva) {
        if (usuario == null || libro == null) {
            throw new IllegalArgumentException("La reserva requiere un usuario y un libro válidos.");
        }
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = fechaReserva != null ? fechaReserva : LocalDate.now();
        this.estado = "ACTIVA";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}