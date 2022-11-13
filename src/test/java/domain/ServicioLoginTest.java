package domain;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServicioLoginTest {

    private ServicioLogin servicioLogin;
    private RepositorioUsuario repositorioUsuario;

    @Before
    public void init(){
        repositorioUsuario = mock(RepositorioUsuario.class);
        servicioLogin = new ServicioLoginImpl(repositorioUsuario);
    }

    @Test
    public void guardarElNuevoUsuarioSiElRegistroEsExitoso(){

        cuandoRegistroElUsuario("juan@juan.com", "1234");

        entoncesSeGuardaElUsuario("juan@juan.com", "1234");

    }

    private void entoncesSeGuardaElUsuario(String usuario, String clave) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setMail(usuario);
        nuevoUsuario.setPassword(clave);
       // verify(repositorioUsuario).guardar(nuevoUsuario);
        // argumentMatchers
        verify(repositorioUsuario).guardar(any(Usuario.class));

    }

    private void cuandoRegistroElUsuario(String usuario, String clave) {
        servicioLogin.registar(usuario, "");
    }
}
