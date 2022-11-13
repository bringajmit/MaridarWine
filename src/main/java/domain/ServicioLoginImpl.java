package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioLoginImpl(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }



    @Override
    public void consultarUsuario(String mail, String password){
        repositorioUsuario.buscarUsuario(mail, password);
    }


    @Override
    public void registar(String usuario, String clave) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setMail(usuario);
        nuevoUsuario.setPassword(clave);
        repositorioUsuario.guardar(nuevoUsuario);
    }

}
