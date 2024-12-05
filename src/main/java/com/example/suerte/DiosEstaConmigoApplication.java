package com.example.suerte;  // Especifica el paquete en el que se encuentra esta clase. El paquete puede ser utilizado para organizar las clases dentro del proyecto.

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication  // Esta es la anotación principal que marca la clase como la aplicación Spring Boot. 
// Es equivalente a usar las siguientes tres anotaciones juntas:
// @Configuration: Define la configuración de Spring.
// @EnableAutoConfiguration: Habilita la configuración automática de Spring Boot.
// @ComponentScan: Permite que Spring Busque otros componentes, configuraciones y servicios en el paquete actual.
public class DiosEstaConmigoApplication {

    public static void main(String[] args) {
        // Llama a la clase SpringApplication para iniciar la aplicación Spring Boot.
        SpringApplication.run(DiosEstaConmigoApplication.class, args);
    }

}
