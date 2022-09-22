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

import com.hibernate.introduction.model.Menu_has_patologia;
import com.hibernate.introduction.services.Menu_has_patologiaService;

@RestController
@RequestMapping("/Menu_has_patologias")
public class Menu_has_patologiaController {

    // Atributos
  Menu_has_patologiaService service;

  // Constructor
  public Menu_has_patologiaController() {
    service = new Menu_has_patologiaService();
  }

  /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5500")
  @GetMapping
  public List<Menu_has_patologia> obtenerMenu_has_patologias() {
    return service.obtenerMenu_has_patologias();
  }
  @CrossOrigin(origins = "http://localhost:5500")
  @GetMapping("/{id}")
  public Menu_has_patologia obtenerMenu_has_patologiaXId(@PathVariable(name = "id") int id) {
    return service.obtenerMenu_has_patologiaXId(id);
  }
  @CrossOrigin(origins = "http://localhost:5500")
  @GetMapping("/commons")
  public List<Menu_has_patologia> obtenerMenu_has_patologiasXnombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
    return service.obtenerMenu_has_patologiasXnombreApellido(nombre, apellido);
  }
  @CrossOrigin(origins = "http://localhost:5500")
  @PostMapping
  public String crearMenu_has_patologia(@RequestBody Menu_has_patologia Menu_has_patologia) {
    return service.crearMenu_has_patologia(Menu_has_patologia);
  }
  @CrossOrigin(origins = "http://localhost:5500")
  @PutMapping
  public String actualizarMenu_has_patologia(@RequestBody Menu_has_patologia Menu_has_patologia) {
    return service.actualizarMenu_has_patologia(Menu_has_patologia);
  }
  @CrossOrigin(origins = "http://localhost:5500")
  @DeleteMapping("/{id}")
  public String eliminarMenu_has_patologia(@PathVariable(name = "id") int id) {
    return service.eliminarMenu_has_patologia(id);
  }

    
}
