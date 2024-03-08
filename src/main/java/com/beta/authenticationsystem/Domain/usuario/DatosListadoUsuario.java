package com.beta.authenticationsystem.Domain.usuario;

public record DatosListadoUsuario (Long id,String nombre, String apellido, String email, String telefono,  Especialidad especialidad,
                                   String calle, String numero, String colonia, String ciudad, String estado, String pais, String complemento) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getEspecialidad(),
                    usuario.getDireccion().getCalle(),
                    usuario.getDireccion().getNumero(),
                    usuario.getDireccion().getColonia(),
                    usuario.getDireccion().getCiudad(),
                    usuario.getDireccion().getEstado(),
                    usuario.getDireccion().getPais(),
                    usuario.getDireccion().getComplemento());
    }



}