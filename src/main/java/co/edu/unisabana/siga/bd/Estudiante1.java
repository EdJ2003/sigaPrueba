package co.edu.unisabana.siga.bd;

public class Estudiante1 {

    int codigo;
    String nombre;
    int edad;
    boolean vivo;

    public Estudiante1(int codigo, String nombre, int edad, boolean vivo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.vivo = vivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
