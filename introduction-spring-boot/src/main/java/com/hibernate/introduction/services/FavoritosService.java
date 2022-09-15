package com.hibernate.introduction.services;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.model.Favoritos;

public class FavoritosService {


    // Atributos
  private SessionFactory factory;

  public FavoritosService() {
    // Crear objeto que permita fabricar sesiones
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Favoritos.class)
        .buildSessionFactory();
  }

  private Session crearSesion() {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  public List<Favoritos> obtenerFavoritoss() {
    List<Favoritos> Favoritoss = new ArrayList<>();
    Session session = crearSesion();
    try {
      Favoritoss = session.createQuery("from Favoritos", Favoritos.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Favoritoss;
  }

  public Favoritos obtenerFavoritosXId(int id) {
    Session session = crearSesion();
    Favoritos Favoritos = new Favoritos();
    try {
      Favoritos = session.find(Favoritos.class, id);
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Favoritos;
  }

  public List<Favoritos> obtenerFavoritossXnombreApellido(String nombre, String apellido) {
    List<Favoritos> Favoritoss = new ArrayList<>();
    Session session = crearSesion();
    try {
      Favoritoss = session.createQuery("from Favoritos where nombre = :n and apellido = :a", Favoritos.class)
          .setParameter("n", nombre)
          .setParameter("a", apellido)
          .list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Favoritoss;
  }

  public String crearFavoritos(Favoritos Favoritos) {
    String message = "";
    Session session = crearSesion();
    try {
      session.persist(Favoritos);
      session.getTransaction().commit();
      message = "Favoritos creada con éxito";
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }

    return message;
  }

  public String actualizarFavoritos(Favoritos Favoritos) {
    String message = "";
    Session session = crearSesion();
    try {
      session.merge(Favoritos);
      session.getTransaction().commit();
      session.close();
      message = "Favoritos actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    return message;
  }

  public String eliminarFavoritos(int id) {
    String message = "";
    Session session = crearSesion();
    try {
      session.remove(obtenerFavoritosXId(id));
      session.getTransaction().commit();
      session.close();
      message = "Favoritos eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

  public List<String> objToString(List<Favoritos> Favoritoss) {
    List<String> FavoritossStr = new ArrayList<>();
    for (int i = 0; i < Favoritoss.size(); i++) {
      FavoritossStr.add(Favoritoss.get(i).toString());
    }
    return FavoritossStr;
  }
    
}
