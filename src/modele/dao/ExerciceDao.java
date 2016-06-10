/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Exercice;

/**
 *
 * @author anas
 */
public class ExerciceDao {
    
    public static List<Exercice> getExercices(int type) throws SQLException, ClassNotFoundException {         
        List<Exercice> lesExercices = new ArrayList<Exercice>(); 
        Exercice unExercice;
        Jdbc jdbc = Jdbc.getInstance();      
        Statement state = jdbc.getConnexion().createStatement();
        ResultSet res = state.executeQuery("SELECT * FROM exercice where Code_Type ="+ type);    
        while (res.next()) {
            String nom = res.getString("nom");
            String muscleP = res.getString("muscleP");
            String muscleS = res.getString("muscleS");
            String details = res.getString("details");
            String Image = res.getString("Image");
            int code_type = res.getInt("code_type");
            unExercice = new Exercice(nom, muscleP, muscleS, details, Image, code_type);
            lesExercices.add(unExercice);
        }
        
        return lesExercices;
    }

    
}
