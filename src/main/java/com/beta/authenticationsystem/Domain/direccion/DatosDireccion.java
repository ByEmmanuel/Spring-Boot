package com.beta.authenticationsystem.Domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
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

