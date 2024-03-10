package com.beta.authenticationsystem.Models.direccion;


import com.beta.authenticationsystem.Models.usuario.Usuario;
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

    @OneToOne
    @JoinColumn(name = "id_cliente")  // Cambiado de "usuario" a "usuario_id"
    private Usuario usuario;

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
        this.nombre_usuario = direccion.nombre_usuario();
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.colonia = direccion.colonia();
        this.ciudad = direccion.ciudad();
        this.estado = direccion.estado();
        this.pais = direccion.pais();
        this.complemento = direccion.complemento();
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

