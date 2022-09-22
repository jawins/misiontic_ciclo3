package com.hibernate.introduction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Indicar que la clase Persona representa una entidad de la BD
@Entity
// Indicar la entidad/tabla que representa la clase Persona
@Table(name = "patologia")
public class Patologia {
      // ATRIBUTOS
      @Id
      private int id;
      private String nombre;
      private boolean habilitado;
      
     public Patologia() {
     }
     public Patologia(int id, String nombre, boolean habilitado) {
         this.id = id;
         this.nombre = nombre;
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
     
      public boolean isHabilitado() {
         return habilitado;
     }
     public void setHabilitado(boolean habilitado) {
         this.habilitado = habilitado;
     }
    
}
