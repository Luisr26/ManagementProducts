/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.techstore.App;

import com.mycompany.techstore.Model.Connection.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author luisd
 */
public class TechStore {

    public static void main(String[] args) throws SQLException {
        System.out.println("Iniciando TechStore.....");
        Connection conn = ConnectionDB.getConnection();
        if(conn != null){
            conn.close();
            System.out.println("Conexion Exitosa desde la clase Principal");
            System.out.println("🔒 Conexion Cerrada con exito!");
            
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Error "+ e.getMessage());
            }
            
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        }else{
            System.out.println("No se puedo conectar, Error!");
        }
    }
}
