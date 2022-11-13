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

    @Test
    public void darErrorAlRegistrarmeSiLasClavesNoCoinciden(){

        String vista = cuandoRegistroElUsuario("carloncho@gmail.com", "1234", "1235");

        entoncesMeRedirigeAlIndex(vista, "index");
    }

    private void dadoQueExisteUsuario(String usuario) {
        doThrow(Exception.class).when(servicioLogin).registar(usuario, "");
    }

    private void entoncesMeRedirigeAlIndex(String vista, String vistaEsperada){
        assertThat(vista).isEqualTo(vistaEsperada);
    }

    private String cuandoRegistroElUsuario(String usuario) {
        ModelAndView mav = controladorUsuarios.registrarUsuario(conDatos(usuario, "",""));
        return mav.getViewName();

    }

    private String cuandoRegistroElUsuario(String usuario, String clave, String repiteClave) {
        ModelAndView mav = controladorUsuarios.registrarUsuario(conDatos(usuario, "",""));
        return mav.getViewName();
    }


    private DatosRegistro conDatos(String usuario, String clave, String repiteClave){
        return new DatosRegistro(usuario, clave, repiteClave);
    }
}
