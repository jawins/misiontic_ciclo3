package com.hibernate.introduction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Indicar que la clase Persona representa una entidad de la BD
@Entity
// Indicar la entidad/tabla que representa la clase Persona
@Table(name = "favoritos")
public class Favoritos {
// ATRIBUTOS
    @Id
     private int id;
     private int user_ide;
     private int menu_idmenu;
    public Favoritos() {

    }
    public Favoritos(int id, int user_ide, int menu_idmenu) {
        this.id = id;
        this.user_ide = user_ide;
        this.menu_idmenu = menu_idmenu;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_ide() {
        return user_ide;
    }
    public void setUser_ide(int user_ide) {
        this.user_ide = user_ide;
    }
    public int getMenu_idmenu() {
        return menu_idmenu;
    }
    public void setMenu_idmenu(int menu_idmenu) {
        this.menu_idmenu = menu_idmenu;
    }
    
    
}
