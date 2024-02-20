package model;
import java.util.UUID;
import java.util.Scanner;
import java.util.UUID;

/**
 * Die Klasse Superpower erzeugt Objekte vom Typ Superpower.
 * @param id ist eine zufällig verteilte, einzigartige ID, die einer Superpower bei Erzeugung zugewiesen wird.
 * @param name ist der Name einer Superpower.
 * @param actionDescription beschreibt die Funktion einer Superpower.
 * @author Anna Ditscherlein
 * @author Dilara Yildrim
 */
public class Superpower {
        private static Scanner scanner = new Scanner(System.in);
        private String id = UUID.randomUUID().toString();
        private String name;
        private String actionDescription;

        //Getter und Setter-Methoden  
        //name  
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
        //actionDescription
        public String getActionDescription() {
                return actionDescription;
        }

        public void setActionDescription(String actionDescription) {
                this.actionDescription = actionDescription;
        }
        
        /**
         * Konstruktor, der Name und Beschreibung der Superkraft setzt
        */
        //in spacepatrol app übernehmen
        public Superpower() {
                System.out.println("Bitte wählen Sie eine Superpower für Ihr Raumschiff aus. Sie können zwischen 1) Tarnung, 2) Selbstheilung und 3) Powerboost wählen. Bitte tippen Sie die Nummer Ihrer Wahl ein und drücken anschließend Enter.");
                int userInput = scanner.nextInt();
                if(userInput==1){
		        setName("Tarnung");
                        setActionDescription("Mit der Superpower 'Tarnung' können Sie für kurze Zeit Ihren Gegner angreifen, ohne dass er Sie sieht. Deshalb bekommen Sie in diesem Zeitraum weniger Schaden.");
                        }else{
                        if(userInput==2){
                                setName("Selbstheilung");
                                setActionDescription("Mit der Superpower 'Selbstheilung' kann sich Ihr Raumschiff während des Kampfes regenerieren und Lebenspunkte zurückgewinnen.");
                        }else{
                        if(userInput==3){
                                setName("Powerboost");
                                setActionDescription("Mit der Superpower 'Powerboost' hat Ihr Raumschiff für kurze Zeit doppelt so viel Kraft, wie normalerweise. Das heißt, dass dem Gegner doppelter Schaden hinzugefügt wird.");
                                }
                        }
                }
                System.out.println("Ihre Superpower wurde auf " + getName() + " gesetzt. " + getActionDescription());
        }

        @Override
        public String toString() {
        return name + ", " + actionDescription;
        }


}