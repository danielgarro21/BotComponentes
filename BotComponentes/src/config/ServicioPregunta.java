/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pregunta;

/**
 *
 * @author Daniel Garro
 */

    
public class ServicioPregunta extends Servicio {

    @Override
    public void conectar() {
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se puedo registrar el driver...");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se puedo conectar...");
        }
    }

    public void agregarPregunta(Pregunta p) {

        try {
            this.conectar();
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO pregunta (idPegunta,contenido,fecha,chatId)" + " VALUES (?,?,?,?)";
            paInsertar = conn.prepareStatement(sql);
            paInsertar.setInt(1, p.getIdPregunta());
            paInsertar.setString(2, p.getContenido());
            paInsertar.setDate(3, p.getFecha());
            paInsertar.setString(4, p.getChatId());
    
            paInsertar.executeUpdate();

        } catch (Exception ex) {
            System.out.println("No se pudo subir la pregunta..");
        } finally {
            try {
                if (!paInsertar.isClosed()) {
                    paInsertar.close();
                }

                if (!stmt.isClosed()) {
                    stmt.close();
                }

                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("\nNo pude cerrar...");
            }
        }
    }

  
    }


