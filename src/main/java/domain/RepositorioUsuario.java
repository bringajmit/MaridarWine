package domain;

public interface RepositorioUsuario {
    void guardar(Usuario usuario);

    Usuario buscarUsuario(String mail, String password);


    Usuario buscarUsuario(String mail);

    void modificar(Usuario usuario);
}
