package com.beta.authenticationsystem.Controllers;

import com.beta.authenticationsystem.Models.DatosBancarios.Bancario;
import com.beta.authenticationsystem.Models.DatosBancarios.RegistroDatosBancarios;
import com.beta.authenticationsystem.Models.direccion.Direccion;
import com.beta.authenticationsystem.Models.direccion.RegistroDatosDireccion;
import com.beta.authenticationsystem.Models.usuario.*;
import com.beta.authenticationsystem.Repository.BancariosRepository;
import com.beta.authenticationsystem.Repository.DireccionRepository;
import com.beta.authenticationsystem.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


//@SpringBootApplication
@RestController
@RequestMapping("/api/usuarios")
public class RegistroUsuarioController {


    //no recomendable para fines de testing
    @Autowired
    /*
     * @Autowired: Esta anotación inyecta la instancia de UsuarioRepository en este controlador.
     * UsuarioRepository es una interfaz de Spring Data JPA que proporciona métodos para interactuar
     * con la base de datos relacionada con la entidad (Usuario).
     */

    private UsuarioRepository usuarioRepository;

    /*
     * @PostMapping: Esta anotación indica que este método manejará solicitudes HTTP POST a la ruta "/medicos".
     *  public ResponseEntity<DatosRespuestaUsuario> registraUsuario(...): Este método maneja la solicitud POST y devuelve un ResponseEntity que encapsula los datos de respuesta del servidor y el código de estado HTTP.
     *   @RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario: Esta anotación indica que el cuerpo de la solicitud HTTP se mapeará al parámetro datosRegistroUsuario. La anotación @Valid se utiliza para validar automáticamente el objeto datosRegistroUsuario según las restricciones de validación especificadas en la clase DatosRegistroUsuario..
     */
    @PostMapping("/registroDatosPersonales")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid RegistroDatosPersonalesUsuario registroDatosPersonalesUsuario,
                                                                  UriComponentsBuilder uriComponentsBuilder){
        /*
         *   medicoRepository.save(...): Este método guarda un nuevo objeto Usuario en la base de datos utilizando el UsuarioRepository.
         *   El objeto Usuario se crea a partir de los datos proporcionados en el objeto datosRegistroUsuario.
         */
        Usuario usuario = usuarioRepository.save(new Usuario (registroDatosPersonalesUsuario));

        /*
         * Aquí se crea un objeto DatosRespuestaMedico utilizando los datos del objeto Medico guardado en la base de datos.
         * DatosRespuestaMedico es una clase que encapsula la información que deseas devolver como respuesta a la solicitud POST.
         */
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(),usuario.getNombre(), usuario.getApellido(),usuario.getEmail(),
                usuario.getTelefono(),usuario.getEspecialidad().toString()

//                new DatosDireccion(usuario.getDireccion().getCalle(),usuario.getDireccion().getNumero(),
//                        usuario.getDireccion().getColonia(),usuario.getDireccion().getCiudad(),
//                        usuario.getDireccion().getEstado(),usuario.getDireccion().getPais(),usuario.getDireccion().getComplemento()
    //                )
        );



        /*
         * Se construye la URL del recurso recién creado (/usuarios/{id}) y se devuelve en el encabezado Location de la respuesta.
         * Además, se crea una instancia de ResponseEntity con el código de estado 201 (CREATED) y el cuerpo de la respuesta contiene los datos del médico registrado.
         */
        URI url = uriComponentsBuilder.path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
        // Return 201 Created
        // URL donde encontrar al medico
        // GET http://direccionurldemiapi/usuarios/xx
    }


