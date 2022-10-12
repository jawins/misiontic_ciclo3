package com.hibernate.introduction.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.introduction.model.Menu;

public class MenuService {

    // Atributos
  private SessionFactory factory;

  public MenuService() {
    // Crear objeto que permita fabricar sesiones
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Menu.class)
        .buildSessionFactory();
  }

  private Session crearSesion() {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  public List<Menu> obtenerMenus() {
    List<Menu> Menus = new ArrayList<>();
    Session session = crearSesion();
    try {
      Menus = session.createQuery("from Menu", Menu.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Menus;
  }

  public Menu obtenerMenuXId(int id) {
    Session session = crearSesion();
    Menu Menu = new Menu();
    try {
      Menu = session.find(Menu.class, id);
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Menu;
  }

  public List<Menu> obtenerMenusXnombreApellido(String nombre) {
    List<Menu> Menus = new ArrayList<>();
    Session session = crearSesion();
    try {
      Menus = session.createQuery("from Menu where nombre like :n", Menu.class)
          .setParameter("n","%"+nombre+"%")
          .list();
          System.out.println("consultado");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    return Menus;
  }

  public Menu obtenerCalificacion(int id,int op) {
    Menu menu =null;
    menu = obtenerMenuXId(id);
    if(op==1){
        menu.setCalificacionup(menu.getCalificacionup()+1);
        actualizarMenu(menu);
    }
    if(op==2){
      menu.setCalificaciondown(menu.getCalificaciondown()+1);
      actualizarMenu(menu);
    }
    menu = obtenerMenuXId(id);
    return menu;
  }

  public String crearMenu(Menu Menu) {
    String message = "";
    Session session = crearSesion();
    try {
      session.persist(Menu);
      session.getTransaction().commit();
      message = "Menu creada con éxito";
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }

    return message;
  }

  public String actualizarMenu(Menu Menu) {
    String message = "";
    Session session = crearSesion();
    try {
      session.merge(Menu);
      session.getTransaction().commit();
      session.close();
      message = "Menu actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    return message;
  }

  public String eliminarMenu(int id) {
    String message = "";
    Session session = crearSesion();
    try {
      session.remove(obtenerMenuXId(id));
      session.getTransaction().commit();
      session.close();
      message = "Menu eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

  public List<String> objToString(List<Menu> Menus) {
    List<String> MenusStr = new ArrayList<>();
    for (int i = 0; i < Menus.size(); i++) {
      MenusStr.add(Menus.get(i).toString());
    }
    return MenusStr;
  }
    
}
