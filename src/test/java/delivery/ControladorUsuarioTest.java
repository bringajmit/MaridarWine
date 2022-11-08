package delivery;

import delivery.ControladorUsuarios;
import domain.ServicioLogin;
import domain.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorUsuarioTest {

    private ControladorUsuarios controladorUsuarios;
    private ServicioLogin servicioLogin;


    @Before
    public void init(){
        servicioLogin = mock(ServicioLogin.class);
        controladorUsuarios = new ControladorUsuarios(servicioLogin);
    }

    @Test
    public void redirigirmeAlIndexSiElRegistroEsExitoso(){

        String vista = cuandoRegistroElUsuario("juan@gmail.com");

        entoncesMeRedirigeAlIndex(vista, "index");

    }

    @Test
    public void queNoSePuedaLoguearUnUsuarioExistenteYDarError(){
        
        dadoQueExisteUsuario("mariel@gmail.com");

        String vista = cuandoRegistroElUsuario("mariel@gmail.com");

        entoncesMeRedirigeAlIndex(vista, "registrarme");
    }

    private void dadoQueExisteUsuario(String usuario) {
      //  when(servicioLogin.registar(usuario)).thenThrow(Exception.class);
        doThrow(Exception.class).when(servicioLogin).registar(usuario);
    }

    private void entoncesMeRedirigeAlIndex(String vista, String vistaEsperada){
        assertThat(vista).isEqualTo(vistaEsperada);
    }

    private String cuandoRegistroElUsuario(String usuario) {
        ModelAndView mav = controladorUsuarios.registrarUsuario(usuario);
        return mav.getViewName();

    }


}
