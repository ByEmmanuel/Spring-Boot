package com.beta.authenticationsystem.Models.DatosBancarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroDatosBancarios(

        @NotBlank
        @NotNull
        String nombre,
        @NotBlank
        @NotNull
        String banco,
        @NotBlank
        @NotNull
        String tipoDeCuenta,
        @NotBlank
        @NotNull
        String numeroDeTarjeta,
        @NotBlank
        @NotNull
        String fechaDeExpiracion,
        @NotBlank
        @NotNull
        String cvv) {

}
