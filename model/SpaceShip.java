//imports
package model;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import javax.swing.Spring;

/**
 * Die Klasse SpaceShip erzeugt Objekte vom Typ SpaceShip.
 * @param id ist eine zufällig verteilte, einzigartige ID, die einem SpaceShip bei Erzeugung zugewiesen wird.
 * @param name ist der Name eines SpaceShips.
 * @param healthPointsCurrent ist der aktuelle Lebensstand eines Raumschiffs, welcher zu Beginn bei 50 liegt und durch Angriffe anderer Raumschiffe sinken kann.
 * @param healthPointsMax ist die Maximale HealthPointsAnzahl, die ein Raumschiff hat.
 * @param experiencePoints sind Punkte, die durch gewonnene Kämpfe gesammelt werden.
 * @param superkraft ist eine Superkraft (Tarnung, Selbstheilung, Powerboost).
 * @param readyToFight sagt beim Wahrheitswert true aus, dass ein SpaceShip Kampfbereit ist
 * @param inFight zeigt an, dass ein SpaceShip gerade in einem Kampf ist.
 * @param alive zeigt an, ob ein Raumschiff mehr als 0 Lebenspunkte hat, oder ob es dauerhaft besiegt ist.
 * @author Anna Ditscherlein
 * @author Dilara Yildrim
 */


public class SpaceShip {
    
    private static Scanner scanner = new Scanner(System.in);
    //Attribute
    private String id = UUID.randomUUID().toString();
    private String name;
    private int healthPointsCurrent = 50;
    private int healthPointsMax = 50;
    private int experiencePoints = 0;
    //private Superpower superkraft = new Superpower();
    private Superpower superkraft;
    private boolean readyToFight;
    private boolean inFight;
    private boolean alive;

  //Getter und Setter-Methoden  
  //name  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //hpcurrent
    public int getHealthPointsCurrent() {
        return healthPointsCurrent;
    }

    public void setHealthPointsCurrent(int healthPointsCurrent) {
        this.healthPointsCurrent = healthPointsCurrent;
    }
    //hpmax
    public int getHealthPointsMax() {
        return healthPointsMax;
    }

    public void setHealthPointsMax(int healthPointsMax) {
        this.healthPointsMax = healthPointsMax;
    }
    //exp
    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
    //superpower
    public Superpower getSuperkraft() {
        return superkraft;
    }

    public void setSuperkraft(Superpower superkraft) {
        this.superkraft = superkraft;
    }
    //fightstatus
    public boolean getReadyToFight() {
        return readyToFight;
    }

    public void setReadyToFight(boolean readyToFight) {
        this.readyToFight = readyToFight;
    }
    //inFight
    public boolean getInFight() {
        return inFight;
    }

    public void setInFight(boolean inFight) {
        this.inFight = inFight;
    }
    //alive
    public boolean getAlive() {
        return alive;
    }

    public void setalive(boolean alive) {
        this.alive = alive;
    }

    public int attack() {
        Random random = new Random();
        int damage = random.nextInt(6);

        if (random.nextDouble() <= 0) {
            damage *= 2;
        }
        return damage;
    }

    public void takeDamage(int damage) {
        healthPointsCurrent -= damage;

        if (healthPointsCurrent <= 0) {
            alive = false;
        }
    }

    public boolean flee() {
        Random random = new Random();
        return random.nextDouble() <= 0.8;
    }

    public void regenerate(){
        healthPointsCurrent = healthPointsMax;
        readyToFight = true;
    }

    
/** Methode, die die Attribute eines vom Spieler erstellten SpaceShips mit Werten versieht.
 * Zum Schluss werden Name und die zufällig verteilte ID auf der Konsole ausgegeben.
 * @param userInput wird durch Konsoleneingabe des Spielers definiert und dann als Name für das SpaceShip gesetzt.
 * 
 * */
public SpaceShip() {
    System.out.println("Bitte geben Sie einen Namen für Ihr Raumschiff ein.");
    String userInput = scanner.next();
    setName(userInput);
    System.out.println("Ihr Raumschiff heißt " + getName() + " und hat die ID " + getId() + ". Bitte notieren Sie sich die ID.");
    setSuperkraft(superkraft = new Superpower());
    
}
        
/**
 * Die Methode erstellt drei verschiedene SpaceShips, die bei jedem Spiel zur Verfügung stehen.
 * @param rocketsKraft @param ShootingStarsKraft @param milkyWayKraft Jedes SpaceShip hat eine Superkraft, welche aus ActionDespription und einem Namen besteht.
 */

public static void SpaceShips(){  
    
    SpaceShip rocket = new SpaceShip();
    Superpower rocketsKraft = new Superpower();
    rocketsKraft.setName("Tarnung");
    rocketsKraft.setActionDescription("Mit der Superpower 'Tarnung' können Sie für kurze Zeit Ihren Gegner angreifen, ohne dass er Sie sieht. Deshalb bekommen Sie in diesem Zeitraum weniger Schaden.");
    rocket.setName("rocket");
    rocket.setSuperkraft(rocketsKraft);

    SpaceShip shootingStar = new SpaceShip();
    Superpower shootingStarsKraft = new Superpower();
    shootingStarsKraft.setName("Selbstheilung");
    shootingStarsKraft.setActionDescription("Mit der Superpower 'Selbstheilung' kann sich Ihr Raumschiff während des Kampfes regenerieren und Lebenspunkte zurückgewinnen.");
    shootingStar.setName("shootingStar");
    shootingStar.setSuperkraft(shootingStarsKraft);

    SpaceShip milkyWay = new SpaceShip();
    Superpower milkyWayKraft = new Superpower();
    milkyWayKraft.setName("Powerboost");
    milkyWayKraft.setActionDescription("Mit der Superpower 'Powerboost' hat Ihr Raumschiff für kurze Zeit doppelt so viel Kraft, wie normalerweise. Das heißt, dass dem Gegner doppelter Schaden hinzugefügt wird.");
    milkyWay.setName("milkyWay");
    milkyWay.setSuperkraft(milkyWayKraft);
        }


}
