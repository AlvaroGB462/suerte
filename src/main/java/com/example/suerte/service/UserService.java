package com.example.suerte.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.suerte.model.LoginResponse;
import com.example.suerte.model.UserLoginDTO;

@Service
public class UserService {

    private static final String API_URL = "http://localhost:8078/api/usuario/login";  // URL de la API que realiza la autenticación

    @Autowired
    private RestTemplate restTemplate;  // Inyección de la dependencia RestTemplate para hacer solicitudes HTTP

    // Método que se encarga de autenticar al usuario.
    public UserLoginDTO authenticateUser(String emailOrNick, String password) {
        String url = API_URL;  // La URL de la API a la que se hará la solicitud

        HttpHeaders headers = new HttpHeaders();  // Se crean los encabezados HTTP para la solicitud
        headers.setContentType(MediaType.APPLICATION_JSON);  // Se establece el tipo de contenido como JSON

        // Creación del mapa de parámetros para la solicitud
        Map<String, String> loginRequest = new HashMap<>();
        loginRequest.put("email", emailOrNick.contains("@") ? emailOrNick : null);  // Si el emailOrNick contiene '@', se asume que es un correo
        loginRequest.put("nickUser", emailOrNick.contains("@") ? null : emailOrNick);  // Si no contiene '@', se asume que es un nickname
        loginRequest.put("passwordUser", password);  // Se agrega la contraseña al cuerpo de la solicitud

        // Se crea la entidad HTTP con los parámetros y los encabezados.
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(loginRequest, headers);

        try {
            // Realiza la solicitud HTTP POST a la API de autenticación
            ResponseEntity<LoginResponse> responseEntity = restTemplate.exchange(
                url,  // URL de la API
                HttpMethod.POST,  // Método HTTP POST
                requestEntity,  // El cuerpo de la solicitud con los datos del usuario
                LoginResponse.class  // Tipo de respuesta esperado
            );

            // Verifica si el estado de la respuesta es 200 OK
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                LoginResponse loginResponse = responseEntity.getBody();  // Extrae el cuerpo de la respuesta

                // Extrae el valor de 'admin' de la respuesta
                boolean isAdmin = loginResponse.getAdmin() != null && loginResponse.getAdmin();  // Si el valor de 'admin' es true

                // Crea un objeto User con los datos obtenidos de la respuesta y el campo 'admin'
                return new UserLoginDTO(
                    loginResponse.getEmail(),
                    loginResponse.getPasswordUser(),
                    isAdmin,  // Establece si el usuario es administrador o no
                    loginResponse.getNickUser()
                );
            } else {
                return null;  // Si la respuesta no es OK (200), devuelve null
            }
        } catch (HttpClientErrorException e) {
            // Si hay un error relacionado con el cliente (p. ej., credenciales incorrectas)
            System.err.println("Error de cliente: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return null;  // Devuelve null en caso de error
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el stack trace en caso de cualquier otra excepción
            return null;  // Devuelve null si ocurre un error general
        }
    }
}
