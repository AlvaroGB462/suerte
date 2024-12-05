package com.example.suerte.controller; 

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.servlet.ModelAndView; 

import com.example.suerte.model.UserLoginDTO;  // Importa la clase User que representa los usuarios en la aplicación.
import com.example.suerte.service.UserService;  // Importa la clase UserService que maneja la lógica de autenticación.

import jakarta.servlet.http.HttpSession;  // Importa la clase HttpSession para trabajar con la sesión del usuario.

@Controller  
public class LoginController {

    @Autowired  // Inyecta automáticamente una instancia del servicio UserService para manejar la lógica de usuario.
    private UserService usuarioService;

    // Redirige a la página de bienvenida al acceder a la raíz "/"
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showMainPage() {
        // Redirige al usuario a la página de bienvenida "/welcome".
        return new ModelAndView("redirect:/welcome");
    }

    // Muestra la página de login cuando el usuario accede a "/login" mediante GET
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        // Retorna la vista "login", donde el usuario puede ingresar sus credenciales.
        return new ModelAndView("login");
    }

    // Muestra la página de bienvenida si el usuario está logueado
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showWelcomePage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        
        // Obtiene el objeto "usuario" de la sesión actual
        UserLoginDTO usuario = (UserLoginDTO) session.getAttribute("usuario");

        // Verifica si el usuario está en sesión y agrega los datos a la vista
        if (usuario != null) {
            modelAndView.addObject("usuario", usuario);  // Agrega el usuario a la vista para mostrarlo en la página.
        } else {
            modelAndView.addObject("error", "Debe iniciar sesión.");  // Si no está logueado, muestra un mensaje de error.
        }

        return modelAndView;
    }

    // Maneja el login cuando el usuario envía el formulario con sus credenciales
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam("emailOrNick") String emailOrNick,  // Recibe el email o el nickname del usuario.
            @RequestParam("password") String password,  // Recibe la contraseña del usuario.
            HttpSession session) {  // Utiliza HttpSession para mantener la sesión del usuario.

        System.out.println("Datos recibidos: emailOrNick=" + emailOrNick + ", password=" + password);

        // Verifica que el email o nickname no esté vacío
        if (emailOrNick == null || emailOrNick.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Debe ingresar un email o un nick.");  // Si está vacío, muestra un mensaje de error.
            return modelAndView;
        }

        // Llama al servicio de usuario para autenticar al usuario con las credenciales proporcionadas
        UserLoginDTO usuario = usuarioService.authenticateUser(emailOrNick, password);

        ModelAndView modelAndView = new ModelAndView();
        if (usuario != null) {
            // Si la autenticación es exitosa, guarda al usuario en la sesión
            session.setAttribute("usuario", usuario);
            modelAndView.setViewName("redirect:/welcome");  // Redirige a la página de bienvenida
            modelAndView.addObject("usuario", usuario);  // Agrega el usuario a la vista
            modelAndView.addObject("admin", usuario.isAdmin());  // Agrega el estado de admin a la vista
        } else {
            // Si las credenciales son incorrectas, vuelve a mostrar la página de login con un mensaje de error
            modelAndView.setViewName("login");
            modelAndView.addObject("error", "Credenciales incorrectas.");
        }

        return modelAndView;
    }

    // Maneja el logout del usuario
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        // Invalida la sesión actual del usuario
        session.invalidate();
        // Redirige al usuario a la raíz "/"
        return new ModelAndView("redirect:/");
    }
}
