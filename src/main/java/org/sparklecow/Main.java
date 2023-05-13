package org.sparklecow;

import org.sparklecow.dao.Usuario;
import org.sparklecow.dao.UsuarioImpl;


public class Main {

    public static void main(String[] args) {

        UsuarioImpl usuarioImpl = new UsuarioImpl();

        //Crear un usuario en base de datos.

        boolean creado = usuarioImpl.create("Jonathan David", "Ramos Gallego", "Bogota");
        System.out.println(creado);

        //Buscar un usuario en base de datos.

        String datosUsuario = usuarioImpl.findOne(1);
        System.out.println(datosUsuario);

        //Actualizar un usuario en base de datos

        datosUsuario = usuarioImpl.findOne(2);
        System.out.println(datosUsuario);
        boolean actualizado = usuarioImpl.update(2, "Juan Carlos", null);
        datosUsuario = usuarioImpl.findOne(2);
        System.out.println(datosUsuario);

        //Eliminar un usuario en base de datos

        datosUsuario = usuarioImpl.findOne(2);
        System.out.println(datosUsuario);
        boolean borrado = usuarioImpl.delete(2);
        datosUsuario = usuarioImpl.findOne(2);
        System.out.println(datosUsuario);
    }
}