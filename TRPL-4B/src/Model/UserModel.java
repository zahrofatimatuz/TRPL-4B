package Model;

import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public Koneksi koneksi;
    private int result = 0;
    private static String soal[][] = new String[1][6];

    public UserModel() throws SQLException {
        koneksi = new Koneksi("mecin_db", "root", "");
    }

    public void tambahUser(String username, String password) throws SQLException {
        try {
            String query = "INSERT INTO `user`(`iduser`, `username`, `password`)"
                    + " VALUES (default,'" + username + "','" + password + "')";
            System.out.println(query);
            koneksi.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ambilSoal(int id) {
        try {
            String query = "SELECT s.Soal, p.pilihanA, p.pilihanB, p.pilihanC, p.pilihanD, "
                    + "j.jawaban from Soal s join pilihanganda p on s.idJawaban = "
                    + "p.idPilihanGanda join jawaban j on s.idJawaban = j.idJawaban WHERE S.idSoal = " + id + "";
            ResultSet rs = koneksi.getResult(query);
            rs.last();
            if (rs.getRow() == 1) {
                rs.beforeFirst();
                rs.next();
                soal[0][0] = rs.getString("s.soal");
                soal[0][1] = rs.getString("p.pilihanA");
                soal[0][2] = rs.getString("p.pilihanB");
                soal[0][3] = rs.getString("p.pilihanC");
                soal[0][4] = rs.getString("p.pilihanD");
                soal[0][5] = rs.getString("j.jawaban");

                for (int i = 0; i < 6; i++) {
                    System.out.println(soal[0][i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getSoal00() {
        return soal[0][0];
    }

    public String getSoal01() {
        return soal[0][1];
    }

    public String getSoal02() {
        return soal[0][2];
    }

    public String getSoal03() {
        return soal[0][3];
    }

    public String getSoal04() {
        return soal[0][4];
    }

    public String getSoal05() {
        return soal[0][5];
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

    public int Login(String username, String password) {
        try {
            String query = "SELECT * FROM `user` WHERE username = '" + username + "' and password = '" + password + "'";
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

    public int cekPasswordLama(String username, String password) {
        try {
            String query = "SELECT * FROM `user` WHERE username = '" + username + "' and password = '" + password + "'";
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

    public void updatePassword(String username, String password) {
        try {
            String query = "UPDATE `user` SET `password`='" + password + "' WHERE username = '" + username + "'";
            System.out.println(query);
            koneksi.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getResult() {
        return result;
    }

}
