package com.beta.authenticationsystem.Models.RegistrosUsuarios.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroDatosDireccion(
        @NotBlank
        @NotNull
        String nombre_usuario,
        @NotBlank
        String calle,
        @NotBlank
        String numero,
        @NotBlank
        String colonia,
        @NotBlank
        String ciudad,
        @NotBlank
        String estado,
        @NotBlank
        String pais,

        String complemento) {
}

