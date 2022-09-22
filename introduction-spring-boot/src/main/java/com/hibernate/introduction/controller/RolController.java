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

import com.hibernate.introduction.model.Rol;
import com.hibernate.introduction.services.RolService;


@RestController
@RequestMapping("/rol")
public class RolController {
    // Atributos
  RolService service;

  // Constructor
  public RolController() {
    service = new RolService();
  }

  /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5501")
  @GetMapping
  public List<Rol> obtenerRols() {
    return service.obtenerRols();
  }

  @GetMapping("/{id}")
  public Rol obtenerRolXId(@PathVariable(name = "id") int id) {
    return service.obtenerRolXId(id);
  }

  @GetMapping("/commons")
  public List<Rol> obtenerRolsXnombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
    return service.obtenerRolsXnombreApellido(nombre, apellido);
  }

  @PostMapping
  public String crearRol(@RequestBody Rol Rol) {
    return service.crearRol(Rol);
  }

  @PutMapping
  public String actualizarRol(@RequestBody Rol Rol) {
    return service.actualizarRol(Rol);
  }

  @DeleteMapping("/{id}")
  public String eliminarRol(@PathVariable(name = "id") int id) {
    return service.eliminarRol(id);
  }
    
}
