package com.hibernate.introduction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indicar que la clase Persona representa una entidad de la BD
@Entity
// Indicar la entidad/tabla que representa la clase Persona
@Table(name = "menu_has_patologia")
public class Menu_has_patologia {
    // ATRIBUTOS
    @Id
    private int id;
    private int menu_idmenu;
    private int patologia_idpatologia;

    public Menu_has_patologia() {
    }
    public Menu_has_patologia(int id, int menu_idmenu, int patologia_idpatologia) {
        this.id = id;
        this.menu_idmenu = menu_idmenu;
        this.patologia_idpatologia = patologia_idpatologia;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMenu_idmenu() {
        return menu_idmenu;
    }
    public void setMenu_idmenu(int menu_idmenu) {
        this.menu_idmenu = menu_idmenu;
    }
    public int getPatologia_idpatologia() {
        return patologia_idpatologia;
    }
    public void setPatologia_idpatologia(int patologia_idpatologia) {
        this.patologia_idpatologia = patologia_idpatologia;
    }

    
}
