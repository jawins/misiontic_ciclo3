const URL_API = "http://localhost:8080/menus"

function get_data_form (evt) {
  // Indicar al evento que no recargue página
  evt.preventDefault()
  let persona = {
    nombre: evt.target.nombre.value,
    foto: evt.target.foto.value,
    menu: evt.target.descripcion.value,
    calificacionup:0,
    calificaciondown: 0,
    habilitado: 1,
  }
  alert("hola ")
  console.table(JSON.stringify(persona))
  send_data(persona)
  clear_input(evt.target)
}

function get_data_form2 (evt) {
    // Indicar al evento que no recargue página
    evt.preventDefault()
    
       file= evt.target;

      //send_imagen(file);
      send_imagen(file);
    
    console.table(JSON.stringify(file))
    
  }



function clear_input (form) {
  form.nombre.value = ""
  form.apellido.value = ""
  form.correo.value = ""
  //form.fecha_nacimiento.value = ""
  form.clave.value="";
  form.rol_id.value = "0"
  //var date = new Date();
  //date.setDate(form.fecha_nacimiento.value);
  //alert("fecha" + date);
  form.fecha_nacimiento.value ="";
}

async function send_data (persona) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(persona)
  })
  const text = await resp.text()
  alert(text)
}