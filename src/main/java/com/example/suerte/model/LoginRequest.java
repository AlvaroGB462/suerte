package com.example.suerte.model; 

public class LoginRequest {  // Definición de la clase LoginRequest.

    // Campos privados que representan las credenciales del usuario.
    private String email;
    private String password;
    private String nickUser;

    // Constructor que inicializa los campos de la clase. 
    // Si el email o el nickname están vacíos o nulos, se les asigna null.
    public LoginRequest(String email, String password, String nickUser) {
        // Condición para verificar si el email no es nulo ni vacío, en caso contrario lo asigna como null
        this.email = email != null && !email.isEmpty() ? email : null;
        this.nickUser = nickUser != null && !nickUser.isEmpty() ? nickUser : null;
        this.password = password;  // Asigna la contraseña directamente (sin validaciones).
    }

    // Métodos getter y setter para acceder y modificar las propiedades de la clase.

    // Método getter para obtener el email
    public String getEmail() {
        return email;
    }

    // Método setter para asignar un valor al email
    public void setEmail(String email) {
        this.email = email;
    }

    // Método getter para obtener la contraseña
    public String getPassword() {
        return password;
    }

    // Método setter para asignar un valor a la contraseña
    public void setPassword(String password) {
        this.password = password;
    }

    // Método getter para obtener el nickname del usuario
    public String getNickUser() {
        return nickUser;
    }

    // Método setter para asignar un valor al nickname
    public void setNickUser(String nickUser) {
        this.nickUser = nickUser;
    }
}
