async function get_data_form (evt) {
  // Indicar al evento que no recargue página
  const url = "http://localhost:8080/menus/commons"
    
  evt.preventDefault()
  const parametro="?nombre="+evt.target.search.value;
  //alert(url+parametro)
  if(evt.target.search.value){
  const listmenu = await get_users(url+parametro)
  console.table(listmenu);
   show_users(listmenu);
  }
   else{
   // alert(evt.target.search.value)
    main();
   }
}


async function get_users (url) {
    // Enviar petición
    const resp = await fetch(url, {
      method: 'GET'
    })
    const users = await resp.json();
    
    return users;
  }
  
  function show_users (menus) {
    // Referenciar tabla
    const table = document.getElementById("contenedor")
    let tbody = "";
    // Iterar users
    for (let i = 0; i < menus.length; i++) {
      //const arrayDate = menus[i].fecha_nacimiento.split("T")
      const obj = JSON.stringify(menus[i])
      tbody += 
      `<div class="col">
      <div class="card shadow-sm">
          <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
              <title>Placeholder</title>
              <rect width="100%" height="100%" fill="#55595c"></rect>
              <image href="${menus[i].foto}" height="225" width="100%"/>
          </svg>

          <div class="card-body">
                  <p class="card-text">${menus[i].nombre}</p>
                  <p class="card-text">{Categoria}</p>
                  <p class="card-text">${menus[i].menu}</p>
                  <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary"><a href="detalle_menu.html?id=${menus[i].id}"> Ver</a></button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                  </div>
                  <small class="text-muted">9 mins</small>
              </div>
          </div>
      </div>
</div>`


    }
    //tbody += "</tbody>"
    table.innerHTML = tbody
  }
  
  async function main () {
    const url = "http://localhost:8080/menus"
    const users = await get_users(url)
    show_users(users)
  }
  
  main()