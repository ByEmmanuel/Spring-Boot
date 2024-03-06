package com.beta.authenticationsystem.Domain.usuario;

public record DatosListadoUsuario (Long id,String nombre, String apellido, String email, String telefono, Especialidad especialidad
                        ) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getTelefono(), usuario.getEspecialidad());
    }


}