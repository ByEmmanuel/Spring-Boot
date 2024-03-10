/*
document.getElementById('myForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var form = this;
    form.classList.add('left');
    setTimeout(function() {
        form.style.display = 'none';
        document.getElementById('additionalComponent').classList.remove('hidden');
        document.getElementById('additionalComponent').classList.add('visible');
    }, 500); // Ajusta el tiempo según la duración de la animación en CSS
});
*/

// Almacenar los datos en una lista o array
const listaDatosUsuario = Object; // Puedes inicializarla fuera del evento si necesitas conservar los datos entre envíos
const listaDatosFacturacion = Object;
const  listaDatosBancarios = Object;

function manejarClickSiguiente(botonId, seccionActualId, siguienteSeccionId) {
    document.getElementById(botonId).addEventListener('click', function(event) {
        event.preventDefault(); // Evitar el comportamiento predeterminado del botón

        // Ocultar sección actual y mostrar siguiente sección
        document.getElementById(seccionActualId).classList.add('left');
        setTimeout(function() {
            document.getElementById(seccionActualId).classList.add('hidden');
            document.getElementById(siguienteSeccionId).classList.remove('hidden');
        }, 400); // Ajusta el tiempo según la duración de la animación en CSS

        if (seccionActualId === "passwordSection" || seccionActualId === "direccionSection1"){
            document.getElementById('Texto-Bienvenida').classList.add('hidden');
        }
    });
}

// Llama a la función para cada par de botón y sección
manejarClickSiguiente('Siguiente-boton', 'myForm', 'apellidoSection');
manejarClickSiguiente('Siguiente-boton2', 'apellidoSection', 'especialidadSection');
manejarClickSiguiente('Siguiente-boton3', 'especialidadSection', 'emailSection')
manejarClickSiguiente('Siguiente-boton4', 'emailSection', 'telefonoSection');
manejarClickSiguiente('Siguiente-boton5', 'telefonoSection', 'passwordSection');
manejarClickSiguiente('Siguiente-boton6', 'passwordSection', 'direccionSection1');
manejarClickSiguiente('Siguiente-boton7', 'direccionSection1', 'direccionSection2');
manejarClickSiguiente('Siguiente-boton8', 'direccionSection2', 'datosBancariosSection');



EnviarDatosAPI = () => {

};


    listaDatosUsuario.assign(datosUsuario);
    listaDatosFacturacion.assign(datosDireccionUsuario);
    listaDatosBancarios.assign(datosBancariosUsuario);

    console.log(listaDatosUsuario);
    console.log(listaDatosFacturacion);
    console.log(listaDatosBancarios);

    //console.log(datosUsuario['datosPersonalesUsuario']);
    //console.log(datosFacturacionUsuario['datosFacturacionUsuario']);
    //console.log(datosBancariosUsuario['datosBancariosUsuario']);


    // AQUI PUEDO HACER MAS VALIDAIONES DE LOS DATOS ANTES DE ENVIARLOS A LA BASE DE DATOS



async function realizarSolicitudes() {
        // Declarar las variables que almacenarán los datos de los formularios
        // Capturar los valores de los campos del formulario Datos Personales Usuario
        const nombre = document.getElementById('Nombre').value;
        const apellido = document.getElementById('Apellido').value;
        const email = document.getElementById('Email').value;
        const especialidad = document.getElementById('Especialidad').value;

        const telefono = document.getElementById('Telefono').value;
        const password = document.getElementById('password').value;

        // Capturar los valores de los campos del formulario Datos Facturación Usuario
        const calle = document.getElementById('calle').value;
        const numero = document.getElementById('numero').value;
        const colonia = document.getElementById('colonia').value;
        const ciudad = document.getElementById('ciudad').value;
        const estado = document.getElementById('estado').value;
        const pais = document.getElementById('pais').value;

        // Capturar los valores de los campos del formulario Datos Bancarios Usuario
        const banco = document.getElementById('banco').value;
        const tipo_de_cuenta = document.getElementById('tipoDeCuenta').value;
        const numero_de_tarjeta = document.getElementById('numerodetarjeta').value;
        const fecha_de_expiracion = document.getElementById('fechaDeExpiracion').value;
        const cvv = document.getElementById('cvv').value;



        const datosUsuario = {

            nombre: nombre,
            apellido: apellido,
            email: email,
            telefono: telefono,
            contraseña: password,
            especialidad: especialidad

        };

        const datosDireccionUsuario = {

            nombre_usuario: nombre,
            calle: calle,
            numero: numero,
            colonia: colonia,
            ciudad: ciudad,
            estado: estado,
            pais: pais

        };

        const datosBancariosUsuario = {

            nombre_usuario: nombre,
            banco: banco,
            tipoDeCuenta: tipo_de_cuenta,
            numeroDeTarjeta: numero_de_tarjeta,
            fechaDeExpiracion: fecha_de_expiracion,
            cvv: cvv

        };

        console.log("Los datos De direccion son ; "+datosDireccionUsuario.calle);
        console.log("Los datos bancarios son ; "+datosBancariosUsuario.tipoDeCuenta);

        if (datosUsuario.nombre === "" ||
            datosUsuario.apellido === "" ||
            datosUsuario.email === "" ||
            datosUsuario.telefono === "" ||
            datosUsuario.contraseña === "" ||
            datosUsuario.especialidad === "" ||
            datosDireccionUsuario.calle === "" ||
            datosDireccionUsuario.numero === "" ||
            datosDireccionUsuario.colonia === "" ||
            datosDireccionUsuario.ciudad === "" ||
            datosDireccionUsuario.estado === "" ||
            datosDireccionUsuario.pais === "" ||
            datosBancariosUsuario.banco === "" ||
            datosBancariosUsuario.tarjeta === "" ||
            datosBancariosUsuario.fecha === "" ||
            datosBancariosUsuario.cvv === "" ||
            datosBancariosUsuario.tipoDeCuenta === "") {
            alert('Todos los campos son obligatorios')
            throw new Error('Todos los campos son obligatorios');
        }

    try {


        const opcion1 = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosUsuario)
        };
        const opcion2 = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosDireccionUsuario)
        };
        const opcion3 = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosBancariosUsuario)
        };

        // Primera solicitud
        const respuesta1 = await fetch('http://localhost:8080/api/usuarios/registroDatosPersonales', opcion1);
        const datos1 = await respuesta1.json();
        console.log('Respuesta 1:', datos1);

        // Segunda solicitud
        const respuesta2 = await fetch('http://localhost:8080/api/usuarios/registroDatosFacturacion', opcion2);
        const datos2 = await respuesta2.json();
        console.log('Respuesta 2:', datos2);

        // Tercera solicitud
        const respuesta3 = await fetch('http://localhost:8080/api/usuarios/registroDatosBancarios', opcion3);
        const datos3 = await respuesta3.json();
        console.log('Respuesta 3:', datos3);

        // Puedes manejar las respuestas aquí
    } catch (error) {
        console.error('Error al realizar las solicitudes:', error);
    }

}

realizarSolicitudes().then(r => console.log('Solicitudes realizadas'));
