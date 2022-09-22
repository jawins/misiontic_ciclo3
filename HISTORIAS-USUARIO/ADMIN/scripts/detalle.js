const UPDATE_FLAG = {
    update: false,
    id: null
  }
async function get_users (url) {
    // Enviar petición
    const resp = await fetch(url, {
      method: 'GET'
    })
    const users = await resp.json();
    return users;
  }
  
  function show_users (menu) {
    // Referenciar tabla
    const img = document.getElementById("img")
    const nombre = document.getElementById("nombre")
    const categorias = document.getElementById("categorias")
    const descripcion = document.getElementById("descripcion")
    const calificacionup = document.getElementById("cup")
    const calificaciondown = document.getElementById("cdown")
    //img.src=menu.foto;
    img.setAttribute("href",menu.foto);
    nombre.innerText=menu.nombre;
   descripcion.innerText=menu.menu;
   calificacionup.innerText=pcalificaion(menu.calificacionup,menu.calificaciondown);
   calificaciondown.innerText=pcalificaion(menu.calificaciondown,menu.calificacionup);

//alert(menu);
console.table(menu)

   
  }


  function pcalificaion(a,b)
  { let valor=0;

    valor=Math.trunc((a/(a+b))*100);
    return valor;
  }
  
  async function main () {
    const url = "http://localhost:8080/menus/"
    const users = await get_users(url+UPDATE_FLAG.id)
    show_users(users)
  }
  

  function get_params_url () {
    const params = window.location.search
    if (params) {
      const url = new URLSearchParams(params)
      const id = JSON.parse(url.get("id"))
      console.table(id)
      //set_data_form(persona)
     // document.getElementById("btn").innerText = "Actualizar"
      UPDATE_FLAG.update = true
      UPDATE_FLAG.id = id
    }
    main()
  }

  get_params_url ()
  