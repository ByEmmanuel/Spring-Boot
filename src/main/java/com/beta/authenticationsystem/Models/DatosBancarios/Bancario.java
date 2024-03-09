package com.beta.authenticationsystem.Models.DatosBancarios;

import com.beta.authenticationsystem.Models.direccion.RegistroDatosDireccion;
import com.beta.authenticationsystem.Models.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;



@Table(name = "datos_bancarios")
@Entity(name = "Bancario")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nombre")
public class Bancario extends Usuario{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    public Long id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    private String nombre;
    private String banco;
    private String tipoDeCuenta;
    private String numeroDeTarjeta;
    private String fechaDeExpiracion;
    private String cvv;


    public Bancario(RegistroDatosBancarios bancarios) {
        this.nombre = bancarios.nombre();
        this.banco = bancarios.banco();
        this.tipoDeCuenta = bancarios.tipoDeCuenta();
        this.numeroDeTarjeta = bancarios.numeroDeTarjeta();
        this.fechaDeExpiracion = bancarios.fechaDeExpiracion();
        this.cvv = bancarios.cvv();
    }

    public Bancario actualizarDatos(RegistroDatosBancarios bancarios) {

        this.nombre = bancarios.nombre();
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


