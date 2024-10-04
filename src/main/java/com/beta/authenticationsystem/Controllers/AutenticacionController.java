package com.beta.authenticationsystem.Controllers;


import com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario.DatosAutenticacionUsuario;
import com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario.Usuario;

import com.beta.authenticationsystem.infra.Security.DatosJWToken;
import com.beta.authenticationsystem.infra.Security.SecurityConfig;
import com.beta.authenticationsystem.infra.Security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;


    SecurityConfig securityConfig;


    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWToken> autenticarUsuarion(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.Email(), datosAutenticacionUsuario.Contraseña());
        try {
            Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
            System.out.println("Usuario autenticado: " + usuarioAutenticado);
            System.out.println("Usuario autenticado: " + usuarioAutenticado.getPrincipal());
            var JWToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new DatosJWToken(JWToken));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    // Este método es el que se encarga de obtener el usuario autenticado a partir de la autenticación
    // Pero esta mal realizado :/
//    private Usuario obtenerUsuarioDesdeAutenticacion(Authentication authentication) {
//
//    }
    public static void main(String[] args) {
        System.out.println("Pass: " + new BCryptPasswordEncoder().encode("Admin"));
    }

}
