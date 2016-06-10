/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muscu;

import controleur.CtrlPrincipal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modele.dao.Jdbc;
import vue.vueAccueil;

/**
 *
 * @author anas
 */
public class Muscu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        //Data base connection
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "PMuscu", "root", "");
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        
        vueAccueil vue = new vueAccueil();
        
        CtrlPrincipal ctrl = new CtrlPrincipal(vue);
         vue.setVisible(true);
    }
    
}
