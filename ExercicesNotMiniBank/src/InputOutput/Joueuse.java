package InputOutput;

import java.util.List;
import java.util.Map;

public final class Joueuse {
    private String nom;
    private String prenom;
    private int age;
    private String equipe;

    // Constructeurs
    public Joueuse(){}
    public Joueuse(String nom, String prenom, int age, String equipe){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.equipe = equipe;
    }

    // Getters
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public int getAge(){
        return age;
    }
    public String getEquipe(){
        return equipe;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString(){
        return("Joueuse : \nNom : " + nom + ", Prénom : " + prenom + ", Age : " + age + ", Equipe : " + equipe);
    }

    public static void printPlayers(List<Joueuse> joueuses){
        System.out.print("Liste des joueuses \n");
        for(Joueuse joueuse: joueuses){
            System.out.println(joueuse.toString());
        }
    }
}
