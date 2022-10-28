/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.iservice;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ACHRAF
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    void ajouter2(T t) throws SQLException;
    boolean update (T t) throws SQLException;
    boolean delete (T t) throws SQLException;
    List<T> readAll() throws SQLException;
    
}
