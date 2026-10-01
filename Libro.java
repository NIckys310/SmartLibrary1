package smartlibrary.catalogo;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private List<Ejemplar> ejemplares = new ArrayList<>();

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void agregarEjemplar(Ejemplar ejemplar) {
        if (ejemplar != null && !ejemplares.contains(ejemplar)) {
            ejemplares.add(ejemplar);
        }
    }
}