//
//    @PostMapping
//    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
//        //UsuarioRepository.save(new Usuario(datosRegistroUsuario));
//
//        //Usuario usuario = usuarioRepository.save(new Usuario (datosRegistroUsuario));
//        System.out.println("Tarjeta de credito"+datosRegistroUsuario.tarjetaDeCredito());
//        usuarioRepository.save(new Usuario (datosRegistroUsuario));
//
//
//    }

    @Autowired
    private DireccionRepository direccionRepository;
    @PostMapping("/registroDatosFacturacion")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid RegistroDatosDireccion registroDatosDireccionUsuario,
                                                                  UriComponentsBuilder uriComponentsBuilder){
        /*
         *   medicoRepository.save(...): Este método guarda un nuevo objeto Usuario en la base de datos utilizando el UsuarioRepository.
         *   El objeto Usuario se crea a partir de los datos proporcionados en el objeto datosRegistroUsuario.
         */
        Direccion usuarioDireccion = direccionRepository.save(new Direccion (registroDatosDireccionUsuario));

        /*
         * Aquí se crea un objeto DatosRespuestaMedico utilizando los datos del objeto Medico guardado en la base de datos.
         * DatosRespuestaMedico es una clase que encapsula la información que deseas devolver como respuesta a la solicitud POST.
         */
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                new RegistroDatosDireccion(
                        usuarioDireccion.getCalle(),
                        usuarioDireccion.getNumero(),
                        usuarioDireccion.getColonia(),
                        usuarioDireccion.getCiudad(),
                        usuarioDireccion.getEstado(),
                        usuarioDireccion.getPais(),
                        usuarioDireccion.getComplemento(),
                        usuarioDireccion.getNombre_usuario()
                )
        );



        /*
         * Se construye la URL del recurso recién creado (/direccion/{id}) y se devuelve en el encabezado Location de la respuesta.
         * Además, se crea una instancia de ResponseEntity con el código de estado 201 (CREATED) y el cuerpo de la respuesta contiene los datos del médico registrado.
         */
        URI url = uriComponentsBuilder.path("/direccion/{id}").buildAndExpand(usuarioDireccion.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
        // Return 201 Created
        // URL donde encontrar al medico
        // GET http://direccionurldemiapi/usuarios/xx
    }

    @Autowired
    private BancariosRepository bancarioRepository;
    @PostMapping("/registroDatosBancarios")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid RegistroDatosBancarios registroDatosBancariosUsuario,
                                                                  UriComponentsBuilder uriComponentsBuilder){
        /*
         *   medicoRepository.save(...): Este método guarda un nuevo objeto Usuario en la base de datos utilizando el UsuarioRepository.
         *   El objeto Usuario se crea a partir de los datos proporcionados en el objeto datosRegistroUsuario.
         */
        Bancario usuarioDatosBancarios = bancarioRepository.save(new Bancario(registroDatosBancariosUsuario));

        /*
         * Aquí se crea un objeto DatosRespuestaMedico utilizando los datos del objeto Medico guardado en la base de datos.
         * DatosRespuestaMedico es una clase que encapsula la información que deseas devolver como respuesta a la solicitud POST.
         */
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                new RegistroDatosBancarios(
                        usuarioDatosBancarios.getNombre_usuario(),
                        usuarioDatosBancarios.getBanco(),
                        usuarioDatosBancarios.getTipoDeCuenta(),
                        usuarioDatosBancarios.getNumeroDeTarjeta(),
                        usuarioDatosBancarios.getFechaDeExpiracion(),
                        usuarioDatosBancarios.getCvv()

                )
        );



        /*
         * Se construye la URL del recurso recién creado (/DatosBancarios/{id}) y se devuelve en el encabezado Location de la respuesta.
         * Además, se crea una instancia de ResponseEntity con el código de estado 201 (CREATED) y el cuerpo de la respuesta contiene los datos del médico registrado.
         *
         * TENGO QUE ACLARAR QUE LOS DATOS BANCARIOS NO SE DEBEN DE DEVOLVER EN EL CUERPO DE LA RESPUESTA
         * POR ENDE TENDRE QUE MODIFICAR ESTO PARA QUE LOS USUARIOS (FINALES) NO PUEDAN VER LOS DATOS BANCARIOS DE OTROS USUARIOS
         */
        URI url = uriComponentsBuilder.path("/DatosBancarios/{id}").buildAndExpand(usuarioDatosBancarios.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
        // Return 201 Created
        // URL donde encontrar al medico
        // GET http://direccionurldemiapi/usuarios/xx
    }
    @GetMapping
    public ResponseEntity<Page<ListadoDatosPersonalesUsuario>> listadoUsuarios(@PageableDefault(size = 2) Pageable paginacion){
        // return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(ListadoDatosPersonalesUsuario::new));
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> obtenerUsuarioPorId(@PathVariable Long id) {
        // Busca el usuario en la base de datos por su ID
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        // Verifica si el usuario existe
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Crea el objeto de respuesta con los datos del usuario
            DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getEmail(),
                    usuario.getTelefono(),
                    usuario.getEspecialidad().toString()
//                        new DatosDireccion(usuario.getDireccion().getCalle(),
//                                usuario.getDireccion().getNumero(),
//                                usuario.getDireccion().getColonia(),
//                                usuario.getDireccion().getCiudad(),
//                                usuario.getDireccion().getEstado(),
//                                usuario.getDireccion().getPais(),
//                                usuario.getDireccion().getComplemento()
//                        )
            );
            if (usuario.getActivo()) {
                // Retorna el usuario encontrado con código 200 OK
                return ResponseEntity.ok().body(datosRespuestaUsuario);
            } else {
                DatosRespuestaUsuario newDatosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getTelefono(),
                        usuario.getEspecialidad().toString()
                );
                return ResponseEntity.ok().body(newDatosRespuestaUsuario);
            }
            // Retorna el usuario encontrado con código 200 OK
            //return ResponseEntity.ok().body(datosRespuestaUsuario);
        } else {
            // Si el usuario no existe, retorna un código de error 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/desactivar")
    public ResponseEntity<String> desactivarUsuario(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setActivo(false); // Establecer activo como false
            usuarioRepository.save(usuario); // Guardar cambios en la base de datos
            return ResponseEntity.ok("Usuario desactivado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}