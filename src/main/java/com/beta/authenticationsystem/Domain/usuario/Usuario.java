package com.beta.authenticationsystem.Domain.usuario;


import com.beta.authenticationsystem.Domain.direccion.Direccion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "usuarios")
@Entity(name = "Usuario")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String tarjetaDeCredito;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private  Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.activo = true;
        this.nombre = datosRegistroUsuario.nombre();
        this.apellido = datosRegistroUsuario.apellido();
        this.email = datosRegistroUsuario.email();
        this.telefono = datosRegistroUsuario.telefono();
        this.tarjetaDeCredito = datosRegistroUsuario.tarjetaDeCredito();
        this.especialidad = datosRegistroUsuario.especialidad();
        this.direccion =  new Direccion(datosRegistroUsuario.direccion()) ;
    }


    //
//    public void  actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
//        if(datosActualizarMedico.nombre() != null){
//            this.nombre = datosActualizarMedico.nombre();
//        }
//        if (datosActualizarMedico.TarjetaDeCredito() != null) {
//            this.TarjetaDeCredito = datosActualizarMedico.TarjetaDeCredito();
//        }
//        if (datosActualizarMedico.direccion() != null) {
//            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
//        }
//    }
//
//    public void desactivarMedico() {
//        this.activo = false;
//    }
}
