package com.beta.authenticationsystem.Domain.usuario;

import com.beta.authenticationsystem.Domain.direccion.DatosDireccion;

public record DatosRespuestaUsuario(Long id, String nombre, String Apellido,String email, String telefono, String TarjetaDeCredito,
                                    DatosDireccion direccion) {
}
