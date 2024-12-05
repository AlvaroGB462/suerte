package com.example.suerte.model; 

public class LoginResponse {  // Definición de la clase LoginResponse.

    // Atributos privados de la clase LoginResponse.
    private String email;  // Almacena el correo electrónico del usuario.
    private String passwordUser;  // Almacena la contraseña del usuario.
    private String nickUser;  // Almacena el nombre de usuario (nickname).
    private Boolean admin;  // Un campo booleano que indica si el usuario es administrador.

    // Constructor sin parámetros (necesario para el mapeo automático, por ejemplo, con Jackson en una API REST).
    public LoginResponse() {
    }

    // Constructor con parámetros para inicializar los atributos de la clase.
    public LoginResponse(String email, String passwordUser, String nickUser, Boolean admin) {
        this.email = email;  // Asigna el correo electrónico proporcionado al atributo email.
        this.passwordUser = passwordUser;  // Asigna la contraseña proporcionada al atributo passwordUser.
        this.nickUser = nickUser;  // Asigna el nombre de usuario proporcionado al atributo nickUser.
        this.admin = admin;  // Asigna el valor del campo admin, que indica si el usuario es administrador.
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase.

    // Getter para el correo electrónico del usuario.
    public String getEmail() {
        return email;
    }

    // Setter para asignar el correo electrónico al atributo email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter para obtener la contraseña del usuario.
    public String getPasswordUser() {
        return passwordUser;
    }

    // Setter para asignar la contraseña del usuario al atributo passwordUser.
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    // Getter para obtener el nombre de usuario (nickname).
    public String getNickUser() {
        return nickUser;
    }

    // Setter para asignar el nombre de usuario al atributo nickUser.
    public void setNickUser(String nickUser) {
        this.nickUser = nickUser;
    }

    // Getter para obtener el valor del campo admin (si el usuario es administrador).
    public Boolean getAdmin() {
        return admin;
    }

    // Setter para asignar el valor del campo admin.
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    // Método toString para representar el objeto como una cadena de texto.
    @Override
    public String toString() {
        return "LoginResponse{" +
                "email='" + email + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", nickUser='" + nickUser + '\'' +
                ", admin=" + admin +  // El campo admin se incluye en la representación.
                '}';
    }
}
