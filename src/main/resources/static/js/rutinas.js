//Esta función carga una imagen local en la página
function readURL(input) {
    if (input.files && input.files[0]) {
        var lector = new FileReader();
        lector.onload = function(e) {
            $('#blah').attr('src',e.target.result)
                    .height(200);
        };
        lector.readAsDataURL(input.files[0]);
    }
}

//Esta función se ejecuta "dentro" del browser "localmente" y lo que hace es
//incluir un elemento en el ccarrito de compras si hay existencias

function addCart(formulario){    
    window.alert("estamos en la funcion");
    var idProducto = formulario.elements[0].value;
    var existencias = formulario.elements[1].value;
    if (existencias>0){
        var ruta = "/carrito/agregar/"+ idProducto;
        window.alert("La ruta es: "+ruta);
        $("#resultBlock").load(ruta);
        load(ruta);        
    }else{
        window.alert("No hay existencias del producto...");
    }
}

