package com.hibernate.introduction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Indicar que la clase Persona representa una entidad de la BD
@Entity
// Indicar la entidad/tabla que representa la clase Persona
@Table(name = "menu")
public class Menu {

  // ATRIBUTOS
  @Id
  private int id;
  private String nombre;
  private String menu;
  private String foto;
  private int calificacionup;
  private int calificaciondown;
  private boolean habilitado;
public Menu() {
}
public Menu(int id, String nombre, String menu, String foto, int calificacionup, int calificaciondown,
        boolean habilitado) {
    this.id = id;
    this.nombre = nombre;
    this.menu = menu;
    this.foto = foto;
    this.calificacionup = calificacionup;
    this.calificaciondown = calificaciondown;
    this.habilitado = habilitado;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getMenu() {
    return menu;
}
public void setMenu(String menu) {
    this.menu = menu;
}
public String getFoto() {
    return foto;
}
public void setFoto(String foto) {
    this.foto = foto;
}
public int getCalificacionup() {
    return calificacionup;
}
public void setCalificacionup(int calificacionup) {
    this.calificacionup = calificacionup;
}
public int getCalificaciondown() {
    return calificaciondown;
}
public void setCalificaciondown(int calificaciondown) {
    this.calificaciondown = calificaciondown;
}
public boolean isHabilitado() {
    return habilitado;
}
public void setHabilitado(boolean habilitado) {
    this.habilitado = habilitado;
}



    
}
