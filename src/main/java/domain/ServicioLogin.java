package domain;

public interface ServicioLogin {
    void registar(String usuario, String clave);
    void consultarUsuario(String mail, String password);

}
