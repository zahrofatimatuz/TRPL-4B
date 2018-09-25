/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adheraprabu
 */
public class Koneksi {

    private Connection con;
    private Statement stm;

    public Connection getConnection() throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/Mecin_db", "root", "");
            System.out.println("Konesi ke Database BERHASIL");
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            System.out.println("Konesi ke Database GAGAL");
        }
        return con;
    }

    public void execute(String sql) throws SQLException {
        this.stm.executeUpdate(sql);
    }

    public ResultSet getResult(String sql) throws SQLException {
        return stm.executeQuery(sql);
    }

}
