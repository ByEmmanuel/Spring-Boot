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

document.getElementById('Siguiente-boton').addEventListener('click', function(event) {
    event.preventDefault(); // Evitar el comportamiento predeterminado del botón

    // Ocultar sección actual y mostrar siguiente sección
    document.getElementById('myForm').classList.add('left');
    setTimeout(function() {
        document.getElementById('myForm').classList.add('hidden');
        document.getElementById('apellidoSection').classList.remove('hidden');
    }, 400); // Ajusta el tiempo según la duración de la animación en CSS
});

document.getElementById('Siguiente-boton2').addEventListener('click', function(event) {
    event.preventDefault(); // Evitar el comportamiento predeterminado del botón

    // Ocultar sección actual y mostrar siguiente sección
    document.getElementById('apellidoSection').classList.add('left');
    setTimeout(function() {
        document.getElementById('apellidoSection').classList.add('hidden');
        document.getElementById('emailSection').classList.remove('hidden');
    }, 400); // Ajusta el tiempo según la duración de la animación en CSS
});

document.getElementById('Siguiente-boton3').addEventListener('click', function(event) {
    event.preventDefault(); // Evitar el comportamiento predeterminado del botón

    // Ocultar sección actual y mostrar siguiente sección
    document.getElementById('emailSection').classList.add('left');
    setTimeout(function() {
        document.getElementById('emailSection').classList.add('hidden');
        document.getElementById('passwordSection').classList.remove('hidden');
    }, 400); // Ajusta el tiempo según la duración de la animación en CSS
});

document.getElementById('Siguiente-boton4').addEventListener('click', function(event) {
    event.preventDefault(); // Evitar el comportamiento predeterminado del botón

    // Ocultar sección actual y mostrar siguiente sección
    
    document.getElementById('passwordSection').classList.add('left');
    setTimeout(function() {
        document.getElementById('passwordSection').classList.add('hidden');
        document.getElementById('direccionSection1').classList.remove('hidden');
    }, 400); // Ajusta el tiempo según la duración de la animación en CSS
    document.getElementById('Texto-Bienvenida').classList.add('hidden');
});

document.getElementById('Siguiente-boton5').addEventListener('click', function(event) {
    event.preventDefault(); // Evitar el comportamiento predeterminado del botón

    // Ocultar sección actual y mostrar siguiente sección

    document.getElementById('direccionSection1').classList.add('left');
    setTimeout(function() {
        document.getElementById('direccionSection1').classList.add('hidden');
        document.getElementById('direccionSection2').classList.remove('hidden');
    }, 400); // Ajusta el tiempo según la duración de la animación en CSS
});
