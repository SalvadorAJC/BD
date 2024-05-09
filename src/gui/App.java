/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import basedatos.Mascota;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Black
 */
public class App {

    public static void main(String args[]) {
        //crear el objeto del modelo
        Mascota mascota = new Mascota();
 
        //insertar
        //mascota.actualizar(9,"Cartucho", 2003, 2020, "Lo atropello un carro","Perro ");
        //mascota.insertar("chaparro", 2000, 0, "", "perro");
        //mascota.insertar("blanco", 2000, 2009, "envenenado", "perro");
        //mascota.insertar("rocky", 2000, 2010, "viejo", "perro");
        //consultar
        ResultSet tabla = mascota.consultar();
        tabla = null;
        if (tabla != null) {
            try {
                while (tabla.next()) {
                    System.out.print(tabla.getInt("id") + ",");
                    System.out.print(tabla.getString("nombre") + ",");
                    System.out.print(tabla.getInt(3) + ",");
                    System.out.print(tabla.getInt(4) + ",");
                    System.out.print(tabla.getString(5) + ",");
                    System.out.print(tabla.getString(6) + "\n");
                }
                tabla.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mascota.cerrarConexion();
        }

        mascota.actualizar(9, "cartucho", 2003, 2020, "lo atropello un carro", "perro");
        //mascota.eliminar(9);
        //consultar
        tabla = mascota.consultar();
        //tabla = null;
        if (tabla != null) {
            try {
                while (tabla.next()) {
                    System.out.print(tabla.getInt("id") + ",");
                    System.out.print(tabla.getString("nombre") + ",");
                    System.out.print(tabla.getInt(3) + ",");
                    System.out.print(tabla.getInt(4) + ",");
                    System.out.print(tabla.getString(5) + ",");
                    System.out.print(tabla.getString(6) + "\n");
                }
                tabla.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mascota.cerrarConexion();
        }
    }

}
