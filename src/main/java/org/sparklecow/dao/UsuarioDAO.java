package org.sparklecow.dao;

import java.util.List;

public interface UsuarioDAO{

    public boolean create(String nombre, String apellido, String ciudad);

    public String findOne(int id);

    public boolean update(int id, String nombre, String apellido);

    public boolean delete(int id);

}
