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

import com.hibernate.introduction.model.Patologia;
import com.hibernate.introduction.services.PatologiaService;


@RestController
@RequestMapping("/Patologia")

public class PatologiaController {
     // Atributos
  PatologiaService service;

  // Constructor
  public PatologiaController() {
    service = new PatologiaService();
  }

  /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5500")
  @GetMapping
  public List<Patologia> obtenerPatologias() {
    return service.obtenerPatologias();
  }

  @GetMapping("/{id}")
  public Patologia obtenerPatologiaXId(@PathVariable(name = "id") int id) {
    return service.obtenerPatologiaXId(id);
  }

  @GetMapping("/commons")
  public List<Patologia> obtenerPatologiasXnombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
    return service.obtenerPatologiasXnombreApellido(nombre, apellido);
  }

  @PostMapping
  public String crearPatologia(@RequestBody Patologia Patologia) {
    return service.crearPatologia(Patologia);
  }

  @PutMapping
  public String actualizarPatologia(@RequestBody Patologia Patologia) {
    return service.actualizarPatologia(Patologia);
  }

  @DeleteMapping("/{id}")
  public String eliminarPatologia(@PathVariable(name = "id") int id) {
    return service.eliminarPatologia(id);
  }
    
}
