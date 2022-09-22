const URL_API = "http://localhost:8080/personas"

function get_data_form (evt) {
  // Indicar al evento que no recargue página
  evt.preventDefault()
  let persona = {
    nombre: evt.target.nombre.value,
    apellido: evt.target.apellido.value,
    correo: evt.target.correo.value,
    clave:evt.target.clave.value,
    fecha_nacimiento: evt.target.fecha_nacimiento.value,
    rol_id: evt.target.rol_id.value,
  }
  console.table(JSON.stringify(persona))
  send_data(persona)
  clear_input(evt.target)
}

function get_data_form2 (evt) {
    // Indicar al evento que no recargue página
    evt.preventDefault()
    
       file= evt.target;

      //send_imagen(file);
      send_imagen2(file);
    
    console.table(JSON.stringify(file))
    
  }



function clear_input (form) {
  form.nombre.value = ""
  form.apellido.value = ""
  form.correo.value = ""
  //form.fecha_nacimiento.value = ""
  form.clave.value="";
  form.rol_id.value = "0"
  var date = new Date();
  date.setDate(form.fecha_nacimiento.value);
  alert("fecha" + date);
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

async function send_imagen2 (objeto) {
    // Enviar petición
    const URL_API2 = "http://localhost:8080/upload"
    //const form = document.getElementById('fileUploadForm');
    const payload = new FormData(objeto);
    const resp = await fetch(URL_API2, {
      method: 'POST',
      body: payload
    })
    const text = await resp.text();
    const obj = JSON.parse(text);
    //const img = document.getElementById('img');
    //img.href=obj.url;

    alert(obj.url);
    example();
  }

 /// const fs = require('fs/promises');

  //async function example() {
   // try {
    //  const content = 'Some content!';
   //   await fs.writeFile('./images/test.txt', content);
   // } catch (err) {
   //   console.log(err);
 //   }
 // }
  


async function send_imagen (objeto) {
    // Enviar petición
    const URL_API2 = "http://localhost:8080/upload"
    const form = document.getElementById('fileUploadForm');
    const payload = new FormData(form);
    const resp = await fetch(URL_API2, {
      method: 'POST',
      body: payload
    })
    const text = await resp.text();
    //const img = document.getElementById('img');
    //img.href=text.url;
    alert(text)
  }

async function get_data () {
    // Enviar petición
    const resp = await fetch(URL_API, {
      mode: 'no-cors',
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      
    })
    const text = await resp.text()
    alert(text)
    //console.table(await resp.text())
  }

  async function obtener_usuarios () {
    const uri_api = 'http://localhost:8080/rol'
    //Realizar petición
    const resp = await fetch(uri_api)
    .then(response => {
        if (response.status == 200) {
          return response.json();
        } else {
          throw new Error(response.status);
        }
      });
    //console.log("resp-> ", resp)
    const json = await resp;
    //console.log("json->", json)
    return json
  }
  