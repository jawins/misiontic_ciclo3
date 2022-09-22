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
    //example();
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
  
function setimagen(encoded){
    const img=document.getElementById("img");

    var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9\+\/\=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/\r\n/g,"\n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}

// Define the string, also meaning that you need to know the file extension
//var encoded = "Base64 encoded image returned from your service";

// Decode the string
var decoded = Base64.decode(encoded);
console.log(decoded);
var extension = undefined;
// do something like this
var lowerCase = decoded.toLowerCase();
if (lowerCase.indexOf("png") !== -1) extension = "png"
else if (lowerCase.indexOf("jpg") !== -1 || lowerCase.indexOf("jpeg") !== -1)
    extension = "jpg"
else extension = "tiff";
    //var base=base64.substring("data:image/".length,base64.indexOf(";base64"))
    //img.src=base64;
    //img.src = decoded;

// alternatively, you can do this
img.src = "data:image/" + extension + ";base64," + encoded;

}

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
    setimagen(text)
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
  