/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.db;

import uzu.dao.*;
import uzu.model.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DbHelper2 {
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if(connection==null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost/PBO_2111083023");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            }
    return connection;
    }
    
    public static void main(String[] args) throws Exception{
        try {
            connection = DbHelper.getConnection();
            BukuDao dao = new BukuDaoimpl(connection);
            Buku buku = new Buku("B001", "Malin Kundang", "Uzunu","Marzah");
            dao.insert(buku);
            JOptionPane.showMessageDialog(null, "koneksi ok");
        } catch (SQLException ex) {
            JOptionPane.showInputDialog(null, ex.getMessage());
        }
        }
    }

