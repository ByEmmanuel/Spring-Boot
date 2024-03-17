package com.beta.authenticationsystem.Models.RegistrosUsuarios.DatosBancarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroDatosBancarios(

        @NotBlank
        @NotNull
        String nombre_usuario,
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
