
import views.v_login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Klaus
 */
public class Applications {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new v_login().setVisible(true);
        });
    }
}
