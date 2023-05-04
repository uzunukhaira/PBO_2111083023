/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzu270423.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author LABP1KOMP
 */
public class Koneksi {
    private Connection connection;
    private String url = "jdbc:mysql://localhost/PBO_2111083023";
    private String username = "root";
    private String password = "";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) {
        try {
            Koneksi k = new Koneksi();
            k.getConnection();
            JOptionPane.showMessageDialog(null, "Koneksi Ok");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal "+ex.getMessage());
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal "+ex.getMessage());
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
