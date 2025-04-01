package Model;

public class Libro {
    private String titulo, autor, estado;
    private int codigo;

    public Libro(String titulo, String autor, String estado, int codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", estado='" + estado + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
