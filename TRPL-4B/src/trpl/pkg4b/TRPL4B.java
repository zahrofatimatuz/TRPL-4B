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
import View.banjir1View;
import java.sql.SQLException;

public class TRPL4B {

    
    public static void main(String[] args) throws SQLException {
        awalanView awal = new awalanView();
        banjir1View banjir = new banjir1View();
        UserModel userM = new UserModel();
        new UserController(banjir,userM);
    }    
}
