package com.hibernate.introduction.services;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.model.Rol;
public class RolService {
    // Atributos
    private SessionFactory factory;




    public RolService() {
        // Crear objeto que permita fabricar sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Rol.class)
        .buildSessionFactory();
    }

    private Session crearSesion() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
      }
    
      public List<Rol> obtenerRols() {
        List<Rol> Rols = new ArrayList<>();
        Session session = crearSesion();
        try {
          Rols = session.createQuery("from Rol", Rol.class).list();
          session.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return Rols;
      }
    
      public Rol obtenerRolXId(int id) {
        Session session = crearSesion();
        Rol Rol = new Rol();
        try {
          Rol = session.find(Rol.class, id);
          session.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return Rol;
      }
    
      public List<Rol> obtenerRolsXnombreApellido(String nombre, String apellido) {
        List<Rol> Rols = new ArrayList<>();
        Session session = crearSesion();
        try {
          Rols = session.createQuery("from Rol where nombre = :n and apellido = :a", Rol.class)
              .setParameter("n", nombre)
              .setParameter("a", apellido)
              .list();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return Rols;
      }
    
      public String crearRol(Rol Rol) {
        String message = "";
        Session session = crearSesion();
        try {
          session.persist(Rol);
          session.getTransaction().commit();
          message = "Rol creada con éxito";
          session.close();
        } catch (Exception e) {
          e.printStackTrace();
          message = e.getMessage();
        }
    
        return message;
      }
    
      public String actualizarRol(Rol Rol) {
        String message = "";
        Session session = crearSesion();
        try {
          session.merge(Rol);
          session.getTransaction().commit();
          session.close();
          message = "Rol actualizada con éxito";
        } catch (Exception e) {
          e.printStackTrace();
          message = e.getMessage();
        }
        return message;
      }
    
      public String eliminarRol(int id) {
        String message = "";
        Session session = crearSesion();
        try {
          session.remove(obtenerRolXId(id));
          session.getTransaction().commit();
          session.close();
          message = "Rol eliminada con éxito";
        } catch (Exception e) {
          message = e.getMessage();
        }
        return message;
      }
    
      public List<String> objToString(List<Rol> Rols) {
        List<String> RolsStr = new ArrayList<>();
        for (int i = 0; i < Rols.size(); i++) {
          RolsStr.add(Rols.get(i).toString());
        }
        return RolsStr;
      }
}
