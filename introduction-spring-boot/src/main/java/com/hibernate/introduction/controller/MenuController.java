package com.hibernate.introduction.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hibernate.introduction.model.Menu;
import com.hibernate.introduction.services.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

    // Atributos
  MenuService service;

  // Constructor
  public MenuController() {
    service = new MenuService();
  }

  /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5501")
  @GetMapping
  public List<Menu> obtenerMenus() {
    return service.obtenerMenus();
  }
  
  @CrossOrigin(origins = "http://localhost:5501")
  @GetMapping("/{id}")
  public Menu obtenerMenuXId(@PathVariable(name = "id") int id) {
    return service.obtenerMenuXId(id);
  }
  @CrossOrigin(origins = "http://localhost:5501")
  @GetMapping("/commons")
  public List<Menu> obtenerMenusXnombreApellido(@RequestParam String nombre) {
    return service.obtenerMenusXnombreApellido(nombre);
  }
  @CrossOrigin(origins = "http://localhost:5501")
  @PostMapping
  public String crearMenu(@RequestBody Menu Menu) {
    return service.crearMenu(Menu);
  }
  @CrossOrigin(origins = "http://localhost:5501")
  @PutMapping
  public String actualizarMenu(@RequestBody Menu Menu) {
    return service.actualizarMenu(Menu);
  }
  @CrossOrigin(origins = "http://localhost:5501")
  @DeleteMapping("/{id}")
  public String eliminarMenu(@PathVariable(name = "id") int id) {
    return service.eliminarMenu(id);
  }


    
}
