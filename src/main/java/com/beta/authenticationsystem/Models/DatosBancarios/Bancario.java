package com.beta.authenticationsystem.Models.DatosBancarios;

import com.beta.authenticationsystem.Models.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "datos_bancarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nombre")
public class Bancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "activo")
    private boolean activo;


    private String nombre_usuario;
    private String banco;
    private String tipoDeCuenta;
    private String numeroDeTarjeta;
    private String fechaDeExpiracion;
    private String cvv;


    public Bancario(RegistroDatosBancarios bancarios) {
        this.nombre_usuario = bancarios.nombre_usuario();
        this.banco = bancarios.banco();
        this.tipoDeCuenta = bancarios.tipoDeCuenta();
        this.numeroDeTarjeta = bancarios.numeroDeTarjeta();
        this.fechaDeExpiracion = bancarios.fechaDeExpiracion();
        this.cvv = bancarios.cvv();
        this.activo = true;
    }

    public Bancario actualizarDatos(RegistroDatosBancarios bancarios) {

        this.nombre_usuario = bancarios.nombre_usuario();
        this.banco = bancarios.banco();
        this.tipoDeCuenta = bancarios.tipoDeCuenta();
        this.numeroDeTarjeta = bancarios.numeroDeTarjeta();
        this.fechaDeExpiracion = bancarios.fechaDeExpiracion();
        this.cvv = bancarios.cvv();

        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}


