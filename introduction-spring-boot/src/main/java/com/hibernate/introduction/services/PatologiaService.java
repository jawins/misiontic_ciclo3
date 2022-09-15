package com.hibernate.introduction.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.introduction.model.Patologia;

public class PatologiaService {

    private SessionFactory factory;

  public PatologiaService() {
    // Crear objeto que permita fabricar sesiones
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Patologia.class)
        .buildSessionFactory();
  }

  private Session crearSesion() {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  public List<Patologia> obtenerPatologias() {
    List<Patologia> Patologias = new ArrayList<>();
    Session session = crearSesion();
    try {
      Patologias = session.createQuery("from Patologia", Patologia.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Patologias;
  }

  public Patologia obtenerPatologiaXId(int id) {
    Session session = crearSesion();
    Patologia Patologia = new Patologia();
    try {
      Patologia = session.find(Patologia.class, id);
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Patologia;
  }

  public List<Patologia> obtenerPatologiasXnombreApellido(String nombre, String apellido) {
    List<Patologia> Patologias = new ArrayList<>();
    Session session = crearSesion();
    try {
      Patologias = session.createQuery("from Patologia where nombre = :n and apellido = :a", Patologia.class)
          .setParameter("n", nombre)
          .setParameter("a", apellido)
          .list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Patologias;
  }

  public String crearPatologia(Patologia Patologia) {
    String message = "";
    Session session = crearSesion();
    try {
      session.persist(Patologia);
      session.getTransaction().commit();
      message = "Patologia creada con éxito";
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }

    return message;
  }

  public String actualizarPatologia(Patologia Patologia) {
    String message = "";
    Session session = crearSesion();
    try {
      session.merge(Patologia);
      session.getTransaction().commit();
      session.close();
      message = "Patologia actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    return message;
  }

  public String eliminarPatologia(int id) {
    String message = "";
    Session session = crearSesion();
    try {
      session.remove(obtenerPatologiaXId(id));
      session.getTransaction().commit();
      session.close();
      message = "Patologia eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

  public List<String> objToString(List<Patologia> Patologias) {
    List<String> PatologiasStr = new ArrayList<>();
    for (int i = 0; i < Patologias.size(); i++) {
      PatologiasStr.add(Patologias.get(i).toString());
    }
    return PatologiasStr;
  }
    
}
