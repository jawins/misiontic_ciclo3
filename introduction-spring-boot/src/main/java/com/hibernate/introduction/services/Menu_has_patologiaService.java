package com.hibernate.introduction.services;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.introduction.model.Menu_has_patologia;
public class Menu_has_patologiaService {
    
    // Atributos
  private SessionFactory factory;

  public Menu_has_patologiaService() {
    // Crear objeto que permita fabricar sesiones
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Menu_has_patologia.class)
        .buildSessionFactory();
  }

  private Session crearSesion() {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  public List<Menu_has_patologia> obtenerMenu_has_patologias() {
    List<Menu_has_patologia> Menu_has_patologias = new ArrayList<>();
    Session session = crearSesion();
    try {
      Menu_has_patologias = session.createQuery("from Menu_has_patologia", Menu_has_patologia.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Menu_has_patologias;
  }

  public Menu_has_patologia obtenerMenu_has_patologiaXId(int id) {
    Session session = crearSesion();
    Menu_has_patologia Menu_has_patologia = new Menu_has_patologia();
    try {
      Menu_has_patologia = session.find(Menu_has_patologia.class, id);
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Menu_has_patologia;
  }

  public List<Menu_has_patologia> obtenerMenu_has_patologiasXnombreApellido(String nombre, String apellido) {
    List<Menu_has_patologia> Menu_has_patologias = new ArrayList<>();
    Session session = crearSesion();
    try {
      Menu_has_patologias = session.createQuery("from Menu_has_patologia where nombre = :n and apellido = :a", Menu_has_patologia.class)
          .setParameter("n", nombre)
          .setParameter("a", apellido)
          .list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Menu_has_patologias;
  }

  public String crearMenu_has_patologia(Menu_has_patologia Menu_has_patologia) {
    String message = "";
    Session session = crearSesion();
    try {
      session.persist(Menu_has_patologia);
      session.getTransaction().commit();
      message = "Menu_has_patologia creada con éxito";
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }

    return message;
  }

  public String actualizarMenu_has_patologia(Menu_has_patologia Menu_has_patologia) {
    String message = "";
    Session session = crearSesion();
    try {
      session.merge(Menu_has_patologia);
      session.getTransaction().commit();
      session.close();
      message = "Menu_has_patologia actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    return message;
  }

  public String eliminarMenu_has_patologia(int id) {
    String message = "";
    Session session = crearSesion();
    try {
      session.remove(obtenerMenu_has_patologiaXId(id));
      session.getTransaction().commit();
      session.close();
      message = "Menu_has_patologia eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

  public List<String> objToString(List<Menu_has_patologia> Menu_has_patologias) {
    List<String> Menu_has_patologiasStr = new ArrayList<>();
    for (int i = 0; i < Menu_has_patologias.size(); i++) {
      Menu_has_patologiasStr.add(Menu_has_patologias.get(i).toString());
    }
    return Menu_has_patologiasStr;
  }

    
}
