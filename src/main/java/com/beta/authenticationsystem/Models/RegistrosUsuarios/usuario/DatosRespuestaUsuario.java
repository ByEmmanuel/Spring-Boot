package com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario;

import com.beta.authenticationsystem.Models.RegistrosUsuarios.DatosBancarios.RegistroDatosBancarios;
import com.beta.authenticationsystem.Models.RegistrosUsuarios.direccion.RegistroDatosDireccion;

public record DatosRespuestaUsuario(Long id, String nombre, String Apellido, String email, String telefono, String especialidad,
                                    RegistroDatosDireccion direccion, RegistroDatosBancarios datosBancarios) {
    public DatosRespuestaUsuario (Long id, String nombre, String Apellido,String email, String telefono, String especialidad){
        this(id,nombre,Apellido,email,telefono,especialidad,null,null);
    }

    public DatosRespuestaUsuario (RegistroDatosDireccion direccion){
        this(null,null,null,null,null,null,direccion,null);
    }

    public DatosRespuestaUsuario (RegistroDatosBancarios datosBancarios){
        this(null,null,null,null,null,null,null,datosBancarios);
    }
}


