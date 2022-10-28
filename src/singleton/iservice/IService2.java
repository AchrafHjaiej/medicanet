/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.iservice;

import java.util.List;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author LENOVO
 */

  public interface IService2<R> {
    void ajouter2(R r) throws SQLException;
    boolean update (R r) throws SQLException;
    boolean delete (R r) throws SQLException;
     List<R> readAll() throws SQLException;
}



        