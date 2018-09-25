/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trpl.pkg4b;

import Controller.UserController;
import Model.UserModel;
import View.HomeView;
import View.awalanView;
import java.sql.SQLException;

/**
 *
 * @author adheraprabu
 */
public class TRPL4B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        awalanView awal = new awalanView();
        UserModel userM = new UserModel();
        new UserController(awal,userM);
    }
    
}
