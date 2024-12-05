package com.example.suerte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.suerte.model.UserAddDTO;

@Service
public class UserAddService {

    private static final String API_URL = "http://localhost:8078/api/usuario";  // URL de la API para agregar el usuario

    @Autowired
    private RestTemplate restTemplate;

    public boolean addUser(UserAddDTO userAddDTO) {
        String url = API_URL;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserAddDTO> requestEntity = new HttpEntity<>(userAddDTO, headers);

        try {
            // Realiza la solicitud POST para agregar el usuario
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            // Verifica el estado de la respuesta
            if (response.getStatusCode().is2xxSuccessful()) {
                return true;  // Si la solicitud es exitosa, devuelve true
            } else {
                // Puedes agregar más lógica para manejar otros códigos de error
                System.err.println("Error al agregar el usuario: " + response.getStatusCode());
                return false;
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Manejo de errores específicos de HTTP
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            // Manejo de errores generales
            e.printStackTrace();
            return false;
        }
    }

}
