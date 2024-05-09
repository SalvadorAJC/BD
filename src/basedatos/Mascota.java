package basedatos;

import java.sql.*;
import java.io.*;

/**
 *
 * @author Black
 */
public class Mascota{
    //1. Conexión con la base de datos
    private Connection cn;
    //Insertar
    public boolean insertar(String nombre, int anio_nacimiento, 
            int anio_muerte, String causa_muerte, String especie) {
        boolean resultado = false;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection
        ("jdbc:mysql://localhost/mascotas", 
                    "root", "951487632938271");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "INSERT INTO mascota(nombre, anio_nacimiento, anio_muerte,causa_muerte, especie) "
                    + "VALUES('"+nombre+"',"+anio_nacimiento+","+anio_muerte+",'"+causa_muerte+"', '"+especie+"');";
            //3. Ejecución de la instrucción
            resultado = st.execute(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    //Consultar
    public ResultSet consultar() {
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection
        ("jdbc:mysql://localhost/mascotas", "root", "951487632938271");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = 
                    "SELECT * FROM mascota ORDER BY nombre ASC;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            //cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    //Actualizar 
    public int actualizar(int id, String nombre, int anio_nacimiento, 
            int anio_muerte, String causa_muerte, String especie) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection
        ("jdbc:mysql://localhost/mascotas", "root", "951487632938271");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql =
                    "UPDATE mascota SET "
                    + "nombre ='" + nombre +"', " 
                    + "anio_nacimiento = " + anio_nacimiento + ", "
                    + "anio_muerte = " + anio_muerte + ", "
                    + "causa_muerte = '" + causa_muerte + "', "
                    + "especie = '" + especie +"'"
                    + " WHERE id = "+ id +";";
            //3. Ejecución de la instrucción
            resultado = st.executeUpdate(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    //Eliminar
    public int eliminar(int id) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mascotas",
                    "root", "951487632938271");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = 
                    "DELETE FROM mascota WHERE id = "+
                    id +";";
            //3. Ejecución de la instrucción
            resultado = st.executeUpdate(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
        
    }
    
    public void cerrarConexion()
    {
        try{
        cn.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}