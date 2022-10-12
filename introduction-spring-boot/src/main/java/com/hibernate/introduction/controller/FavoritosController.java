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

import com.hibernate.introduction.model.Favoritos;
import com.hibernate.introduction.services.FavoritosService;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

     // Atributos
  FavoritosService service;

  // Constructor
  public FavoritosController() {
    service = new FavoritosService();
  }

  /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5500")
  @GetMapping
  public List<Favoritos> obtenerFavoritoss() {
    return service.obtenerFavoritoss();
  }

  @GetMapping("/{id}")
  public Favoritos obtenerFavoritosXId(@PathVariable(name = "id") int id) {
    return service.obtenerFavoritosXId(id);
  }

  @GetMapping("/commons")
  public List<Favoritos> obtenerFavoritossXnombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
    return service.obtenerFavoritossXnombreApellido(nombre, apellido);
  }

  @PostMapping
  public String crearFavoritos(@RequestBody Favoritos Favoritos) {
    return service.crearFavoritos(Favoritos);
  }

  @PutMapping
  public String actualizarFavoritos(@RequestBody Favoritos Favoritos) {
    return service.actualizarFavoritos(Favoritos);
  }

  @DeleteMapping("/{id}")
  public String eliminarFavoritos(@PathVariable(name = "id") int id) {
    return service.eliminarFavoritos(id);
  }
    
}
