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
        @Pattern(regexp = "\\d{4,6}")
        String documento,
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
