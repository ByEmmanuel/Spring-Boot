package com.beta.authenticationsystem.infra.Security;


import com.beta.authenticationsystem.Repository.Registros.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Obtener el token del encabezado
        String authHeader = request.getHeader("Authorization");

        // Verificar si el token no es nulo y tiene el formato correcto
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extraer el token de autenticación
            String token = authHeader.replace("Bearer ", "");
            try {
                // Verificar el token y obtener el sujeto
                String subject = tokenService.getSubject(token);
                if (subject != null) {
                    // Buscar el usuario en la base de datos utilizando el sujeto (email)
                    UserDetails usuario = usuarioRepository.findByEmail(subject);
                    if (usuario != null) {
                        // Crear una autenticación con el usuario y establecerla en el contexto de seguridad
                        Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities() );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (RuntimeException e) {

                // Manejar errores al verificar o decodificar el token

                logger.error("Error al verificar o decodificar el token: " + e.getMessage());
                //ResponseEntity.status(401).body("Error al verificar o decodificar el token").toString();
            }
        }

        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
