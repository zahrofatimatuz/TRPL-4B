package Model;

import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public Koneksi koneksi;
    private int result = 0;
    private static String soal[][] = new String[1][6];
    private static int level[] = {0, 0, 0};
    private static int skorTertinggi = 0;

    public UserModel() throws SQLException {
        koneksi = new Koneksi("mecin_db", "root", "");
    }

    public void tambahUser(String username, String password) throws SQLException {
        try {
            String query = "INSERT INTO `user` (`iduser`, `username`, `password`, "
                    + "`level1`, `level2`, `level3`, `skortertinggi`) VALUES "
                    + "(NULL, '" + username + "', '" + password + "', '1', '0', '0', '0');";
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
//

    public int getLevel1() {
        return level[0];
    }

    public int getLevel2() {
        return level[1];
    }

    public int getLevel3() {
        return level[2];
    }

    public void tambahLevel1() {
        level[0] += 1;
    }

    public void tambahLevel2() {
        level[1] += 1;
    }

    public void tambahLevel3() {
        level[2] += 1;
    }

    public int getskortertinggi() {
        return skorTertinggi;
    }

    public void setskortertinggi(int skor) {
        skorTertinggi = skor;
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
            if (rs.getRow() == 1) {
                rs.beforeFirst();
                rs.next();
                level[0] = rs.getInt("level1");
                level[1] = rs.getInt("level2");
                level[2] = rs.getInt("level3");
                skorTertinggi = rs.getInt("skortertinggi");

                for (int i = 0; i < 3; i++) {
                    System.out.println(level[i]);
                }
            }
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

    public void updateLevel(String username) {
        try {
            String query = "UPDATE `user` SET `level1`=" + level[0] + ",`"
                    + "level2`=" + level[1] + " ,`level3`=" + level[2] + " WHERE username ='" + username + "'";
            System.out.println(query);
            koneksi.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateSkorTertinggi(String username) {
        try {
            String query = "UPDATE `user` SET `skortertinggi`=" + skorTertinggi + " WHERE username ='" + username + "'";
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
