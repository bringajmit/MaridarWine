package domain;

public class Usuario {

    private String usuario;
    private String clave;

    public Usuario() {

    }

    public Usuario(String usuario) {
        this.usuario=usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setMail(String usuario) {
        this.usuario=usuario;
    }

    public void setPassword(String clave) {
        this.clave=clave;
    }
}
