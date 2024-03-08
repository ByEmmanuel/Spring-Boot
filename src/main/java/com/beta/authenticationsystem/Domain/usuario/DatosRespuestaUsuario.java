package com.beta.authenticationsystem.Domain.usuario;

import com.beta.authenticationsystem.Domain.direccion.DatosDireccion;

public record DatosRespuestaUsuario(Long id, String nombre, String Apellido,String email, String telefono, String especialidad,
                                    DatosDireccion direccion) {
    public DatosRespuestaUsuario (Long id, String nombre, String Apellido,String email, String telefono, String especialidad){
        this(id,nombre,Apellido,email,telefono,especialidad,null);
    }
}


