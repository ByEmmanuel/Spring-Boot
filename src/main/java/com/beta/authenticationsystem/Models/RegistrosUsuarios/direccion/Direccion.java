package com.beta.authenticationsystem.Models.RegistrosUsuarios.direccion;


import com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "datos_Direccion")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    public Long id;

    private Long id_usuario;

    @OneToOne
    @JoinColumn(name = "usuario_id")  // Cambiado de "usuario" a "usuario_id"
    private Usuario usuario_id;

    @Column(name = "activo")
    private boolean activo;


    private String nombre_usuario;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private String pais;
    private String complemento;

    public Direccion(RegistroDatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.colonia = direccion.colonia();
        this.ciudad = direccion.ciudad();
        this.estado = direccion.estado();
        this.pais = direccion.pais();
        this.complemento = direccion.complemento();
        this.id_usuario = usuario_id.getId();

    }

    public Direccion actualizarDatos(RegistroDatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.colonia = direccion.colonia();
        this.ciudad = direccion.ciudad();
        this.estado = direccion.estado();
        this.pais = direccion.pais();
        this.complemento = direccion.complemento();

        return this;
    }

}

