package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class UserModel {

    public Connection con;
    public Koneksi koneksi;
    
    public UserModel() throws SQLException {
        con = new Koneksi().getConnection();
    }

    public boolean save(String query) throws SQLException {
        try {
            koneksi.execute(query);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
