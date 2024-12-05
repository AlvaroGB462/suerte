package com.example.suerte.model; 

public class UserLoginDTO {  // Definición de la clase User.

    // Atributos privados de la clase User.
    String email;  // Almacena el correo electrónico del usuario.
    String passwordHash;  // Almacena el hash de la contraseña del usuario (no la contraseña en texto claro).
    boolean admin;  // Indica si el usuario tiene privilegios de administrador.
    String nick;  // Almacena el nombre o apodo (nickname) del usuario.

    // Constructor con parámetros para inicializar los atributos de la clase.
    public UserLoginDTO(String email, String passwordHash, boolean admin, String nick) {
        this.email = email;  // Asigna el correo electrónico al atributo email.
        this.passwordHash = passwordHash;  // Asigna el hash de la contraseña al atributo passwordHash.
        this.admin = admin;  // Asigna el valor del atributo admin, indicando si el usuario es administrador.
        this.nick = nick;  // Asigna el nombre de usuario o apodo al atributo nick.
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase.

    // Getter para obtener el correo electrónico del usuario.
    public String getEmail() {
        return email;
    }

    // Getter para obtener el hash de la contraseña del usuario.
    public String getPasswordHash() {
        return passwordHash;
    }

    // Getter para verificar si el usuario es administrador.
    public boolean isAdmin() {
        return admin;
    }

    // Getter para obtener el nombre (o nickname) del usuario.
    public String getNombre() {
        return nick;
    }

    // Setter para asignar un correo electrónico al usuario.
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter para asignar el hash de la contraseña al usuario.
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Setter para asignar si el usuario es administrador o no.
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    // Setter para asignar el nombre o nickname del usuario.
    public void setNombre(String nick) {
        this.nick = nick;
    }
}
