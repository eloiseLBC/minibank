package InputOutput;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static InputOutput.Joueuse.printPlayers;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File fichier = new File("ExercicesNotMiniBank/src/InputOutput/joueuses.json");
            if (!fichier.exists()) {
                System.out.println("Le fichier joueuses.json n'existe pas.");
                return;
            }
            // Lire le JSON en tant que Map
            Map<String, List<Joueuse>> jsonMap = objectMapper.readValue(fichier, new TypeReference<>(){});
            // Extraire la liste des joueuses
            List<Joueuse> joueuses = jsonMap.get("joueuses");
            printPlayers(joueuses);
            // Supprimer la joueuses numéro 1
            Joueuse playerToRemove = joueuses.remove(0);
            System.out.println("Joueuse supprimée  = " + playerToRemove);
            // Sauvegarder la nouvelle liste dans le fichier
            jsonMap.put("joueuses", joueuses);
            objectMapper.writeValue(fichier, jsonMap);
            System.out.println("Fichier mis à jour !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
            e.printStackTrace();
        }
    }
}