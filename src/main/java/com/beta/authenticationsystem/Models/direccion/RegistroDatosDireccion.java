package com.beta.authenticationsystem.Models.direccion;

import jakarta.validation.constraints.NotBlank;

public record RegistroDatosDireccion(
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

        @NotBlank
        String complemento) {
}

