 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author ACHRAF
 */
public class MyDB {
    final String url ="jdbc:mysql://localhost:3306/medicanet";
    final String login ="root";
    final String pwd ="";
    Connection connection;
    static MyDB instance;

    public MyDB() {
        try{
        connection = DriverManager.getConnection(url, login, pwd);
        System.out.println("connexion etablie");
    }catch (SQLException ex) {
        System.out.println("Erreur de connexion"+ex.getMessage());}
    }
    public static MyDB getInstance(){
        if (instance==null)
        instance = new MyDB();
    return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
}
