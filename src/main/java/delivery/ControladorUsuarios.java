package delivery;

import domain.ServicioLogin;
import org.springframework.web.servlet.ModelAndView;

public class ControladorUsuarios {

    private final ServicioLogin servicioLogin;

    public ControladorUsuarios(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }

    public ModelAndView registrarUsuario(String usuario) {
        try{
            servicioLogin.registar(usuario);
        }catch (Exception e){
            return new ModelAndView("registrarme");
        }

        return new ModelAndView("index");
    }
}
