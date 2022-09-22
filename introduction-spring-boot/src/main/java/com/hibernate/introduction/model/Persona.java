package com.hibernate.introduction.model;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indicar que la clase Persona representa una entidad de la BD
@Entity
// Indicar la entidad/tabla que representa la clase Persona
@Table(name = "user")
public class Persona {

  // ATRIBUTOS
  @Id
  private int id;
  private String nombre;
  private String apellido;
  private String correo;
  private String clave;
  private Calendar fecha_nacimiento;
  private int  rol_id;
  public Persona() {
  }
  public Persona(int id, String nombre, String apellido, String correo, String clave, Calendar fecha_nacimiento,
      int rol_id) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.clave = clave;
    this.fecha_nacimiento = fecha_nacimiento;
    this.rol_id = rol_id;
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
  public String getApellido() {
    return apellido;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  public String getClave() {
    return clave;
  }
  public void setClave(String clave) {
    this.clave = clave;
  }
  public Calendar getFecha_nacimiento() {
    return fecha_nacimiento;
  }
  public void setFecha_nacimiento(Calendar fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }
  public int getRol_id() {
    return rol_id;
  }
  public void setRol_id(int rol_id) {
    this.rol_id = rol_id;
  }
 
  

  

}
