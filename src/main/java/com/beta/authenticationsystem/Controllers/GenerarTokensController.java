package com.beta.authenticationsystem.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerarTokensController {

    @RequestMapping("/generarToken")
    public String generarToken() {

     return ResponseEntity.ok("Token generado").toString();
    }

}
