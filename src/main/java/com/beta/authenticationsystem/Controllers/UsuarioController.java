package com.beta.authenticationsystem.Controllers;

import com.beta.authenticationsystem.Domain.direccion.DatosDireccion;
import com.beta.authenticationsystem.Domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


//@SpringBootApplication
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {


    //no recomendable para fines de testing
    @Autowired
    /*
     * @Autowired: Esta anotación inyecta la instancia de MedicoRepository en este controlador.
     * MedicoRepository es una interfaz de Spring Data JPA que proporciona métodos para interactuar
     * con la base de datos relacionada con la entidad (Medico).
     */

    private UsuarioRepository usuarioRepository;

    /*
     * @PostMapping: Esta anotación indica que este método manejará solicitudes HTTP POST a la ruta "/medicos".
     *  public ResponseEntity<DatosRespuestaMedico> registrarMedico(...): Este método maneja la solicitud POST y devuelve un ResponseEntity que encapsula los datos de respuesta del servidor y el código de estado HTTP.
     *   @RequestBody @Valid DatosRegistroMedico datosRegistroMedico: Esta anotación indica que el cuerpo de la solicitud HTTP se mapeará al parámetro datosRegistroMedico. La anotación @Valid se utiliza para validar automáticamente el objeto datosRegistroMedico según las restricciones de validación especificadas en la clase DatosRegistroMedico.
     */
    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                                 UriComponentsBuilder uriComponentsBuilder){
        /*
         *   medicoRepository.save(...): Este método guarda un nuevo objeto Usuario en la base de datos utilizando el UsuarioRepository.
         *   El objeto Usuario se crea a partir de los datos proporcionados en el objeto datosRegistroUsuario.
         */
        Usuario usuario = this.usuarioRepository.save(new Usuario (datosRegistroUsuario));

        /*
         * Aquí se crea un objeto DatosRespuestaMedico utilizando los datos del objeto Medico guardado en la base de datos.
         * DatosRespuestaMedico es una clase que encapsula la información que deseas devolver como respuesta a la solicitud POST.
         */
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(),usuario.getNombre(), usuario.getApellido(),usuario.getEmail(),
                usuario.getTelefono(),usuario.getEspecialidad().toString(),
                new DatosDireccion(usuario.getDireccion().getCalle(),usuario.getDireccion().getNumero(),
                        usuario.getDireccion().getColonia(),usuario.getDireccion().getCiudad(),
                        usuario.getDireccion().getEstado(),usuario.getDireccion().getPais(),usuario.getDireccion().getComplemento()));



        /*
         * Se construye la URL del recurso recién creado (/usuarios/{id}) y se devuelve en el encabezado Location de la respuesta.
         * Además, se crea una instancia de ResponseEntity con el código de estado 201 (CREATED) y el cuerpo de la respuesta contiene los datos del médico registrado.
         */
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
        // Return 201 Created
        // URL donde encontrar al medico
        // GET http://direccionurldemiapi/medicos/xx
    }


    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listadoUsuarios(@PageableDefault(size = 10) Pageable paginacion){
        // return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new));
    }
}