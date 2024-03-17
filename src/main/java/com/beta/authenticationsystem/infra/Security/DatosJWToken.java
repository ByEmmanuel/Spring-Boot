package com.beta.authenticationsystem.infra.Security;

public record DatosJWToken(String jwToken) {
    public DatosJWToken {
        if (jwToken == null || jwToken.isBlank()) {
            throw new IllegalArgumentException("El token no puede ser nulo o vacío");
        }
    }

}
