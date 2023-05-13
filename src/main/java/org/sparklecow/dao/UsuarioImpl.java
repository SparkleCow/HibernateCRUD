package org.sparklecow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UsuarioImpl implements UsuarioDAO{
    @Override
    public boolean create(String nombre, String apellido, String ciudad) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            Usuario usuario = new Usuario(nombre, apellido, ciudad);
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch(Exception e){
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public String findOne(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            session.close();
            return usuario.toString();
        }catch(Exception e){
            e.getStackTrace();
        }
        return "Error al encontrar al usuario. Es posible que no exista o ya no se encuentre en la base de datos";
    }

    @Override
    public boolean update(int id, String nombre, String apellido) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if(nombre!=null){
                usuario.setNombre(nombre);
            }else if(apellido!=null){
                usuario.setApellido(apellido);
            }
            session.update(usuario);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch(Exception e){
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch(Exception e){
            e.getStackTrace();
        }
        return false;
    }
}
