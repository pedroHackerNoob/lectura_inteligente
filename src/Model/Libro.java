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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return
                "titulo: " + titulo+
                " autor: " + autor +
                " estado: " + estado +
                " codigo: " + codigo +
                '}';
    }
}
