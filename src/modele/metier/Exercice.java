
package modele.metier;

/**
 *
 * @author anas
 */
public class Exercice {
    private String Nom;
    private String muscleP;
    private String muscleS;
    private String details;
    private String Image;
    private int code_type;

    
    //Constructor
    public Exercice(String Nom, String muscleP, String muscleS, String details, String Image, int code_type) {
        this.Nom = Nom;
        this.muscleP = muscleP;
        this.muscleS = muscleS;
        this.details = details;
        this.Image = Image;
        this.code_type = code_type;
    }

    
    //Getters
    public String getNom() {
        return Nom;
    }

    public String getMuscleP() {
        return muscleP;
    }

    public String getMuscleS() {
        return muscleS;
    }

    public String getDetails() {
        return details;
    }

    public String getImage() {
        return Image;
    }

    public int getCode_type() {
        return code_type;
    }

    
    //Setters
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setMuscleP(String muscleP) {
        this.muscleP = muscleP;
    }

    public void setMuscleS(String muscleS) {
        this.muscleS = muscleS;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public void setCode_type(int code_type) {
        this.code_type = code_type;
    }
    
    
    
    
    
}
