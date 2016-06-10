package controleur;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.ExerciceDao;
import modele.metier.Exercice;
import vue.vueAccueil;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author btssio
 */
public class CtrlPrincipal {
    private List<Exercice> lesExercices;
    private vueAccueil vue;
    
    ChangeListener changeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        vue.getModeleListeExercices().removeAllElements();
        if (sourceTabbedPane.getTitleAt(index)== "Haut du corps"){
            vue.setCodeType(1);
           
            getAllExercicess(vue.getCodeType());
        }if (sourceTabbedPane.getTitleAt(index)== "Bas du corps"){
            
            vue.setCodeType(2);
            getAllExercicess(vue.getCodeType());
            
        }if (sourceTabbedPane.getTitleAt(index)== "Abdos"){
            
            vue.setCodeType(3);
            getAllExercicess(vue.getCodeType());
            }
      }
    };
    
   
    
    //Constructor

    public CtrlPrincipal(vueAccueil vue) {
        this.vue = vue;
        getAllExercicess(vue.getCodeType());
        vue.getjTabbedPane2().addChangeListener(changeListener);
    }

     public void getAllExercicess(int codeType)  {
            
        
        try {
            lesExercices = ExerciceDao.getExercices(codeType);
            for (Exercice unExercice : lesExercices) {
                vue.getModeleListeExercices().addElement(unExercice.getNom());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     }
    
    //Quitter l'application
        public void quitterApplication(){       
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Muscu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
        
        
   
    
    
}
