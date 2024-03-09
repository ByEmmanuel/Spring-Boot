package com.beta.authenticationsystem.Models.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RegistroDatosPersonalesUsuario(

        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @NotNull
        @Valid
        String contraseña,
        @NotBlank
        String telefono,
        @NotNull
        /*
         *
         * Aqui se pondra por quien puede ser utilizado el sistema
         * */
        Especialidad especialidad
        ) {

}
