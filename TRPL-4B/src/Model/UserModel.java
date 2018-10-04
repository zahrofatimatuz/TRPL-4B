package Model;

import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public Koneksi koneksi;
    private int result = 0;

    public UserModel() throws SQLException {
        koneksi = new Koneksi("mecin_db", "root", "");
    }

    public void tambahUser(String username, String password) throws SQLException {
        try {
//            koneksi kon = new koneksi("ppl", "root", "");
            String query = "INSERT INTO `user`(`iduser`, `username`, `password`)"
                    + " VALUES (default,'" + username + "','" + password + "')";
            System.out.println(query);
            koneksi.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int cekUsername(String username) {
        try {
            String query = "select username from user where username = '" + username + "'";
            System.out.println(query);
            ResultSet rs = koneksi.getResult(query);
            rs.last();
            result = rs.getRow();
            System.out.println("result : " + result);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int getResult() {
        return result;
    }

    public boolean update(String query) throws SQLException {
        try {
            koneksi.execute(query);
            return true;
        } catch (Exception e) {
            return false;

        }
    }
}
