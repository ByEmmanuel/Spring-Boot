package com.beta.authenticationsystem.Models.RegistrosUsuarios.DatosBancarios;

import com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "datos_bancarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class Bancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    public Long id;

    @OneToOne
    @JoinColumn(name = "cuentas")
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

}


