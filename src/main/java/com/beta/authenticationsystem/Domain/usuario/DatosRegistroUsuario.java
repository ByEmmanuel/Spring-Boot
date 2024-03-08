package com.beta.authenticationsystem.Domain.usuario;

import com.beta.authenticationsystem.Domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DatosRegistroUsuario(

        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        //6 para que sean 7 por prueba

        String tarjetaDeCredito,

        @NotNull
                /*
                *
                * Aqui se pondra por quien puede ser utilizado el sistema
                * */
        Especialidad especialidad,
        @NotNull
        @Valid
        DatosDireccion direccion) {

}
