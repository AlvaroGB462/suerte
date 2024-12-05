package com.example.suerte.model;

public class UserAddDTO {

    private String email;  // Correo electrónico del usuario
    private String passwordUser;  // Contraseña en hash
    private boolean admin;  // Indica si el usuario es administrador
    private String nick;  // Nickname del usuario

    private String dni;  // DNI del usuario
    private String address;  // Dirección del usuario
    private String imgUser;  // Imagen del usuario (URL)
    private Long idClub;  // ID del club al que pertenece el usuario

    // Constructor
    public UserAddDTO(String email, String passwordUser, boolean admin, String nick, String dni, String address, String imgUser, Long idClub) {
        this.email = email;
        this.passwordUser = passwordUser;
        this.admin = admin;
        this.nick = nick;
        this.dni = dni;
        this.address = address;
        this.imgUser = imgUser;
        this.idClub = idClub;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public Long getIdClub() {
        return idClub;
    }

    public void setIdClub(Long idClub) {
        this.idClub = idClub;
    }
}
