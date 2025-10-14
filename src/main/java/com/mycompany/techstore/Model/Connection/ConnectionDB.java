/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techstore.Model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisd
 */
public class ConnectionDB {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            String url = "jdbc:mysql://localhost:3306/techstore";
            String user = "root";
            String password = "luisdev2025";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosaaaa");
        }catch(SQLException e){
            System.out.println("Error al conectar "+ e.getMessage());
        }
        return conn;
    }
}
