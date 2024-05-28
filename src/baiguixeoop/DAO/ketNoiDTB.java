/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ketNoiDTB {
    public static Connection ketnoi(){   
    Connection con=null;
    try{
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=baidoxe;user=sa;password=an;encrypt=true;trustServerCertificate=true";
    con=DriverManager.getConnection(connectionUrl);
     }
 catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
     return con;}
}
