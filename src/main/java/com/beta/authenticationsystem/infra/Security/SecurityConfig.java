package com.beta.authenticationsystem.infra.Security;


import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.List;
//
//
//
//
//public class SecurityConfig implements SecurityFilterChain {
//
////
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        http.csrf(csrf -> csrf.disable())
////                .sessionManagement((sess-> sess.sessionCreationPolicy(SessionCreationPolicy.NEVER)))
////                .authorizeHttpRequests((request -> request.requestMatchers(HttpMethod.POST,"api/usuarios")
////                        .permitAll()
////                            .anyRequest()
////                            .authenticated()
////
////
////
////
////                                ));
////        return http.build();
////        }
//
//
//
//    @Override
//    public boolean matches(HttpServletRequest request) {
//        return false;
//    }
//
//    @Override
//    public List<Filter> getFilters() {
//        return null;
//    }
//}