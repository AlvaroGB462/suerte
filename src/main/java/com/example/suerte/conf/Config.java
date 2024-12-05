package com.example.suerte.conf;  // Especifica el paquete donde se encuentra esta clase. El paquete organiza el proyecto.

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;  
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter; 
import org.springframework.web.client.RestTemplate;

@Configuration  
public class Config {

    @Bean  // Indica que el método restTemplate es un método que creará un bean dentro del contexto de Spring.
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();  // Crea una instancia de RestTemplate. RestTemplate es una clase de Spring usada para interactuar con APIs REST.
        
        // Se añade un conversor de mensajes (message converter) que permite convertir los datos JSON a objetos Java utilizando la biblioteca Jackson.
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        // Retorna la instancia de RestTemplate configurada.
        return restTemplate;
    }
}
