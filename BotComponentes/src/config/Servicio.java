/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Daniel Garro
 */
public abstract class Servicio {
      protected String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    protected String DB_URL = "jdbc:mysql://localhost:3306/componentes-project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    //  Database credentials
    protected String USER = "root";
    protected String PASS = "adminadmin";
    protected PreparedStatement paInsertar;
    protected Connection conn = null;
    protected Statement stmt = null;

    public abstract void conectar();
}


