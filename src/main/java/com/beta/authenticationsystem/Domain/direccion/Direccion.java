package com.beta.authenticationsystem.Domain.direccion;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {


    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private String pais;
    private String complemento;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.colonia = direccion.colonia();
        this.ciudad = direccion.ciudad();
        this.estado = direccion.estado();
        this.pais = direccion.pais();
        this.complemento = direccion.complemento();
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
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

