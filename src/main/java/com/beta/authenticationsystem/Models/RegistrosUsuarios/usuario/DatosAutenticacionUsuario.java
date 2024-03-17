package com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario;

public record DatosAutenticacionUsuario(String Email, String Contraseña) {
    public DatosAutenticacionUsuario {
        if (Email == null || Email.isBlank()) {
            throw new IllegalArgumentException("El login no puede ser nulo o vacío");
        }
        if (Contraseña == null || Contraseña.isBlank()) {
            throw new IllegalArgumentException("La clave no puede ser nula o vacía");
        }
    }
}
