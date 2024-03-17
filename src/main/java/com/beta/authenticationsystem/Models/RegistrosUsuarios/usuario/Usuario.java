package com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario;


import com.beta.authenticationsystem.Models.RegistrosUsuarios.DatosBancarios.Bancario;
import com.beta.authenticationsystem.Models.RegistrosUsuarios.direccion.Direccion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "usuarios")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    public Long id;

    @OneToOne(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private Direccion direccion;

    //@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    //private List<Bancario> cuentas;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Bancario cuentas;

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
        this.direccion = datosRegistroUsuario.direccion();
        this.cuentas = datosRegistroUsuario.bancario();
        //this.tarjetaDeCredito = datosRegistroUsuario.tarjetaDeCredito();
        this.especialidad = datosRegistroUsuario.especialidad();
        //this.direccion =  new Direccion(datosRegistroUsuario.direccion()) ;
        this.direccion.setId_usuario(this.id);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
