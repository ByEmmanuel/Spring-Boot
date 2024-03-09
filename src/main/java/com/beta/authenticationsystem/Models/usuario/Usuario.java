package com.beta.authenticationsystem.Models.usuario;


import com.beta.authenticationsystem.Models.DatosBancarios.Bancario;
import com.beta.authenticationsystem.Models.direccion.Direccion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    @Column(updatable = false, insertable = false)
    public Long id;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Direccion direccion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Bancario> cuentas;

    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String telefono;
    //private String tarjetaDeCredito;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private  Especialidad especialidad;


//    @Embedded
//    private Direccion direccion;

    public Usuario(RegistroDatosPersonalesUsuario datosRegistroUsuario) {
        this.activo = true;
        this.nombre = datosRegistroUsuario.nombre();
        this.apellido = datosRegistroUsuario.apellido();
        this.email = datosRegistroUsuario.email();
        this.telefono = datosRegistroUsuario.telefono();
        this.contraseña = datosRegistroUsuario.contraseña();
        //this.tarjetaDeCredito = datosRegistroUsuario.tarjetaDeCredito();
        this.especialidad = datosRegistroUsuario.especialidad();
        //this.direccion =  new Direccion(datosRegistroUsuario.direccion()) ;
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
